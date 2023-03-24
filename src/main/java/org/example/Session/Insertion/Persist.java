package org.example.Session.Insertion;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Persist {
    public static void main(String[] args) {
        Student s2=new Student();
        s2.setId(1);
        s2.setName("CHETAN");
        s2.setEmail("adhsd@gmail.com");
        s2.setMarks(67);
        //transient object state

        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses=factory.openSession();
        Transaction tx=ses.beginTransaction();
        //persist() method is same as save() method only difference id its return type is void
        ses.persist(s2);
        //persistent object state
        tx.commit();
        //object will move to database
        ses.evict(s2);
        //detached object state



    }
}
