package by.paka.FeedbackTracker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class FeedbackItem {
    @Id
    private Integer id;

    @Column(length = 4000)
    private String text;

    private Long userId;

    @OneToOne( cascade = CascadeType.ALL)
    private ResponseItem responseItem;

    private Boolean isCompleted = false;

}
