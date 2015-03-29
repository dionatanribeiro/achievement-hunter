package br.com.achievehunter.core.steam;

import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

public interface SteamCompenserFacade {
	
	Profile findSteamProfileBySteamId64(Long steamId);
	Profile findSteamProfileByNickName(String nickName);
	Game findGameByUserIdAndGameId(Long steamId, Integer appId);
	
}
