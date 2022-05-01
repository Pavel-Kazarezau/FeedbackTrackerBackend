package by.paka.FeedbackTracker.service;

import by.paka.FeedbackTracker.model.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    SystemUser saveUser(SystemUser user);
}
