import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;
    private String description;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Teacher teacher;
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "subscriptions",
    joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students;
    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;
    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    public String toString()
    {
        return name;
    }

}
