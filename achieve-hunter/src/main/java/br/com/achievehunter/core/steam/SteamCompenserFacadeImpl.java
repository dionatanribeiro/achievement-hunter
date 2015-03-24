package br.com.achievehunter.core.steam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.achievehunter.model.SteamGame;
import br.com.achievehunter.model.SteamProfile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.GameAchievement;
import com.github.koraktor.steamcondenser.steam.community.GameStats;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

@Service
public class SteamCompenserFacadeImpl implements SteamCompenserFacade{

	@Override
	public SteamProfile findSteamProfileBySteamId64(long steamId) {
		SteamProfile steamProfile = null;
		try {
			SteamId usuario = SteamId.create(steamId);
			List<SteamGame> listaGames = new ArrayList<>();
			
			usuario.getGames().forEach((gameKey, game) -> listaGames.add(new SteamGame(game.getAppId(), game.getName())));

			SteamProfileBuilder builder = new SteamProfileBuilder();
			steamProfile = builder.withSteamId(usuario.getSteamId64())
								  .withRealName(usuario.getRealName())
								  .withNickName(usuario.getNickname())
								  .withAvatarUrl(usuario.getAvatarIconUrl())
								  .withAvatarMediumUrl(usuario.getAvatarMediumUrl())
								  .withAvatarFullUrl(usuario.getAvatarFullUrl())
								  .withGames(listaGames)
								  .build();
		} catch (SteamCondenserException e) {
			e.printStackTrace();
		}
		return steamProfile;
	}

	@Override
	public SteamProfile findSteamProfileByNickName(String nickName) {
		return null;
	}
	
	public static void main(String[] args) {
		long steamId = 76561198003170021L;
		
		try {
			SteamId teste = SteamId.create(steamId);
			teste.getGames();
			GameStats stats = GameStats.createGameStats(steamId, "Football Manager 2015");
			List<GameAchievement> achievements = stats.getAchievements();
		} catch (SteamCondenserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
