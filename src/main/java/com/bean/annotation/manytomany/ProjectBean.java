package com.bean.annotation.manytomany;

import java.util.Set;

import javax.persistence.ManyToMany;

public class ProjectBean {
	int projectId;
	String name;
	
	@ManyToMany(mappedBy="developers")
	Set<DeveloperBean> developers;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DeveloperBean> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Set<DeveloperBean> developers) {
		this.developers = developers;
	}
	 
}
