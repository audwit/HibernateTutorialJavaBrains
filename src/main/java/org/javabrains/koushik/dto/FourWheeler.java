package org.javabrains.koushik.dto;

import javax.persistence.Entity;

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
