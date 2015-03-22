package br.com.achievehunter.model;

import java.util.List;

public class SteamProfile {

	private Long steamId;
	private String nickname;
	private String realname;
	private String avatar;
	private String avatarMedium;
	private String avatarFull;
	private List<SteamGame> games;

	public Long getSteamId() {
		return steamId;
	}

	public void setSteamId(Long steamId) {
		this.steamId = steamId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public List<SteamGame> getGames() {
		return games;
	}

	public void setGames(List<SteamGame> games) {
		this.games = games;
	}
	
}
