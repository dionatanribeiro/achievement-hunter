package br.com.achievehunter.core.steam;

import java.util.List;

import org.junit.Test;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.GameAchievement;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GameStatsTest {
	
	@Test
	public void quandoCriaEstatisticasDeUmJogo() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		GameStats gameStats = GameStats.createGameStats(steamUserId, darkSoulsId);
		
		//Assert
		assertThat("Estatísticas do jogo não podem ser nulas", gameStats, notNullValue());
	}
	
	@Test
	public void quandoCriaEstatisticasDeAchievementsDoDarkSouls() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		List<GameAchievement> achievements = GameStats.createGameStats(steamUserId, darkSoulsId).getAchievements();
		
		//Assert
		assertThat("Lista de achievements não pode ser vazia", achievements.isEmpty(), is(false));
	}
	
	@Test
	public void quandoCriaEstatisticasDeAchievementsDoFootballManager2012() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer fm2012Id = 71270;
		
		//Act
		List<GameAchievement> achievements = GameStats.createGameStats(steamUserId, fm2012Id).getAchievements();
		
		//Assert
		assertThat("Lista de achievements não pode ser vazia", achievements.isEmpty(), is(false));
	}
	
}
