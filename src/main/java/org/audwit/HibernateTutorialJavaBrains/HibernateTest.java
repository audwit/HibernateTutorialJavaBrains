package org.audwit.HibernateTutorialJavaBrains;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest 
{
    public static void main( String[] args )
    {
        UserDetails user = new UserDetails();
        user.setUserName("Audwit");
        user.setJoiningDate(new Date());
        
        Address address1 = new Address();
        Address address2 = new Address();
        
        address1.setCity("Dhaka");
        address1.setState("Dhaka Bibhag");
        //address1.setZip(1);
        
        address2.setCity("Manikganj");
        address2.setState("Dhaka Bibhag");
        //address1.setZip(2);
        
        user.getAddressList().add(address1);
        user.getAddressList().add(address2);
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        user = (UserDetails)session.get(UserDetails.class, 1);
        session.close();
        System.out.println(user.getAddressList().size());
        System.exit(0);
    }
}
