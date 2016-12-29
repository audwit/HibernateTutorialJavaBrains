package org.audwit.HibernateTutorialJavaBrains;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest 
{
    public static void main( String[] args )
    {
        UserDetails user1 = new UserDetails();
        user1.setUserName("Audwit");
        user1.setJoiningDate(new Date());
        
        UserDetails user2 = new UserDetails();
        user2.setUserName("Faru");
        user2.setJoiningDate(new Date());
        
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Camry");
        
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Mercedez");
        
        user1.getVehicle().add(vehicle1);
        user1.getVehicle().add(vehicle2);
        
        vehicle1.getUserList().add(user1);
        vehicle2.getUserList().add(user1);
        
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(vehicle1);
        session.save(vehicle2);
        session.save(user1);
        session.save(user2);
        
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
