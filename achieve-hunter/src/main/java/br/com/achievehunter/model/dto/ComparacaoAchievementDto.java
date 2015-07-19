package br.com.achievehunter.model.dto;

import br.com.achievehunter.model.steam.Game;

public class ComparacaoAchievementDto {

	private Long idUser;
	private Long idFriend;
	private Integer idGame;
	private Game gameAchievementsUser;
	private Game gameAchievementsFriend;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(Long idFriend) {
		this.idFriend = idFriend;
	}

	public Integer getIdGame() {
		return idGame;
	}

	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}

	public Game getGameAchievementsUser() {
		return gameAchievementsUser;
	}

	public void setGameAchievementsUser(Game gameAchievementsUser) {
		this.gameAchievementsUser = gameAchievementsUser;
	}

	public Game getGameAchievementsFriend() {
		return gameAchievementsFriend;
	}

	public void setGameAchievementsFriend(Game gameAchievementsFriend) {
		this.gameAchievementsFriend = gameAchievementsFriend;
	}

}
