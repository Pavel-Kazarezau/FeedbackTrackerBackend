package by.paka.FeedbackTracker.service;

import by.paka.FeedbackTracker.model.FeedbackItem;

public interface FeedbackService {

    FeedbackItem createFeedbackItem(FeedbackItem item);

    FeedbackItem updateFeedbackItem(FeedbackItem item);
}
