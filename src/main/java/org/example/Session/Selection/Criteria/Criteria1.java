package org.example.Session.Selection.Criteria;

import demo.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class Criteria1 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();

        Criteria crt=ses.createCriteria(Student.class);
        Projection p=Projections.count("name");
        crt.setProjection(p);
        System.out.println(crt.uniqueResult());

    }
}
