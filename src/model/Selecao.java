package model;


public class Selecao{
	private Jogador[] jogadores = new Jogador[26];
	private Tecnico tecnico;
	
	
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		
		if(tecnico != null) {
			this.tecnico = tecnico;
		}
	}
	public Jogador[] getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(Jogador[] jogadores) {
		if(jogadores != null) {
			this.jogadores = jogadores;
		}
		
	}

	
	
}
