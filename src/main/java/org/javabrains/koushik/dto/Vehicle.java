package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="vehicle_type", discriminatorType=DiscriminatorType.STRING)
public class Vehicle
{
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	public int getVehicleId()
	{
		return vehicleId;
	}
	public void setVehicleId(int vehicleId)
	{
		this.vehicleId = vehicleId;
	}
	public String getVehicleName()
	{
		return vehicleName;
	}
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}
}
