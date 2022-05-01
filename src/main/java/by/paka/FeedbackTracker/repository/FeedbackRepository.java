package by.paka.FeedbackTracker.repository;

import by.paka.FeedbackTracker.model.FeedbackItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedbackRepository extends JpaRepository<FeedbackItem, Integer> {
    @Override
    FeedbackItem save(FeedbackItem feedbackItem);
}
