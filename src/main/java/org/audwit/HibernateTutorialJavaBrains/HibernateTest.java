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
        
        Address address = new Address();
        address.setCity("Dallas");
        address.setState(null);
        address.setStreet("7220 McCallum BLVD");
        address.setZip(75252);
        
        user.setHomeAddress(address);
        
        address.setCity("Dallas");
        address.setState("Texas");
        address.setStreet("13251 Emily Road");
        address.setZip(75240);
        
        user.setOfficeAddress(address);
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        
        user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (UserDetails)session.get(UserDetails.class, 1);
        System.out.println(user.getUserName());
        session.close();
        System.exit(0);
    }
}
