package br.com.achievehunter.core.steam;

import br.com.achievehunter.model.steam.Profile;

public interface SteamCompenserFacade {
	
	Profile findSteamProfileBySteamId64(long steamId);
	Profile findSteamProfileByNickName(String nickName);
	
}
