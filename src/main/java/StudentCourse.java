import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student_course")
@Data
@IdClass(StudentCourse.StudentCourseKey.class)
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
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
