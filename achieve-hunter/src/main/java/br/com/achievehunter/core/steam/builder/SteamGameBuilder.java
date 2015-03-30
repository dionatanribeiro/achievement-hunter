package br.com.achievehunter.core.steam.builder;

import java.util.List;

import br.com.achievehunter.model.steam.Achievement;
import br.com.achievehunter.model.steam.Game;

public class SteamGameBuilder {

	private Integer appId;
	private String name;
	private String shortName;
	private String logoUrl;
	private String logoThumbnailUrl;
	private String iconUrl;
	private List<Achievement> achievements;

	private SteamGameBuilder() {
	};

	public static SteamGameBuilder builder() {
		return new SteamGameBuilder();
	}

	public SteamGameBuilder withAppId(Integer appId) {
		this.appId = appId;
		return this;
	}

	public SteamGameBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public SteamGameBuilder withLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
		return this;
	}

	public SteamGameBuilder withLogoThumbnailUrl(String logoThumbnailUrl) {
		this.logoThumbnailUrl = logoThumbnailUrl;
		return this;
	}

	public SteamGameBuilder withIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
		return this;
	}

	public SteamGameBuilder withShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	public SteamGameBuilder withAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
		return this;
	}

	public Game build() {
		Game game = new Game();
		game.setAppId(this.appId);
		game.setLogoUrl(this.logoUrl);
		game.setLogoThumbnailUrl(this.logoThumbnailUrl);
		game.setIconUrl(this.iconUrl);
		game.setName(this.name);
		game.setShortName(this.shortName);
		game.setAchievements(this.achievements);
		return game;
	}

}
