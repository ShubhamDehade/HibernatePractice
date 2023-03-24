package org.example.Session.Deletion;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class delete {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();
        Transaction tx=ses.beginTransaction();
        Student s1=ses.load(Student.class,1);
        ses.delete(s1);
        tx.commit();
    }
}
