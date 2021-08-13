package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;

import com.bean.UserBean;

/**
 * Hello world!
 *
 */
public class App {
	Configuration cfg;
	SessionFactory sf;
	Scanner scr;

	public App() {
		cfg = new Configuration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		scr = new Scanner(System.in);
	}

	void addUser() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			UserBean user = new UserBean();
			System.out.println("Enter firstName email and password");
			user.setFirstName(scr.next());
			user.setEmail(scr.next());
			user.setPassword(scr.next());
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	void deleteUser() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			System.out.println("Enter userId for delete");
			int userId = scr.nextInt();
			UserBean user = session.get(UserBean.class, userId);
			session.delete(user);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public static void main(String[] args) {
		App app = new App();
		app.addUser();
		//
	}
}
