package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import by.paka.FeedbackTracker.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public void createFeedbackItem(FeedbackItem item) {
        feedbackRepository.createFeedbackItem(item);
    }
}
