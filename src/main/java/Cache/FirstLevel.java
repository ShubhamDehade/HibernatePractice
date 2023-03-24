package Cache;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();
         Student s1;
//         ses.beginTransaction();

         s1=(Student) ses.get(Student.class,2);
        System.out.println(s1);


        s1=(Student) ses.get(Student.class,2);
        System.out.println(s1);

//        ses.getTransaction().commit();

    }
}
