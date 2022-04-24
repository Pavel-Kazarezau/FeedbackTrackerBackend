package by.paka.FeedbackTracker.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ResponseItem {
    @Id
    private Integer feedbackItemId;

    private String response;

}
