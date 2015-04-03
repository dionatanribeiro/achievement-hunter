package br.com.achievehunter.core.exception;

public class GameStatsNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Ocorreu erro ao buscar os dados do jogo: " + super.getMessage();
	}

}
