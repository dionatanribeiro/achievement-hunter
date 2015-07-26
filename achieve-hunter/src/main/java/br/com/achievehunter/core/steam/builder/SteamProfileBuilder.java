package br.com.achievehunter.core.steam.builder;

import java.util.List;

import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

public class SteamProfileBuilder {

	private Long steamId;
	private String nickName;
	private String realName;
	private String resumo;
	private String endereco;
	private String avatarUrl;
	private String avatarMediumUrl;
	private String avatarFullUrl;
	private List<Game> listaGames;
	private boolean isPublic;
	
	private SteamProfileBuilder() {};
	
	public static SteamProfileBuilder builder() {
		return new SteamProfileBuilder();
	}
	
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
	
	public SteamProfileBuilder withResumo(String resumo) {
		this.resumo = resumo;
		return this;
	}
	
	public SteamProfileBuilder withEndereco(String endereco) {
		this.endereco = endereco;
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
	
	public SteamProfileBuilder withGames(List<Game> listaGames) {
		this.listaGames = listaGames;
		return this;
	}
	
	public Profile build() {
		Profile profile = new Profile();
		profile.setSteamId(this.steamId);
		profile.setNickName(this.nickName);
		profile.setRealName(this.realName);
		profile.setResumo(this.resumo);
		profile.setEndereco(this.endereco);
		profile.setAvatar(this.avatarUrl);
		profile.setAvatarMedium(this.avatarMediumUrl);
		profile.setAvatarFull(this.avatarFullUrl);
		profile.setGames(listaGames);
		profile.setIsPublic(this.isPublic);
		return profile;
	}

	public SteamProfileBuilder withProfilePublic(boolean isPublic) {
		this.isPublic = isPublic;
		return this;
	}

	
}
