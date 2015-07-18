package br.com.achievehunter.core.steam.steamcompenser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.achievehunter.core.steam.builder.SteamGameBuilder;
import br.com.achievehunter.core.steam.builder.SteamProfileBuilder;
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
			List<Game> gameList = new ArrayList<>();
			usuario.getGames().forEach((gameKey, game) -> gameList.add(SteamGameBuilder.builder().withAppId(game.getAppId())
																								 .withName(game.getName())
																								 .withShortName(game.getShortName())
																								 .build()));
			List<Game> gamesWithAchievementsOrdened = gameList.stream().filter(game -> game.isHasAchievements())
																	   .sorted((g1, g2) -> g1.getName().compareTo(g2.getName()))											
																	   .collect(Collectors.toList());
			steamProfile = SteamProfileBuilder.builder().withSteamId(usuario.getSteamId64())
														.withRealName(usuario.getRealName())
														.withNickName(usuario.getNickname())
														.withResumo(usuario.getSummary())
														.withEndereco(usuario.getLocation())
														.withAvatarUrl(usuario.getAvatarIconUrl())
														.withAvatarMediumUrl(usuario.getAvatarMediumUrl())
														.withAvatarFullUrl(usuario.getAvatarFullUrl())
														.withGames(gamesWithAchievementsOrdened)
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

	@Override
	public List<Profile> findFriendListBySteamId(Long steamId) {
		try {
			SteamId usuario = SteamId.create(steamId);
			SteamId[] steamCompenserFriendList = usuario.getFriends();
			List<Profile> friendList = new ArrayList<>();
			for (SteamId friend : steamCompenserFriendList) {
				
			}
		} catch (SteamCondenserException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
