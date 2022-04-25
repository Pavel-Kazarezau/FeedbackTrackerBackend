package by.paka.FeedbackTracker;

import by.paka.FeedbackTracker.rest.config.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RestConfig.class)
public class FeedbackTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackTrackerApplication.class, args);
	}

}
