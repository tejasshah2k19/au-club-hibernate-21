package com.bean.manytomany;

import java.util.Set;

public class PlayerBean {
	int playerId;
	String name;

	Set<SportsBean> sports;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SportsBean> getSports() {
		return sports;
	}

	public void setSports(Set<SportsBean> sports) {
		this.sports = sports;
	}

}
