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
        UserDetails user = new UserDetails();
        user.setUserName("Audwit");
        user.setJoiningDate(new Date());
        
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Camry");
        
        user.setVehicle(vehicle);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();
        
        session.close();
        System.exit(0);
    }
}
