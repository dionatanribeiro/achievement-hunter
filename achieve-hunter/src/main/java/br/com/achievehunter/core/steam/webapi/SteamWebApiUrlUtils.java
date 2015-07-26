package br.com.achievehunter.core.steam.webapi;

import java.util.Arrays;
import java.util.List;

public abstract class SteamWebApiUrlUtils {

	public static String getProfile(Long steamId) {
		StringBuilder url = new StringBuilder();
		url.append(SteamWebApiArgs.BASE_URL.getMessage());
		url.append(SteamWebApiArgs.PROFILE.getMessage());
		url.append(SteamWebApiArgsBuilder.createParam().addApiKey().addSteamIds(Arrays.asList(steamId)).getArgs());
		return url.toString();
	}
	
	public static String getProfileList(List<Long> listaSteamIds) {
		StringBuilder urlProfiles = new StringBuilder();
		urlProfiles.append(SteamWebApiArgs.BASE_URL.getMessage());
		urlProfiles.append(SteamWebApiArgs.PROFILE.getMessage());
		urlProfiles.append(SteamWebApiArgsBuilder.createParam().addApiKey().addSteamIds(listaSteamIds).getArgs());
		return urlProfiles.toString();
	}
	
	public static String getFriendList(Long steamId) {
		StringBuilder urlFriends = new StringBuilder();
		urlFriends.append(SteamWebApiArgs.BASE_URL.getMessage());
		urlFriends.append(SteamWebApiArgs.FRIEND_LIST.getMessage());
		urlFriends.append(SteamWebApiArgsBuilder.createParam().addApiKey().addSteamId(steamId).addFormatJson().getArgs());
		return urlFriends.toString();
	}
	
	public static String getOwnedGames(Long steamId) {
		StringBuilder urlOwnedGames = new StringBuilder();
		urlOwnedGames.append(SteamWebApiArgs.BASE_URL.getMessage());
		urlOwnedGames.append(SteamWebApiArgs.PLAYER_GAME_LIST.getMessage());
		urlOwnedGames.append(SteamWebApiArgsBuilder.createParam().addApiKey().addSteamId(steamId).addAppInfo().addFormatJson().getArgs());
		return urlOwnedGames.toString();
	}
	
	public static String getAchievementsUnlocked(Long steamId, Integer appId) {
		StringBuilder urlAchievementsUnlocked = new StringBuilder();
		urlAchievementsUnlocked.append(SteamWebApiArgs.BASE_URL.getMessage());
		urlAchievementsUnlocked.append(SteamWebApiArgs.PLAYER_GAME_STATS.getMessage());
		urlAchievementsUnlocked.append(SteamWebApiArgsBuilder.createParam().addAppId(appId).addApiKey().addSteamId(steamId).addFormatJson().getArgs());
		return urlAchievementsUnlocked.toString();
	}
	
}
