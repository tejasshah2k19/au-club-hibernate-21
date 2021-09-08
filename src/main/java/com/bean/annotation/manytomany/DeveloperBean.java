package com.bean.annotation.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "developers")
public class DeveloperBean {

	@Id
	@GeneratedValue
	int developerId;

	String name;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "dev_project", joinColumns = { @JoinColumn(name = "developerId") }, inverseJoinColumns = {
			@JoinColumn(name = "projectId") })
	Set<ProjectBean> projects;

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProjectBean> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectBean> projects) {
		this.projects = projects;
	}

}
