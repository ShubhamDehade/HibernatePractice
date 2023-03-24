package org.example.Session.Selection.All;

import demo.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        List<Student> data=crt.list();
        for (Student s:data){
            System.out.println(s);
        }

    }
}
