package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestRepository extends CrudRepository<User, String> {
    @Override
    Optional<User> findById(String login);
}
