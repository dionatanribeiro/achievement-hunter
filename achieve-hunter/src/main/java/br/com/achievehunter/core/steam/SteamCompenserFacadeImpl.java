package br.com.achievehunter.core.steam;

import java.util.ArrayList;
import java.util.List;

import br.com.achievehunter.model.SteamGame;
import br.com.achievehunter.model.SteamProfile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

public class SteamCompenserFacadeImpl implements SteamCompenserFacade{

	@Override
	public SteamProfile findSteamProfileBySteamId64(long steamId) {
		SteamProfile steamProfile = null;
		try {
			SteamId usuario = SteamId.create(steamId);
			List<SteamGame> listaGames = new ArrayList<>();
			usuario.getGames().forEach((appId, game) -> listaGames.add(new SteamGame(appId, game.getName())));

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
	
}
