package com;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.manytomany.PlayerBean;
import com.bean.manytomany.SportsBean;

public class ManyToMany {
	SessionFactory sf = null;

	public ManyToMany() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		ManyToMany m = new ManyToMany();
		m.addSportsPlayer();
	}

	void addSportsPlayer() {
		Session session = sf.openSession();
		
		SportsBean c = new SportsBean();
		c.setName("ckt");
		
		SportsBean b = new SportsBean() ;
		b.setName("b.ball");
		
		SportsBean w = new SportsBean();
		w.setName("w.ball");
		
		
		PlayerBean p1 = new PlayerBean();
		p1.setName("sam");
		
		
		PlayerBean p2 = new PlayerBean();
		p2.setName("Ram");
		
		
		PlayerBean p3 = new PlayerBean();
		p3.setName("shyam");
		
		
		PlayerBean p4 = new PlayerBean();
		p4.setName("prisha"); 
		
		
		
		Set<PlayerBean> cPlayers = new HashSet<PlayerBean>();
		cPlayers.add(p1);
		cPlayers.add(p2);
		cPlayers.add(p3);
		cPlayers.add(p4);
		c.setPlayers(cPlayers);
		
		
		Set<PlayerBean> wPlayers = new HashSet<PlayerBean>();
		wPlayers.add(p1);
		wPlayers.add(p4);
		w.setPlayers(wPlayers);
		
		
		Set<PlayerBean> bPlayers = new HashSet<PlayerBean>();
		bPlayers.add(p2);
		bPlayers.add(p3);
		bPlayers.add(p4);
		b.setPlayers(bPlayers);
		
		Transaction tx  = session.beginTransaction();
		session.persist(c);
		session.persist(w);
		session.persist(b);
		
		tx.commit();
		session.close();
		
		
		
		
	}

}
