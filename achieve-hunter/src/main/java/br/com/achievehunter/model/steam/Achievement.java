package br.com.achievehunter.model.steam;

import java.time.LocalDateTime;

public class Achievement {

	private String name;
	private String description;
	private String iconUnlockedUrl;
	private String iconLockedUrl;
	private LocalDateTime dateUnlocked;
	private Integer hidden;
	private boolean achieved;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconUnlockedUrl() {
		return iconUnlockedUrl;
	}

	public void setIconUnlockedUrl(String iconUnlockedUrl) {
		this.iconUnlockedUrl = iconUnlockedUrl;
	}

	public String getIconLockedUrl() {
		return iconLockedUrl;
	}

	public void setIconLockedUrl(String iconLockedUrl) {
		this.iconLockedUrl = iconLockedUrl;
	}
	
	public LocalDateTime getDateUnlocked() {
		return dateUnlocked;
	}

	public void setDateUnlocked(LocalDateTime dateUnlocked) {
		this.dateUnlocked = dateUnlocked;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	public boolean isAchieved() {
		return achieved;
	}

	public void setAchieved(boolean achieved) {
		this.achieved = achieved;
	}

}
