package br.com.achievehunter.model.dto;


public class AchievementCompareLineDto {

	private String achievementApiName;
	private String achievementName;
	private String achievementDescription;

	private String achievementIconFirstUser;
	private String achievementIconSecondUser;
	
	private String achievementDateFirstUser;
	private String achievementDateSecondUser;

	public String getAchievementApiName() {
		return achievementApiName;
	}

	public void setAchievementApiName(String achievementApiName) {
		this.achievementApiName = achievementApiName;
	}

	public String getAchievementName() {
		return achievementName;
	}

	public void setAchievementName(String achievementName) {
		this.achievementName = achievementName;
	}

	public String getAchievementDescription() {
		return achievementDescription;
	}

	public void setAchievementDescription(String achievementDescription) {
		this.achievementDescription = achievementDescription;
	}

	public String getAchievementIconFirstUser() {
		return achievementIconFirstUser;
	}

	public void setAchievementIconFirstUser(String achievementIconFirstUser) {
		this.achievementIconFirstUser = achievementIconFirstUser;
	}

	public String getAchievementIconSecondUser() {
		return achievementIconSecondUser;
	}

	public void setAchievementIconSecondUser(String achievementIconSecondUser) {
		this.achievementIconSecondUser = achievementIconSecondUser;
	}

	public String getAchievementDateFirstUser() {
		return achievementDateFirstUser;
	}

	public void setAchievementDateFirstUser(String achievementDateFirstUser) {
		this.achievementDateFirstUser = achievementDateFirstUser;
	}

	public String getAchievementDateSecondUser() {
		return achievementDateSecondUser;
	}

	public void setAchievementDateSecondUser(String achievementDateSecondUser) {
		this.achievementDateSecondUser = achievementDateSecondUser;
	}

}
