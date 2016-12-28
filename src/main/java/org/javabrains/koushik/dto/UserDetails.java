package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="user_address_list" , joinColumns=@JoinColumn(name="user_id"))
	@GenericGenerator(name="sequence-gen", strategy="org.hibernate.id.enhanced.SequenceStyleGenerator")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Address> addressList= new ArrayList<Address>();
	
	public Date getJoiningDate()
	{
		return joiningDate;
	}
	public Collection<Address> getAddressList()
	{
		return addressList;
	}
	public void setAddressList(Collection<Address> addressList)
	{
		this.addressList = addressList;
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
