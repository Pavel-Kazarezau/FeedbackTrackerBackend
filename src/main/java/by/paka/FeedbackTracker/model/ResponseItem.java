package by.paka.FeedbackTracker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ResponseItem {
    @Id
    private Long feedbackItemId;

    private String response;

}
