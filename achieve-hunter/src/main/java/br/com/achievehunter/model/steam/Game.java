package br.com.achievehunter.model.steam;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class Game {

	private Integer appId;
	private String name;
	private String shortName;
	private String logoUrl;
	private List<GameAchievement> achievements;
	
	public Game() {}
	
	public Game(Integer appId, String name, String shortName, String logoUrl) {
		this.appId = appId;
		this.name = name;
		this.shortName = shortName;
		this.logoUrl = logoUrl;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}
	
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	public List<GameAchievement> getAchievements() {
		return achievements;
	}

	public void setAchievements(List<GameAchievement> achievements) {
		this.achievements = achievements;
	}

}
