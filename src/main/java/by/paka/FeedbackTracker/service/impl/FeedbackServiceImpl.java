package by.paka.FeedbackTracker.service.impl;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import by.paka.FeedbackTracker.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Override
    public FeedbackItem createFeedbackItem(FeedbackItem item) {
        return feedbackRepository.save(item);
    }
}
