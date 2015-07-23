package br.com.achievehunter.model.dto;

import java.util.List;

import br.com.achievehunter.model.steam.Profile;

public class AchievementCompareGridDto {

	private Profile userProfile;
	private Profile friendProfile;
	private List<AchievementCompareDto> achievementCompareDto;
	
	private String nickNameFirstUser;
	private String avatarFirstUser;
	private String nickNameSecondUser;
	private String avatarSecondUser;

	public Profile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}

	public Profile getFriendProfile() {
		return friendProfile;
	}

	public void setFriendProfile(Profile friendProfile) {
		this.friendProfile = friendProfile;
	}

	public List<AchievementCompareDto> getAchievementCompareDto() {
		return achievementCompareDto;
	}

	public void setAchievementCompareDto(
			List<AchievementCompareDto> achievementCompareDto) {
		this.achievementCompareDto = achievementCompareDto;
	}

}
