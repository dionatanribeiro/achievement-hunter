package br.com.achievehunter.service.ranking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.achievehunter.core.steam.webapi.SteamWebApiService;
import br.com.achievehunter.model.dto.RankingTotalAchievementDto;
import br.com.achievehunter.model.steam.Profile;

@Service
public class RankingTotalAchievementServiceImpl implements RankingTotalAchievementService {

	@Inject
	private SteamWebApiService steamService;
	
	@Override
	public List<RankingTotalAchievementDto> loadTotalAchievementRankingBySteamId(Long steamId) {
		List<RankingTotalAchievementDto> chartRankingTotalAchievementUnlocked = new ArrayList<>();

		List<Profile> userRanking = new ArrayList<>();
		userRanking.add(steamService.findProfileBySteamId(steamId));
		
		List<Profile> onlyPublicProfiles = steamService.findFriendsBySteamId(steamId).stream().filter(p -> p.isPublic()).collect(Collectors.toList());
		userRanking.addAll(onlyPublicProfiles);
		
		for (Profile profile : userRanking) {
			RankingTotalAchievementDto chartLine = new RankingTotalAchievementDto();
			List<Integer> listAppId = steamService.findOwnedGamesIdBySteamId(profile.getSteamId());
			Long totalGeralAchieved = 0L;
			for (Integer appId : listAppId) {
				Long totalAchieved = steamService.findTotalAchievementUnlockedBySteamIdAndAppId(profile.getSteamId(), appId);
				totalGeralAchieved += totalAchieved;
			}
			chartLine.setAvatar(profile.getAvatar());
			chartLine.setNickName(profile.getNickName());
			chartLine.setTotalAchieved(totalGeralAchieved);
			chartRankingTotalAchievementUnlocked.add(chartLine);
		}
		return chartRankingTotalAchievementUnlocked;
	}

}
