package by.paka.FeedbackTracker.repository.impl;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public FeedbackItem updateFeedbackItem(FeedbackItem item) {
        return entityManager.merge(item);
    }
}
