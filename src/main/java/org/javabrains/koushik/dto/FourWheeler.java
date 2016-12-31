package org.javabrains.koushik.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class FourWheeler extends Vehicle
{
	private String wheelSteering;

	public String getWheelSteering()
	{
		return wheelSteering;
	}

	public void setWheelSteering(String wheelSteering)
	{
		this.wheelSteering = wheelSteering;
	}
}
