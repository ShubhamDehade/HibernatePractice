package org.example.Session.Updation;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mergeMethod {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses=factory.openSession();
        Transaction tx=ses.beginTransaction();
        ses.get(Student.class,2);

        Student s1=new Student();
        s1.setId(2);
        s1.setName("gdh");
        s1.setEmail("dddwwjwjff");
        s1.setMarks(89);

        ses.merge(s1);
        tx.commit();
        ses.close();
        factory.close();
    }
}
