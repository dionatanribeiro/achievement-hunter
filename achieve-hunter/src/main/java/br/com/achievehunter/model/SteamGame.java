package br.com.achievehunter.model;

import java.util.List;

public class SteamGame {

	private Long appId;
	private String name;
	private List<SteamAchievement> achievements;

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
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
