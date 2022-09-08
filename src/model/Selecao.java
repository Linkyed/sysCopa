package model;

import java.util.Objects;

public class Selecao{
	private Jogador[] jogadores = new Jogador[26];
	private Tecnico tecnico;
	private String nome;
	
	Selecao(String nome) {
		this.nome = nome;
	}
	
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
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int hashCode() {
		return Objects.hash(nome);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selecao other = (Selecao) obj;
		return Objects.equals(nome, other.nome);
	}
	
	

	
	
}
