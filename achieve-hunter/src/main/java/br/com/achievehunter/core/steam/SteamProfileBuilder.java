package br.com.achievehunter.core.steam;

import java.util.List;

import br.com.achievehunter.model.SteamGame;
import br.com.achievehunter.model.SteamProfile;

public class SteamProfileBuilder {

	private Long steamId;
	private String nickName;
	private String realName;
	private String avatarUrl;
	private String avatarMediumUrl;
	private String avatarFullUrl;
	private List<SteamGame> listaGames;
	
	public SteamProfileBuilder withSteamId(Long steamId) {
		this.steamId = steamId;
		return this;
	}
	
	public SteamProfileBuilder withNickName(String nickname) {
		this.nickName = nickname;
		return this;
	}
	
	public SteamProfileBuilder withRealName(String realName) {
		this.realName = realName;
		return this;
	}
	
	public SteamProfileBuilder withAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
		return this;
	}
	
	public SteamProfileBuilder withAvatarMediumUrl(String avatarMediumUrl) {
		this.avatarMediumUrl = avatarMediumUrl;
		return this;
	}
	
	public SteamProfileBuilder withAvatarFullUrl(String avatarFullUrl) {
		this.avatarFullUrl = avatarFullUrl;
		return this;
	}
	
	public SteamProfileBuilder withGames(List<SteamGame> listaGames) {
		this.listaGames = listaGames;
		return this;
	}
	
	public SteamProfile build() {
		SteamProfile profile = new SteamProfile();
		profile.setSteamId(this.steamId);
		profile.setNickname(this.nickName);
		profile.setRealname(this.realName);
		profile.setAvatar(this.avatarUrl);
		profile.setAvatarMedium(this.avatarMediumUrl);
		profile.setAvatarFull(this.avatarFullUrl);
		profile.setGames(listaGames);
		return profile;
	}

	
}
