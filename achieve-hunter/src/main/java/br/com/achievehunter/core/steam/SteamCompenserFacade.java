package br.com.achievehunter.core.steam;

import br.com.achievehunter.model.SteamProfile;

public interface SteamCompenserFacade {
	
	SteamProfile findSteamProfileBySteamId64(long steamId);
	SteamProfile findSteamProfileByNickName(String nickName);
	
}
