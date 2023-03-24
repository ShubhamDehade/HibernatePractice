package org.example.Session.Selection.Perticular;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.jws.soap.SOAPBinding;

public class Get {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory= cfg.buildSessionFactory();
        Session ses= factory.openSession();
    //will throw null pointer exception as id is not present
        try{
            //get method will fire query at the time of calling itself
            Student s=ses.get(Student.class,1);
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getEmail());
            System.out.println(s.getMarks());
        }catch (Exception e){
            System.out.println(e);
        }
        Student s=ses.get(Student.class,2);//fire query at this line
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getEmail());
        System.out.println(s.getMarks());
        ses.close();
        factory.close();
    }
}
