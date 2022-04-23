package by.paka.FeedbackTracker.repository.impl;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createFeedbackItem(FeedbackItem item) {
        entityManager.persist(item);
    }
}
