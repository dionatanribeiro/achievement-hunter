package br.com.achievehunter.core.steam.webapi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

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
	
}
