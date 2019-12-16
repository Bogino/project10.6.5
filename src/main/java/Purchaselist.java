import lombok.Data;
import net.bytebuddy.matcher.InheritedAnnotationMatcher;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "purchaselist")
public class Purchaselist {
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;


}
