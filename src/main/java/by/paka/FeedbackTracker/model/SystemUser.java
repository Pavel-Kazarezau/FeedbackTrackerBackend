package by.paka.FeedbackTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser {
    @Id
    String login;
    String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
