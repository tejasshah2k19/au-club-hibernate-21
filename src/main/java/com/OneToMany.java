package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Array;

import com.bean.onetomany.ResultBean;
import com.bean.onetomany.StudentBean;
import com.bean.onetoone.EmployeeBean;
import com.bean.onetoone.EmployeeDetailBean;

public class OneToMany {

	SessionFactory sf = null;

	public OneToMany() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		OneToMany om = new OneToMany();
		om.addStudent();
	}

	void addStudent() {

		StudentBean std = new StudentBean();
		std.setColgName("au");
		std.setName("ram");

		ResultBean r1 = new ResultBean();
		r1.setExamTitle("mid1");
		r1.setPerc(85);

		ResultBean r2 = new ResultBean();
		r2.setExamTitle("mid2");
		r2.setPerc(95);

		ResultBean r3 = new ResultBean();
		r3.setExamTitle("final");
		r3.setPerc(96);

		List<ResultBean> results = new ArrayList<ResultBean>();
		results.add(r1);
		results.add(r2);
		results.add(r3);

		std.setResults(results);

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(std);// save persist
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}

		session.close();
	}

}
