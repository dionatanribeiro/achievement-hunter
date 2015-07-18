package br.com.achievehunter.core.steam.webapi;

public enum SteamWebApiArgs {
	
	API_KEY("4869861D43428379308A740BCD9B276D"),
	BASE_URL("http://api.steampowered.com/"),
	PROFILE("ISteamUser/GetPlayerSummaries/v0002/"),
	FRIEND_LIST("ISteamUser/GetFriendList/v0001/"),
	GAME("ISteamUserStats/GetSchemaForGame/v2/"),
	PLAYER_GAME_LIST("IPlayerService/GetOwnedGames/v0001/"),
	PLAYER_GAME_STATS("ISteamUserStats/GetUserStatsForGame/v0002/"),
	PLAYER_ACHIEVEMENT_GAME("ISteamUserStats/GetPlayerAchievements/v0001/");
	
	private String message; 
	
	private SteamWebApiArgs(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
