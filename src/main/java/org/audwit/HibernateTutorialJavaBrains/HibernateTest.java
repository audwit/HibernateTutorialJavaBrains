package org.audwit.HibernateTutorialJavaBrains;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.FourWheeler;
import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest 
{
    public static void main( String[] args )
    {
        
        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setVehicleName("Kawasaki");
        twoWheeler.setSteeringHandle("steeringHandle");
        
        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleName("BMW");
        fourWheeler.setWheelSteering("Wheel Steering");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(twoWheeler);
        session.save(fourWheeler);
        
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
