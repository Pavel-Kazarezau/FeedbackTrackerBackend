package by.paka.FeedbackTracker;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final FeedbackService feedbackService;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if ("/start".equals(update.getMessage().getText())) {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(update.getMessage().getChatId()));
                message.setText("Вы можете написать свою жалобу или предложения, они будут рассмотрены в кратчайшие сроки");
                execute(message);
            } else {
                final FeedbackItem feedbackItem = new FeedbackItem();
                feedbackItem.setId(update.getUpdateId());
                feedbackItem.setText(update.getMessage().getText());
                feedbackItem.setUserId(update.getMessage().getFrom().getId());
                feedbackItem.setDate(new Date());
                feedbackService.createFeedbackItem(feedbackItem);

                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(update.getMessage().getChatId()));
                message.setText("Ваше предложение рассмотрено, скоро вам придет ответ!");
                execute(message);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
