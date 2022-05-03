package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.Bot;
import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import by.paka.FeedbackTracker.service.FeedbackResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackResponseServiceImpl implements FeedbackResponseService {
    private final FeedbackRepository feedbackRepository;
    private final Bot bot;

    @Override
    public FeedbackItem updateFeedbackItem(FeedbackItem item) {
        item.setIsCompleted(true);
        final FeedbackItem updatedFeedbackItem = feedbackRepository.save(item);
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(updatedFeedbackItem.getUserId()));
        message.setText(updatedFeedbackItem.getResponseItem().getResponse());
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return updatedFeedbackItem;
    }
}
