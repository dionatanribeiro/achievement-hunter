package br.com.achievehunter.core.steam;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.com.achievehunter.model.steam.Achievement;
import br.com.achievehunter.model.steam.Game;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.GameAchievement;
import com.github.koraktor.steamcondenser.steam.community.GameStats;
import com.github.koraktor.steamcondenser.steam.community.SteamGame;
import com.google.common.annotations.VisibleForTesting;

public abstract class SteamCompenserUtils {

	@VisibleForTesting
	public static GameStats getGameStats(Long steamUserId, Integer gameId) throws SteamCondenserException {
        return GameStats.createGameStats(steamUserId, String.valueOf(gameId));
    }
	
	@VisibleForTesting
	public static List<Achievement> getAchievementsByGameStats(GameStats stats) throws SteamCondenserException {
		ArrayList<GameAchievement> steamCompenserAchievements = stats.getAchievements();
		List<Achievement> achievementList = new ArrayList<>();
		for (GameAchievement compenserAchievement : steamCompenserAchievements) {
			Achievement achievement = new Achievement();
			achievement.setName(compenserAchievement.getName());
			achievement.setDescription(compenserAchievement.getDescription());
			achievement.setIconLockedUrl(compenserAchievement.getIconOpenURL());
			achievement.setIconUnlockedUrl(compenserAchievement.getIconClosedURL());
			achievement.setDateUnlocked(compenserAchievement.getTimestamp().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			achievement.setAchieved(compenserAchievement.isUnlocked());
			achievementList.add(achievement);
		}
		return achievementList;
	}
	
	public static Game loadGame(Long steamUserId, Integer appId) {
		Game game = null;
		try {
			GameStats gameStats = getGameStats(steamUserId, appId);
			SteamGame steamCompenserGame = gameStats.getGame();
			game = SteamGameBuilder.builder().withAppId(steamCompenserGame.getAppId())
											 .withName(steamCompenserGame.getName())
											 .withShortName(steamCompenserGame.getShortName())
											 .withLogoUrl(steamCompenserGame.getLogoUrl())
											 .withLogoThumbnailUrl(steamCompenserGame.getLogoThumbnailUrl())
											 .withIconUrl(steamCompenserGame.getIconUrl())
											 .withAchievements(getAchievementsByGameStats(gameStats))
											 .build();
		} catch (SteamCondenserException e) {
			System.out.println(e.getMessage().toString());
		}
		return game;
	}
	
}
