package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.FeedbackItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "feedbacks", path = "feedbacks")
public interface FeedbackRestController extends PagingAndSortingRepository<FeedbackItem, Long> {

    @Override
    Iterable<FeedbackItem> findAll();

    @Override
    Optional<FeedbackItem> findById(Long id);

    @Override
    FeedbackItem save(FeedbackItem feedbackItem);

}
