package br.com.achievehunter.model;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class SteamGame implements InitializingBean {

	private static final String GAME_LOGO_URL = "http://cdn.akamai.steamstatic.com/steamcommunity/public/images/apps/{appId}/{logoHash}.jpg";

	private Integer appId;
	private String name;
	private List<SteamAchievement> achievements;
	private String logoHash;
	private String logoUrl;
	
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

	public String getLogoHash() {
		return logoHash;
	}

	public void setLogoHash(String logoHash) {
		this.logoHash = logoHash;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.logoUrl = GAME_LOGO_URL.replaceFirst("{appId}", String.valueOf(this.appId)).replaceFirst("{logoHash}", this.logoHash);
	}
	
}
