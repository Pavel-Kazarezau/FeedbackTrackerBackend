package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.FeedbackItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "feedbacks", path = "feedbacks")
public interface FeedbackRestRepository extends CrudRepository<FeedbackItem, Integer> {

    @Override
    Iterable<FeedbackItem> findAll();

    @Override
    Optional<FeedbackItem> findById(Integer id);
}
