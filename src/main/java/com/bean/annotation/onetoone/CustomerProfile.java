package com.bean.annotation.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class CustomerProfile {

	int customerProfileId;

	String city;
	int pincode;
	float rating;

	@OneToOne(targetEntity = CustomerBean.class, cascade = CascadeType.ALL)
	CustomerBean customer;

	public int getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(int customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

}
