package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Selecao{
	private List<Jogador> jogadores = new ArrayList<>();
	private int tamListaJogadores = 0;
	private Tecnico tecnico;
	private String nome;
	
	Selecao(String nome) {
		this.nome = nome;
	}
	
	Selecao(String nome, Tecnico tecnico) {
		this.nome = nome;
		this.tecnico = tecnico;
	}
	
	public boolean addJogador(Jogador jogador) {
		if (tamListaJogadores < 26) {
			tamListaJogadores++;
			jogadores.add(jogador);
			return true;
		}else {
			return false;
		}
	}
	public boolean removerJogador(Jogador jogador) {
		if (jogadores.contains(jogador) == true) {
			tamListaJogadores--;
			jogadores.remove(jogador);
			return true;
		} else {
			return false;
		}
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		
		if(tecnico != null) {
			this.tecnico = tecnico;
		}
	}
	
	public String getNome() {
		return nome;
	}
	public int getTamanho() {
		return tamListaJogadores;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
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

	public String toString() {
		return "Nome: " + this.nome + "|| Tecnico: " + this.tecnico;
	}

	

	

	
	
}
