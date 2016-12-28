package org.javabrains.koushik.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Embedded
	@AttributeOverrides
	({
	@AttributeOverride(name="street", column=@Column(name="home_street_name")),
	@AttributeOverride(name="city", column=@Column(name="home_city_name")),
	@AttributeOverride(name="state", column=@Column(name="home_state_name")),
	@AttributeOverride(name="zip", column=@Column(name="home_zip_name"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	
	public Address getHomeAddress()
	{
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress)
	{
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress()
	{
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress)
	{
		this.officeAddress = officeAddress;
	}
	public Date getJoiningDate()
	{
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate)
	{
		this.joiningDate = joiningDate;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
