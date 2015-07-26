package br.com.achievehunter.model.dto;

public class RankingTotalAchievementDto {

	private String nickName;
	private String avatar;
	private Long totalAchieved;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getTotalAchieved() {
		return totalAchieved;
	}

	public void setTotalAchieved(Long totalAchieved) {
		this.totalAchieved = totalAchieved;
	}

}
