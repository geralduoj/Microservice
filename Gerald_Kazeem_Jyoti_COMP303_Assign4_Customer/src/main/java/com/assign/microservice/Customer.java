/** 
	Authors -----------
	Gerald Uchie-Okoro - 301064861
	Kazeem Ademola Odukale - 301021750 
	Jyoti Jairath - 301101579
**/
package com.assign.microservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="custid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	@NotBlank(message = "Customer Name is mandatory")
	@Column(name="custname")
	@NotNull(message="Please enter your name")
	private String custName;
	@Column(name="city")
	@NotNull(message="Please specify a city")
	private String city;
	@Column(name="email")
	@Email(message = "Valid email address")
	private String email;
	@Column(name="address")
	@NotNull(message="Please enter your address")
	private String address;
	@Column(name="phonenumber")
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Phone number is invalid")
	private String phoneNumber;
	
	public Customer() 
	{
		super();
	}

	

	public Customer(int custId, @NotBlank(message = "Customer Name is mandatory") String custName, String city,
			String email, String address, String phoneNumber) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.city = city;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	



	public Customer(@NotBlank(message = "Customer Name is mandatory") String custName, String city, String email,
			String address, String phoneNumber) {
		super();
		this.custName = custName;
		this.city = city;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}



	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

}