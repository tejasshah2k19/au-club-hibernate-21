package com.bean.manytomany;

import java.util.Set;

public class SportsBean {

	int sportsId;
	String name;
	Set<PlayerBean> players; 
	
	
	public int getSportsId() {
		return sportsId;
	}
	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PlayerBean> getPlayers() {
		return players;
	}
	public void setPlayers(Set<PlayerBean> players) {
		this.players = players;
	} 
	
	
}
