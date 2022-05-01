package by.paka.FeedbackTracker.repository;

import by.paka.FeedbackTracker.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SystemUser, String> {
}
