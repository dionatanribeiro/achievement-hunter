package br.com.achievehunter.core.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.GameAchievement;
import com.github.koraktor.steamcondenser.steam.community.SteamGame;
import com.github.koraktor.steamcondenser.steam.community.SteamId;
import com.github.koraktor.steamcondenser.steam.community.XMLData;

public class GameStats {

	protected XMLData xmlData;
	private List<GameAchievement> achievements;
	
	protected SteamGame game;

    protected String hoursPlayed;

    protected String privacyState;
	
	public static GameStats createGameStats(Long steamId, Integer appId) throws SteamCondenserException {
		return new GameStats(steamId, appId);
	}
	
	private GameStats(Long userId, Integer gameId) throws SteamCondenserException{
		String gameUrl;
        try {
        	gameUrl = "appid/" + gameId;
        	this.xmlData = new XMLData(getBaseUrl(userId, gameUrl) + "?xml=all");
		} catch (SteamCondenserException e) {
			SteamId user = SteamId.create(userId);
			gameUrl = user.getGames().get(gameId).getShortName().trim();
			this.xmlData = new XMLData(getBaseUrl(userId, gameUrl) + "?xml=1");
		}
        
        this.privacyState = this.xmlData.getString("privacyState");
        if(this.isPublic()) {
            Pattern appIdPattern = Pattern.compile("http://steamcommunity\\.com/+app/+([1-9][0-9]*)", Pattern.CASE_INSENSITIVE);
            Matcher appIdMatcher = appIdPattern.matcher(this.xmlData.getString("game", "gameLink"));
            appIdMatcher.find();
            int appId = Integer.parseInt(appIdMatcher.group(1));
            this.game = SteamGame.create(appId, this.xmlData.getElement("game"));
            this.hoursPlayed = this.xmlData.getString("stats", "hoursPlayed");
        }
        
	}

	private String getBaseUrl(Long userId, String gameUrl) {
        return "http://steamcommunity.com/profiles/" + userId + "/stats/" + gameUrl;
	}
	
	/**
     * Retorna o status dos achievements a partir do usuário e o jogo
     * 
     * @return Todos os Achievements pertencentes ao jogo
     */
    public List<GameAchievement> getAchievements() {
        if(this.achievements == null) {
            this.achievements = new ArrayList<GameAchievement>();
            for(XMLData achievementData : this.xmlData.getElements("achievements", "achievement")) {
                SteamId noUser = null;
                SteamGame noGame = null;
            	GameAchievement achievement = new GameAchievement(noUser, noGame, achievementData);
                this.achievements.add(achievement);
            }
        }
        return achievements;
    }
	
    /**
     * Returns the game these stats belong to
     *
     * @return The game object
     */
    public SteamGame getGame() {
        return this.game;
    }
    
    /**
     * Retorna o número de horas jogadas pelo jogador nas últimas 2 semanas
     *
     * @return número de horas jogadas
     */
    public String getHoursPlayed() {
        return this.hoursPlayed;
    }
    
    /**
     * Returns whether this Steam ID is publicly accessible
     *
     * @return <code>true</code> if this Steam ID is publicly accessible
     */
    protected boolean isPublic() {
        return this.privacyState.equals("public");
    }
    
}
