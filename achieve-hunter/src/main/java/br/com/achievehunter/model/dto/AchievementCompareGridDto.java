package br.com.achievehunter.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class AchievementCompareGridDto {

	private List<AchievementCompareLineDto> achievementCompareDto;

	private String gameLogoUrl;
	private String gameName;
	
	private String nickNameUser;
	private String avatarUser;

	private String nickNameFriend;
	private String avatarFriend;

	private BigDecimal totalGameAchievement;
	private BigDecimal totalAchievementUnlockedUser;
	private BigDecimal totalAchievementUnlockedFriend;

	public List<AchievementCompareLineDto> getAchievementCompareDto() {
		return achievementCompareDto;
	}

	public void setAchievementCompareDto(
			List<AchievementCompareLineDto> achievementCompareDto) {
		this.achievementCompareDto = achievementCompareDto;
	}

	public String getGameLogoUrl() {
		return gameLogoUrl;
	}

	public void setGameLogoUrl(String gameLogoUrl) {
		this.gameLogoUrl = gameLogoUrl;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getNickNameUser() {
		return nickNameUser;
	}

	public void setNickNameUser(String nickNameUser) {
		this.nickNameUser = nickNameUser;
	}

	public String getAvatarUser() {
		return avatarUser;
	}

	public void setAvatarUser(String avatarUser) {
		this.avatarUser = avatarUser;
	}

	public String getNickNameFriend() {
		return nickNameFriend;
	}

	public void setNickNameFriend(String nickNameFriend) {
		this.nickNameFriend = nickNameFriend;
	}

	public String getAvatarFriend() {
		return avatarFriend;
	}

	public void setAvatarFriend(String avatarFriend) {
		this.avatarFriend = avatarFriend;
	}

	public BigDecimal getTotalGameAchievement() {
		return totalGameAchievement;
	}

	public void setTotalGameAchievement(BigDecimal totalGameAchievement) {
		this.totalGameAchievement = totalGameAchievement;
	}

	public BigDecimal getTotalAchievementUnlockedUser() {
		return totalAchievementUnlockedUser;
	}

	public void setTotalAchievementUnlockedUser(
			BigDecimal totalAchievementUnlockedUser) {
		this.totalAchievementUnlockedUser = totalAchievementUnlockedUser;
	}

	public BigDecimal getTotalAchievementUnlockedFriend() {
		return totalAchievementUnlockedFriend;
	}

	public void setTotalAchievementUnlockedFriend(
			BigDecimal totalAchievementUnlockedFriend) {
		this.totalAchievementUnlockedFriend = totalAchievementUnlockedFriend;
	}

}
