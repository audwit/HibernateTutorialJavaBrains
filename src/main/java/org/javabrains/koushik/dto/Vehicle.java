package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle
{
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicleList")
	private Collection<UserDetails> userList = new ArrayList<UserDetails>();
	
	public Collection<UserDetails> getUserList()
	{
		return userList;
	}
	public void setUser(Collection<UserDetails> user)
	{
		this.userList = user;
	}
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
