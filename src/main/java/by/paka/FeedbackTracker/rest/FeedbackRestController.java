package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackRestController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackRestController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PutMapping("update/feedbacks")
    public @ResponseBody ResponseEntity<?> update(@RequestBody FeedbackItem item) {
        final FeedbackItem feedbackItem = feedbackService.updateFeedbackItem(item);
        return ResponseEntity.ok(feedbackItem);
    }
}
