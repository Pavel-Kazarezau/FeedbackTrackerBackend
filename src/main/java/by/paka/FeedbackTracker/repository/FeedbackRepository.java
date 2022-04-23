package by.paka.FeedbackTracker.repository;

import by.paka.FeedbackTracker.model.FeedbackItem;


public interface FeedbackRepository {

    void createFeedbackItem(FeedbackItem item);
}
