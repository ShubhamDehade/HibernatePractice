package org.example.Session.Insertion;

import demo.Name;
import demo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
    public static void main(String[] args) {
        Name n1=new Name();
        n1.setfName("SHUBHAM");
        n1.setmName("ANIL");
        n1.setlName("DEHADE");
        Person p1=new Person();
        p1.setpId(101);
        p1.setN(n1);
        Configuration cfg=new Configuration();
      cfg=  cfg.configure();
      cfg=cfg.addAnnotatedClass(Person.class);
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();
        Transaction tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();


    }
}
