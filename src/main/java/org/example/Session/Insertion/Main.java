package org.example.Session.Insertion;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory= cfg.buildSessionFactory();
        Session ses= factory.openSession();
        Transaction tx= ses.beginTransaction();
        Student s1=new Student();
        s1.setId(4);
        s1.setName("shubham");
        s1.setEmail("shubham@gmail.com");
        s1.setMarks(79);

        //save() method returns primary value
        int pk= (Integer) ses.save(s1);
        System.out.println(pk);//4
        tx.commit();

    }
}