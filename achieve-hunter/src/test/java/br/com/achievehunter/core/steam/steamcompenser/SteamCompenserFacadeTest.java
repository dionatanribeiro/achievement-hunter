package br.com.achievehunter.core.steam.steamcompenser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

import br.com.achievehunter.core.steam.steamcompenser.SteamCompenserFacade;
import br.com.achievehunter.core.steam.steamcompenser.SteamCompenserFacadeImpl;
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
	public void verificaSeListaDeJogosFoiOrdenadaAlfabeticamente() {
		//Arrange
		long steamId = 76561198003170021L;
		Profile steamProfile = facade.findSteamProfileBySteamId64(steamId);
		
		//Act
		List<Game> listaDeGames = steamProfile.getGames();
		List<Game> listaDeGamesCopia = new ArrayList<Game>(listaDeGames);
		listaDeGamesCopia.sort(new Comparator<Game>() {
	        @Override public int compare(Game g1, Game g2) {
	            return g1.getName().compareTo(g2.getName());
	        }           
	    });
		
		//Assert
		assertThat("Lista de jogos deve estar ordenada alfabeticamente", Iterables.elementsEqual(listaDeGames, listaDeGamesCopia), is(true));
	}
	
	@Test
	public void quandoBuscaDadosDoJogo() {
		//Arrange
		long steamId = 76561198003170021L;
		Profile steamProfile = facade.findSteamProfileBySteamId64(steamId);
		
		//Act
		Game gameQualquer = steamProfile.getGames().stream().findAny().get();
		
		//Assert
		assertThat("Deve encontrar dados de algum jogo do jogador: " + gameQualquer, notNullValue());
	}
	
	@Test
	public void quandoBuscaListaDeAmigos() {
		//Arrange
		long steamId = 76561198003170021L;
		Profile steamProfile = facade.findSteamProfileBySteamId64(steamId);
		
		//Act
		facade.findFriendListBySteamId(steamId);
	}
	
}
