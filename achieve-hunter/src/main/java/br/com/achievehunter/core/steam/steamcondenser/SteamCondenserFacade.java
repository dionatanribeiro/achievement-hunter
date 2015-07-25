package br.com.achievehunter.core.steam.steamcondenser;

import br.com.achievehunter.model.dto.AchievementCompareGridDto;
import br.com.achievehunter.model.dto.ComparacaoAchievementDto;
import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

public interface SteamCondenserFacade {
	
	Profile findSteamProfileBySteamId64(Long steamId);
	Profile findSteamProfileByNickName(String nickName);
	Game findGameByUserIdAndGameId(Long steamId, Integer appId);
	AchievementCompareGridDto compareFriendAchievements(ComparacaoAchievementDto comparacaoAchievementDto);
}
