package org.example.Session.Insertion;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveOrUpdate {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses=factory.openSession();
        Transaction tx=ses.beginTransaction();

        Student s2=new Student();
        s2.setId(2);
        s2.setName("shwwd");
        s2.setEmail("ssssdgsg@gdu");
        s2.setMarks(77);
        //it will check first primary exist in table or not then,if exist then it will update,else will insert
        ses.saveOrUpdate(s2);
        tx.commit();



    }
}
