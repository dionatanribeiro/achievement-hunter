package br.com.achievehunter.model;

public class SteamAchievement {

	private String name;
	private Integer defaultvalue;
	private String displayName;
	private Integer hidden;
	private String description;
	private String icon;
	private String icongray;
	private boolean achieved;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(Integer defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getHidden() {
		return hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcongray() {
		return icongray;
	}

	public void setIcongray(String icongray) {
		this.icongray = icongray;
	}

	public boolean isAchieved() {
		return achieved;
	}

	public void setAchieved(boolean achieved) {
		this.achieved = achieved;
	}

}
