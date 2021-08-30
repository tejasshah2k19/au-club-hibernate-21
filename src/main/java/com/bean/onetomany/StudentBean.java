package com.bean.onetomany;

import java.util.List;

public class StudentBean {

	int studentId;
	String name;
	String colgName;

	List<ResultBean> results;

	public List<ResultBean> getResults() {
		return results;
	}

	public void setResults(List<ResultBean> results) {
		this.results = results;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColgName() {
		return colgName;
	}

	public void setColgName(String colgName) {
		this.colgName = colgName;
	}

}
