import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.validation.Schema;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql1 = "insert into StudentCourse(courseId, studentId) select courseId, studentId from Subscription";
        String hql2 = "insert into StudentCourse(courseName, studentName, subscriptionDate, price) select courseName, studentName, subscriptionDate, price " +
                "from Purchaselist";
        Query query1 = session.createQuery(hql1);
        Query query2 = session.createQuery(hql2);

        transaction.commit();
        session.close();


        sessionFactory.close();

    }
}
