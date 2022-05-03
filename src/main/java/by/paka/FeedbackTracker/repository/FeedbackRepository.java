package by.paka.FeedbackTracker.repository;

import by.paka.FeedbackTracker.model.FeedbackItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FeedbackRepository extends JpaRepository<FeedbackItem, Integer> {

    List<FeedbackItem> getFeedbackItemByIsCompletedFalse();
}
