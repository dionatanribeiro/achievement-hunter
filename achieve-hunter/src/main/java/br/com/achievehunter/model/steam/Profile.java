package br.com.achievehunter.model.steam;

import java.util.List;

public class Profile {

	private Long steamId;
	private String nickName;
	private String realName;
	private String avatar;
	private String avatarMedium;
	private String avatarFull;
	private List<Game> games;

	public Long getSteamId() {
		return steamId;
	}

	public void setSteamId(Long steamId) {
		this.steamId = steamId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarMedium() {
		return avatarMedium;
	}

	public void setAvatarMedium(String avatarMedium) {
		this.avatarMedium = avatarMedium;
	}

	public String getAvatarFull() {
		return avatarFull;
	}

	public void setAvatarFull(String avatarFull) {
		this.avatarFull = avatarFull;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}