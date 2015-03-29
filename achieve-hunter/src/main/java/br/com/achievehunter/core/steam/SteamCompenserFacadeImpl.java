package br.com.achievehunter.core.steam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

@Service
public class SteamCompenserFacadeImpl implements SteamCompenserFacade {

	@Override
	public Profile findSteamProfileBySteamId64(Long steamId) {
		Profile steamProfile = null;
		try {
			SteamId usuario = SteamId.create(steamId);
			List<Game> listaGames = new ArrayList<>();
			usuario.getGames().forEach((gameKey, game) -> listaGames.add(new Game(game.getAppId()
																				, game.getName()
																				, game.getLogoUrl())));
			steamProfile = SteamProfileBuilder.builder().withSteamId(usuario.getSteamId64())
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
	public Profile findSteamProfileByNickName(String nickName) {
		return null;
	}

	@Override
	public Game findGameByUserIdAndGameId(Long steamUserId, Integer appId) {
		return SteamCompenserUtils.loadGame(steamUserId, appId);
	}
	
}
