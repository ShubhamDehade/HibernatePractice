package org.example.Session.Selection.Perticular;

import demo.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Load {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory= cfg.buildSessionFactory();
        Session ses= factory.openSession();

        try{

            Student s=ses.load(Student.class,1);
            System.out.println(s.getId());//will print 1
            System.out.println(s.getName());//get method will fire query at the time of calling non-primary key column
            System.out.println(s.getEmail());
            System.out.println(s.getMarks());
        }catch (Exception e){
            System.out.println(e);//ObjectNotFoundException at line 19
        }
        Student s=ses.load(Student.class,3);
        System.out.println(s);

         s=ses.load(Student.class,2);
        System.out.println(s.getId());
        System.out.println(s.getName());//fire query at this line
        System.out.println(s.getEmail());
        System.out.println(s.getMarks());
        ses.close();
        factory.close();
    }
}
