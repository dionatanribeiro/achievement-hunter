package br.com.achievehunter.model;

import java.util.List;

public class SteamGame {

	private Integer appId;
	private String name;
	private List<SteamAchievement> achievements;

	public SteamGame(Integer appId, String name) {
		this.appId = appId;
		this.name = name;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SteamAchievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<SteamAchievement> achievements) {
		this.achievements = achievements;
	}

}
