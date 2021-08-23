package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.onetoone.EmployeeBean;
import com.bean.onetoone.EmployeeDetailBean;

public class OneToOne {

	SessionFactory sf = null;

	public OneToOne() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		OneToOne o = new OneToOne();
		o.addEmployee();
	}

	void addEmployee() {

		Session session = sf.openSession();

		EmployeeBean empl = new EmployeeBean();
		empl.setEmail("tejas@gmail.com");
		empl.setName("tejas");
		empl.setPassword("tejas123");

		EmployeeDetailBean empDetail = new EmployeeDetailBean();
		empDetail.setAddress("satelite");
		empDetail.setDob("1-1-1920");
		empDetail.setDoj("1-1-1923");

		empl.setEmployeeDetail(empDetail);
		empDetail.setEmployee(empl);
		Transaction tx = session.beginTransaction();

		try {
			session.persist(empl);// save persist
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();
	}

}
