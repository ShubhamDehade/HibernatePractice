package org.example.Session.Selection.Criteria.Projections;

import demo.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();

        SessionFactory factory=cfg.buildSessionFactory();
        Session ses= factory.openSession();

        Criteria crt1=ses.createCriteria(Student.class);
       ProjectionList plist =Projections.projectionList();
       plist.add(Projections.count("marks"));
       plist.add(Projections.groupProperty("marks"));
       crt1.setProjection(plist);
       List<Object> obj=crt1.list();
       int count;
       for (Object marks:obj){
           Object[] arr=(Object[]) marks;
           count=Integer.parseInt(arr[0].toString()) ;
           if (count>1){
               System.out.println(arr[0]+" "+arr[1]);
           }

       }











    }
}
