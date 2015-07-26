package br.com.achievehunter.service.ranking;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.achievehunter.core.steam.webapi.SteamWebApiService;
import br.com.achievehunter.model.dto.RankingTotalAchievementDto;
import br.com.achievehunter.model.steam.Profile;

public class RankingTotalAchievementServiceTest {

	private RankingTotalAchievementService service;
	
	private SteamWebApiService steamService;
	
	@Before
	public void setUp() {
		service = new RankingTotalAchievementServiceImpl();

		steamService = mock(SteamWebApiService.class);
		ReflectionTestUtils.setField(service, "steamService", steamService);
	}
	
	@Ignore
	@Test
	public void quandoCarregaRankingTotalAchievementsDesbloqueados() {
		//Arrange
		long steamId = 76561198003170021L;
		int appId = 236430;
		List<Profile> listaProfileQualquer = new ArrayList<>();
		listaProfileQualquer.add(getProfileQualquer());
		
		List<Integer> listaGameIdQualquer = new ArrayList<>();
		listaGameIdQualquer.add(appId);
		
		when(steamService.findProfileBySteamId(steamId)).thenReturn(getProfileQualquer());
		when(steamService.findFriendsBySteamId(steamId)).thenReturn(listaProfileQualquer);
		when(steamService.findOwnedGamesIdBySteamId(steamId)).thenReturn(listaGameIdQualquer);
		when(steamService.findTotalAchievementUnlockedBySteamIdAndAppId(steamId, appId));
		
		//Act
		List<RankingTotalAchievementDto> rankingList = service.loadTotalAchievementRankingBySteamId(steamId);
		
		//Assert
		assertThat("Lista não deve ser nula", rankingList, notNullValue());
		assertThat("Lista não deve ser vazia", rankingList.isEmpty(), is(false));
	}

	private Profile getProfileQualquer() {
		Profile profileQualquer = new Profile();
		profileQualquer.setSteamId(76561198003170021L);
		return profileQualquer;
	}
	
}
