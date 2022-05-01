package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import by.paka.FeedbackTracker.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override

    public FeedbackItem createFeedbackItem(FeedbackItem item) {
        return feedbackRepository.save(item);
    }

    @Override
    public FeedbackItem updateFeedbackItem(FeedbackItem item) {
        return feedbackRepository.save(item);
    }
}
