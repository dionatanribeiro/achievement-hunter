package br.com.achievehunter.core.steam.webapi;

import java.util.List;

import br.com.achievehunter.model.steam.Profile;

public interface SteamWebApiService {
	
	Profile findProfileBySteamId(Long steamId);
	List<Profile> findFriendsBySteamId(Long steamId);
	List<Integer> findOwnedGamesIdBySteamId(Long steamId);
	Long findTotalAchievementUnlockedBySteamIdAndAppId(Long steamId, Integer appId);
}
