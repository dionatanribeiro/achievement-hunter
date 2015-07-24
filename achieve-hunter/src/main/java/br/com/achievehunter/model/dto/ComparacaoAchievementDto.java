package br.com.achievehunter.model.dto;

import java.io.Serializable;
import java.util.List;

import br.com.achievehunter.model.steam.Achievement;

public class ComparacaoAchievementDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private Long idFriend;
	private Integer idGame;

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


}
