package by.paka.FeedbackTracker;

import by.paka.FeedbackTracker.model.Role;
import by.paka.FeedbackTracker.model.SystemUser;
import by.paka.FeedbackTracker.rest.config.RestConfig;
import by.paka.FeedbackTracker.service.RoleService;
import by.paka.FeedbackTracker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@Import(RestConfig.class)
public class FeedbackTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackTrackerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
            final Role adminRole = roleService.saveRole(new Role(null, "ADMIN"));
            userService.saveUser(new SystemUser("admin", "admin", List.of(adminRole)));
        };
    }
}
