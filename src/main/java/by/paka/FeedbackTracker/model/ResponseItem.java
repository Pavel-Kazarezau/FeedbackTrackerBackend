package by.paka.FeedbackTracker.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ResponseItem {
    @Id
    private Integer feedbackItemId;

    @Column(length = 1500)
    private String response;

    private Date date;

}
