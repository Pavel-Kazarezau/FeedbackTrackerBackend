package by.paka.FeedbackTracker.rest;

import by.paka.FeedbackTracker.model.FeedbackItem;
import by.paka.FeedbackTracker.service.FeedbackResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackRestController {
    private final FeedbackResponseService feedbackService;

    @Autowired
    public FeedbackRestController(FeedbackResponseService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PutMapping("update/feedbacks")
    public @ResponseBody ResponseEntity<?> update(@RequestBody FeedbackItem item) {
        final FeedbackItem feedbackItem = feedbackService.updateFeedbackItem(item);
        return ResponseEntity.ok(feedbackItem);
    }
}
