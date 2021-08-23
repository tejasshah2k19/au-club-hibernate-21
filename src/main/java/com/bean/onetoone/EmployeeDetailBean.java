package com.bean.onetoone;

public class EmployeeDetailBean {

	int empDetailBeanId;
	String address;
	String doj;
	String dob;

	 EmployeeBean employee;
	 
	 

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public String getAddress() {
		return address;
	}

	public int getEmpDetailBeanId() {
		return empDetailBeanId;
	}

	public void setEmpDetailBeanId(int empDetailBeanId) {
		this.empDetailBeanId = empDetailBeanId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
