package br.com.achievehunter.service.ranking;

import java.util.List;

import br.com.achievehunter.model.dto.RankingTotalAchievementDto;

public interface RankingTotalAchievementService {
	
	List<RankingTotalAchievementDto> loadTotalAchievementRankingBySteamId(Long steamId);
	
}
