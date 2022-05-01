package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestRepository extends CrudRepository<SystemUser, String> {
    @Override
    Optional<SystemUser> findById(String login);
}
