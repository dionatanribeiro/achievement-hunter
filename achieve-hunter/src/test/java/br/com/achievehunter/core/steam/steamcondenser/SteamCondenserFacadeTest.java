package br.com.achievehunter.core.steam.steamcondenser;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.achievehunter.model.dto.AchievementCompareGridDto;
import br.com.achievehunter.model.dto.ComparacaoAchievementDto;
import br.com.achievehunter.model.dto.RankingTotalAchievementDto;
import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

public class SteamCondenserFacadeTest {

	private SteamCondenserFacade facade;
	
	@Before
	public void setUp() {
		facade = new SteamCondenserFacadeImpl();
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
	public void quandoComparaAchievementsComUmAmigo() {
		//Arrange
		ComparacaoAchievementDto comparacaoAchievementDto = buildComparacaoAchievementsDto();
		
		//Act
		AchievementCompareGridDto dtoResultado = facade.compareFriendAchievements(comparacaoAchievementDto);
		
		//Assert
		assertThat("Lista de comparacao de achievements nao deve ser vazia", dtoResultado.getAchievementCompareDto().isEmpty(), is(false));
	}
	
	@Test
	public void verificaTamanhoListaDeAchievementsEmComparacao() {
		//Arrange
		ComparacaoAchievementDto comparacaoAchievementDto = buildComparacaoAchievementsDto();
		int totalListaAchievementsDoJogo = facade.findGameByUserIdAndGameId(comparacaoAchievementDto.getIdUser(), comparacaoAchievementDto.getIdGame()).getAchievements().size();
		
		//Act
		int totalDtoResultado = facade.compareFriendAchievements(comparacaoAchievementDto).getAchievementCompareDto().size();
		
		//Assert
		assertThat("Lista de comparacao de achievements deve ter o mesmo tamanho que a lista original", totalListaAchievementsDoJogo == totalDtoResultado, is(true));
	}

	@Test
	public void verificaTotalizadoresDaGridComparacaoAchievements() {
		//Arrange
		ComparacaoAchievementDto comparacaoAchievementDto = buildComparacaoAchievementsDto();
	
		//Act
		AchievementCompareGridDto compareAchievementGrid = facade.compareFriendAchievements(comparacaoAchievementDto);
		
		//Assert
		assertThat("Deve retornar o total de conquistas maior que zero", compareAchievementGrid.getTotalGameAchievement().intValue(), greaterThan(0));
		assertThat("Deve retornar o total de conquistas do usuario maior que zero", compareAchievementGrid.getTotalAchievementUnlockedUser().intValue(), greaterThan(0));
		assertThat("Deve retornar o total de conquistas do amigo maior que zero", compareAchievementGrid.getTotalAchievementUnlockedFriend().intValue(), greaterThan(0));
	}
	
	@Test
	public void verificaInformacoesDoJogoDaGridComparacaoAchievements() {
		//Arrange
		ComparacaoAchievementDto comparacaoAchievementDto = buildComparacaoAchievementsDto();
		
		//Act
		AchievementCompareGridDto compareAchievementGrid = facade.compareFriendAchievements(comparacaoAchievementDto);
		
		//Assert
		assertThat("Deve retornar o logo do jogo", !Strings.isNullOrEmpty(compareAchievementGrid.getGameLogoUrl()), is(true));
		assertThat("Deve retornar o nome do jogo", !Strings.isNullOrEmpty(compareAchievementGrid.getGameName()), is(true));
	}
	
	@Test
	public void quandoCriaRankingTotalAchievements() {
		//Arrange
		List<Profile> profileList = new ArrayList<>();
		profileList.add(facade.findSteamProfileBySteamId64(76561198003170021L));
		profileList.add(facade.findSteamProfileBySteamId64(76561198079620996L));
		
		//Act
		List<RankingTotalAchievementDto> rankingTotalAchievement = facade.findRankingTotalAchievementByUser(profileList);
		
		//Assert
		assertThat("Lista não deve ser nula", rankingTotalAchievement, notNullValue());
		assertThat("Lista não deve ser vazia", rankingTotalAchievement.isEmpty(), is(false));
		assertThat("Deve retornar um total de achievements maior que zero", rankingTotalAchievement.get(0).getTotalAchieved().intValue(), greaterThan(0));
	}
	
	private ComparacaoAchievementDto buildComparacaoAchievementsDto() {
		long idUser = 76561198003170021L;
		long idFriend = 76561198079620996L;
		int idDarkSouls2 = 236430;
		ComparacaoAchievementDto comparacaoAchievementDto = new ComparacaoAchievementDto();
		comparacaoAchievementDto.setIdFriend(idFriend);
		comparacaoAchievementDto.setIdUser(idUser);
		comparacaoAchievementDto.setIdGame(idDarkSouls2);
		return comparacaoAchievementDto;
	}
	
}
