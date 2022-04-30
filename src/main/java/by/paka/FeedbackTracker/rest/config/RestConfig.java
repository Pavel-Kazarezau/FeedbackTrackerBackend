package by.paka.FeedbackTracker.rest.config;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.model.ResponseItem;
import by.paka.FeedbackTracker.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry cors) {
        repositoryRestConfiguration.exposeIdsFor(FeedbackItem.class, ResponseItem.class, User.class);
    }
}
