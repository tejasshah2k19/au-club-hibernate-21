package com.bean.onetoone;

public class EmployeeBean {

	int employeeId;
	String name;
	String email;
	String password;
	
	EmployeeDetailBean employeeDetail;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeDetailBean getEmployeeDetail() {
		return employeeDetail;
	}
	public void setEmployeeDetail(EmployeeDetailBean employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	
	
}
