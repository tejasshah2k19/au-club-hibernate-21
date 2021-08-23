package com;

import java.util.List;
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

	void getAllUsers() {
		Session session = sf.openSession();

		List<UserBean> users = session.createQuery("from UserBean", UserBean.class).getResultList();
							//session.createQuery("===="); 
		
		for (UserBean u : users) {
			System.out.println(u.getUserId() + " " + u.getFirstName() + " " + u.getEmail());
		}
		session.close();
	}

	UserBean getDataByUserId(int userId) {
		Session session = sf.openSession();

		UserBean user = session.get(UserBean.class, userId);
		session.close();
		return user;
	}

	void updateUser() {
		System.out.println("Enter userId for Update records?");
		int userId = scr.nextInt();
		int choice = -1;
		UserBean user = getDataByUserId(userId);

		System.out.println("FirstName : " + user.getFirstName());
		System.out.println("Press 1 For update firstname?");
		choice = scr.nextInt();
		if (choice == 1) {
			System.out.println("Enter new FirstName");
			user.setFirstName(scr.next());
		}
		System.out.println("Email : "+user.getEmail());
		System.out.println("Press 1 For update Email?");
		choice = scr.nextInt();
		if (choice == 1) {
			System.out.println("Enter new Email");
			user.setEmail(scr.next());
		}

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);//userId 
		tx.commit();
		session.close();
		
	}
	

	public static void main(String[] args) {
		App app = new App();
		// app.addUser();
		//
		app.getAllUsers();
		app.updateUser();
		app.getAllUsers();
	}
}
