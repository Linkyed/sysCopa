package model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	private List<Jogador> todos_Jogadores = new ArrayList<>();
	private List<Tecnico> tecnicos = new ArrayList<>();
	private List<Selecao> selecoes = new ArrayList<>();
	private List<Arbitro> arbitros = new ArrayList<>();


	public List<Jogador> getTodos_Jogadores() {
		return todos_Jogadores;
	}
	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}
	public List<Selecao> getSelecoes() {
		return selecoes;
	}
	public List<Arbitro> getArbitros() {
		return arbitros;
	}
}
