package by.paka.FeedbackTracker.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class FeedbackItem {
    @Id
    private Integer id;

    private String text;

    private Long userId;

    @OneToOne( cascade = CascadeType.ALL)
    private ResponseItem responseItem;

    private Boolean isCompleted = false;

}
