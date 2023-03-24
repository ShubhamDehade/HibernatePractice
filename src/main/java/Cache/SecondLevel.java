package Cache;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SecondLevel {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();
        ses.beginTransaction();
        Student s1;

       // s1=(Student) ses.get(Student.class,1);

        //trying by using query
        Query q1=ses.createQuery("from Student where id=1");
        q1.setCacheable(true);
        s1=(Student) q1.uniqueResult();
        System.out.println(s1);
        ses.getTransaction().commit();

        ses.close();
//it should fire only one query but it is firing two ,check out problem
        Session ses1= factory.openSession();
        ses1.beginTransaction();
        Query q2=ses1.createQuery("from Student where id=1");
        q2.setCacheable(true);
        s1=(Student) q2.uniqueResult();
        // s1=(Student)ses1.get(Student.class,1);
        System.out.println(s1);
        ses1.getTransaction().commit();
        ses1.close();



    }
}
