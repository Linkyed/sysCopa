package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Selecao {
	private List<Jogador> jogadores = new ArrayList<>();
	private Tecnico tecnico;
	private String nome;
	private List<Partida> listaPartdas = new ArrayList<>();
	private int golSelecao = 0;

	/** Construtor que obriga a receber um String nome para criar uma seleção **/
	public Selecao(String nome) {
		this.nome = nome;
	}

	/** metodo para adicionar um jogador na lista de jogadores da seleção **/
	public boolean addJogador(Jogador jogador) {
		if (jogadores.size() <= 11 ) {
			jogadores.add(jogador);
			return true;
		} else {
			return false;
		}
	}

	/** Metodo para remover um jogador da lista de jogadores da seleção **/
	public boolean removerJogador(Jogador jogador) {
		if (jogadores.contains(jogador) == true) {
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
		this.tecnico = tecnico;
	}

	public String getNome() {
		return Funcoes.captilizeString(nome);
	}

	public int getTamanho() {
		return jogadores.size();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public int getGolSelecao() {
		return golSelecao;
	}

	public void setGolSelecao(int golSelecao) {
		if (golSelecao > 0) {
			this.golSelecao = golSelecao;
		}
	}

	public int hashCode() {
		return Objects.hash(nome);
	}

	public List<Partida> getListaPartdasList() {
		return listaPartdas;
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

	/** Metodo para mostrar a Seleção em String **/
	public String toString() {
		return this.nome;
	}

}
