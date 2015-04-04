package br.com.achievehunter.core.steam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import br.com.achievehunter.model.steam.Achievement;
import br.com.achievehunter.model.steam.Game;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

public class SteamCompenserUtilsTest {
	
	@Test
	public void quandoBuscaDadosDeUmJogoQualquer() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		
		//Act
		GameStats gameStats = GameStats.createGameStats(steamUserId, darkSoulsId);
		
		//Assert
		assertThat("Dados do jogo não podem ser nulos", gameStats, notNullValue());
	}
	
	@Test
	public void quandoBuscaAchievementsDeUmJogoQualquer() throws SteamCondenserException {
		//Arrange
		Long steamUserId = 76561198003170021L;
		Integer darkSoulsId = 211420;
		GameStats stats = GameStats.createGameStats(steamUserId, darkSoulsId);
		
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
	
	@Test
	public void verificaQuandoOrdenaListaDeAchievements() {
		//Arrange
		List<Achievement> achievements = listaQualquerDeAchievements();
		
		//Act
		List<Achievement> listaOrdenada = SteamCompenserUtils.ordenarPorDesbloqueioENome(achievements);
		Achievement achievementMaisRecente = listaOrdenada.stream().filter(a -> a.isAchieved())
							  									   .max((a1, a2) -> a1.getDateUnlocked().compareTo(a2.getDateUnlocked()))
							  									   .get();
		Achievement ultimoAchievementNaoDesbloqueadoEsperado = listaOrdenada.stream().filter(a -> !a.isAchieved())
		   					  												 .max((a1, a2) -> a1.getApiName().compareTo(a2.getApiName()))
		   					  												 .get();
		
		Achievement primeiroAchievement = listaOrdenada.stream().findFirst().get();
		Achievement ultimoAchievement = listaOrdenada.stream().reduce((previous, current) -> current).get();
		
		//Assert
		assertThat("Primeiro achievement deve ser o mais recente: ", primeiroAchievement.getApiName().equals(achievementMaisRecente.getApiName()), is(true));
		assertThat("Ultimo achievement ser o ultimo bloqueado esperado: ", ultimoAchievement.getApiName().equals(ultimoAchievementNaoDesbloqueadoEsperado.getApiName()), is(true));
	}

	private List<Achievement> listaQualquerDeAchievements() {
		Achievement a = new Achievement();
		a.setApiName("ach_00");
		a.setAchieved(false);
		a.setDateUnlocked(null);
		Achievement a2 = new Achievement();
		a2.setApiName("ach_01");
		a2.setAchieved(true);
		a2.setDateUnlocked(LocalDateTime.now().plusDays(1));
		Achievement a3 = new Achievement();
		a3.setApiName("ach_02");
		a3.setAchieved(false);
		a3.setDateUnlocked(null);
		Achievement a4 = new Achievement();
		a4.setApiName("ach_03");
		a4.setAchieved(true);
		a4.setDateUnlocked(LocalDateTime.now().plusDays(2));
		Achievement a5 = new Achievement();
		a5.setApiName("ach_04");
		a5.setAchieved(true);
		a5.setDateUnlocked(LocalDateTime.now().plusDays(3));
		return Arrays.asList(a, a2, a3, a4, a5);
	}
	
}
