package org.example.Session.Updation;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class updateMethod {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses=factory.openSession();
        Transaction tx=ses.beginTransaction();
       // ses.get(Student.class,1);
        // if loading same id and updating same then exception will occur
        //only in case we use get()n method

        //id is not updatable in this case
        Student s1=ses.load(Student.class,2);
      // s1.setId(5);
       s1.setName("Shubam DEHADE");
       s1.setMarks(89);
       s1.setEmail("dajkd$@hassd");
       ses.update(s1);


       Student s2=new Student();
       s2.setEmail("asfgrewr@45");
       //s2.setId(1);     nothing will happen   by lines from 29-34
       s2.setName("shuh");
       s2.setMarks(90);
       ses.update(s2);
       tx.commit();

    }
}
