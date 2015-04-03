package br.com.achievehunter.core.steam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.achievehunter.model.steam.Achievement;
import br.com.achievehunter.model.steam.Game;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.google.common.base.Strings;

public class SteamCompenserUtilsTest {
	
	@Test
	public void quandoBuscaDadosDeUmJogoQualquer() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		GameStats gameStats = SteamCompenserUtils.getGameStats(steamUserId, darkSoulsId);
		
		//Assert
		assertThat("Dados do jogo não podem ser nulos", gameStats, notNullValue());
	}
	
	@Test
	public void quandoBuscaAchievementsDeUmJogoQualquer() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		GameStats stats = SteamCompenserUtils.getGameStats(steamUserId, darkSoulsId);
		
		//Act
		List<Achievement> achievementList = SteamCompenserUtils.getAchievementsByGameStats(stats);
		
		//Assert
		assertThat("Deve encontrar a lista de achievements do jogo", achievementList.isEmpty(), is(false));
	}
	
	@Test
	public void quandoTentaCarregarUmJogoQualquer() {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		Game darkSouls = SteamCompenserUtils.loadGame(steamUserId, darkSoulsId);
		
		//Assert
		assertThat("O game não deve ser nulo", darkSouls, notNullValue());
		assertThat("Deve encontrar o nome do jogo: " + darkSouls.getName(), !Strings.isNullOrEmpty(darkSouls.getName()), is(true));
		assertThat("Deve encontrar a lista de achievements do jogo", darkSouls.getAchievements().isEmpty(), is(false));
	}
	
	@Test
	public void verificaSeIconeDoAchievementFoiRetornado() {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		Game darkSouls = SteamCompenserUtils.loadGame(steamUserId, darkSoulsId);
		
		//Assert
		boolean iconesPreenchidos = darkSouls.getAchievements().stream().allMatch(a -> !Strings.isNullOrEmpty(a.getIcon()));
		assertThat("Todos os icones de achievements devem estar preenchidos", iconesPreenchidos, is(true));
	}
	
	
	
}
