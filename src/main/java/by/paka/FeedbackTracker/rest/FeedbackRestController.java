package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackRestController {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackRestController(FeedbackRepository repository) {
        this.feedbackRepository = repository;
    }

    @PutMapping("feedbacks")
    public @ResponseBody ResponseEntity<?> update(@RequestBody FeedbackItem item) {
        final FeedbackItem feedbackItem = feedbackRepository.updateFeedbackItem(item);
        return ResponseEntity.ok(feedbackItem);
    }
}
