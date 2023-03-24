package org.example.Session.Selection.Criteria.Restrictions;

import demo.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {
        Configuration cfg =new Configuration();
        cfg= cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session ses=factory.openSession();

       Criteria crt= ses.createCriteria(Student.class);
       crt.add(Restrictions.or(Restrictions.eq("name","shubham"),Restrictions.like("name","s%")));
       crt.add(Restrictions.gt("marks",89));
        List<Object> obj=crt.list();
        for (Object o:obj){
            System.out.println(o);
        }
    }
}
