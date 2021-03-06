package br.com.achievehunter.core.steam.steamcondenser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.achievehunter.core.steam.builder.SteamGameBuilder;
import br.com.achievehunter.core.steam.builder.SteamProfileBuilder;
import br.com.achievehunter.model.dto.AchievementCompareGridDto;
import br.com.achievehunter.model.dto.ComparacaoAchievementDto;
import br.com.achievehunter.model.steam.Achievement;
import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

@Service
public class SteamCondenserFacadeImpl implements SteamCondenserFacade {

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
		return SteamCondenserUtils.loadGame(steamUserId, appId, true);
	}

	@Override
	public AchievementCompareGridDto compareFriendAchievements(ComparacaoAchievementDto comparacaoAchievementDto) {
		Game gameChoosed = SteamCondenserUtils.loadGame(comparacaoAchievementDto.getIdUser(), comparacaoAchievementDto.getIdGame(), false);
		Profile userProfile = findSteamProfileBySteamId64(comparacaoAchievementDto.getIdUser());
		Profile friendProfile = findSteamProfileBySteamId64(comparacaoAchievementDto.getIdFriend());
		List<Achievement> achievementsUser = SteamCondenserUtils.loadGame(comparacaoAchievementDto.getIdUser(), comparacaoAchievementDto.getIdGame(), false).getAchievements();
		List<Achievement> achievementsFriend = SteamCondenserUtils.loadGame(comparacaoAchievementDto.getIdFriend(), comparacaoAchievementDto.getIdGame(), false).getAchievements();

		AchievementCompareGridDto grid = new AchievementCompareGridDto();
		
		grid.setGameLogoUrl(gameChoosed.getLogoUrl());
		grid.setGameName(gameChoosed.getName());
		
		grid.setNickNameUser(userProfile.getNickName());
		grid.setAvatarUser(userProfile.getAvatarMedium());
		
		grid.setNickNameFriend(friendProfile.getNickName());
		grid.setAvatarFriend(friendProfile.getAvatarMedium());
		
		grid.setTotalGameAchievement(BigDecimal.valueOf(achievementsUser.size()));
		grid.setTotalAchievementUnlockedUser(BigDecimal.valueOf(achievementsUser.stream().filter(a -> a.isAchieved()).count()));
		grid.setTotalAchievementUnlockedFriend(BigDecimal.valueOf(achievementsFriend.stream().filter(a -> a.isAchieved()).count()));
		
		grid.setAchievementCompareDto(SteamCondenserUtils.buildCompareAchievementDto(achievementsUser, achievementsFriend));
		
		return grid;
	}

}
