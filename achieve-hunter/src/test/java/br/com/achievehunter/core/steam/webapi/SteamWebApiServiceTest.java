package br.com.achievehunter.core.steam.webapi;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.achievehunter.model.steam.Profile;

public class SteamWebApiServiceTest {

private SteamWebApiService service;
	
	@Before
	public void setUp() {
		service = new SteamWebApiServiceImpl();
	}
	
	@Test
	public void quandoBuscaPerfilDeJogador() {
		//Arrange
		long steamId = 76561198003170021L;
		
		//Act
		Profile perfilEncontrado = service.findProfileBySteamId(steamId);
		
		//Assert
		assertThat("Deve encontrar perfil do jogador", perfilEncontrado, notNullValue());
		assertThat("Perfil deve possuir nome: " + perfilEncontrado.getRealName(), perfilEncontrado.getRealName(), notNullValue());
		assertThat("Perfil deve possuir nick: " + perfilEncontrado.getNickName(), perfilEncontrado.getNickName(), notNullValue());
	}
	
	@Test
	public void quandoBuscaListaDeAmigosDoJogador() {
		//Arrange
		long steamId = 76561198003170021L;
		
		//Act
		List<Profile> friendsList = service.findFriendsBySteamId(steamId);
		
		//Assert
		assertThat("Deve encontrar a lista de amigos do jogador", friendsList.isEmpty(), is(false));
	}
	
	@Test
	public void quandoBuscaListaDeIdDeJogos() {
		//Arrange
		long steamId = 76561198003170021L;
		
		//Act
		List<Integer> listGamesId= service.findOwnedGamesIdBySteamId(steamId);
		
		//Assert
		assertThat("Lista de ids retornada não deve ser nula", listGamesId, notNullValue());
		assertThat("Lista de ids retornada não deve ser vazia", listGamesId.isEmpty(), is(false));
	}
	
	@Test
	public void quandoCalculaTotalDeAchievementsDesbloqueadosDeUmJogo() {
		//Arrange
		long steamId = 76561198003170021L;
		int idDarkSouls2 = 236430;
		
		//Act
		Long totalAchievementsDesbloqueados = service.findTotalAchievementUnlockedBySteamIdAndAppId(steamId, idDarkSouls2);
		
		//Assert
		assertThat("Total de achievements desbloqueados não deve ser zero", totalAchievementsDesbloqueados.intValue(), greaterThan(0));
	}
	
}
