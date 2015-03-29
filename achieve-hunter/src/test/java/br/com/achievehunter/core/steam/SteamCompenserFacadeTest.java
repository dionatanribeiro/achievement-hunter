package br.com.achievehunter.core.steam;

import org.junit.Before;
import org.junit.Test;

import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SteamCompenserFacadeTest {

	private SteamCompenserFacade facade;
	
	@Before
	public void setUp() {
		facade = new SteamCompenserFacadeImpl();
	}
	
	@Test
	public void quandoCriaUmPerfilPorIdUsuario() {
		//Arrange
		long steamId = 76561198003170021L;
		
		//Act
		Profile steamProfile = facade.findSteamProfileBySteamId64(steamId);
		
		//Assert
		assertThat("Perfil encontrado não deve ser nulo", steamProfile, notNullValue());
		assertThat("Perfil deve possuir nome: " + steamProfile.getRealName(), steamProfile.getRealName(), notNullValue());
		assertThat("Perfil deve possuir nick: " + steamProfile.getNickName(), steamProfile.getNickName(), notNullValue());
	}
	
	@Test
	public void quandoBuscaDadosDoJogo() {
		//Arrange
		long steamId = 76561198003170021L;
		Profile steamProfile = facade.findSteamProfileBySteamId64(steamId);
		Game gameQualquer = steamProfile.getGames().stream().findAny().get();
		
		//Act
		
	}
	
}
