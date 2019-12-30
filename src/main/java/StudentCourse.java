import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(StudentCourse.StudentCourseKey.class)
@Table(name = "student_course")
@Data
public class StudentCourse {
    @Id
    private int course_id;
    @Id
    private int student_id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "course_name")
    private String courseName;
    private int price;

    @EqualsAndHashCode
    @ToString
    public class StudentCourseKey implements Serializable {

        static final long serialVersionUID = 1L;

        @Getter
        @Setter
        private int course_id;

        @Getter
        @Setter
        private int student_id;

    }

}
