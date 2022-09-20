package model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	static private List<Jogador> todos_Jogadores = new ArrayList<>();
	static private List<Tecnico> tecnicos = new ArrayList<>();
	static private List<Selecao> selecoes = new ArrayList<>();
	static private List<Arbitro> arbitros = new ArrayList<>();


	static public List<Jogador> getTodos_Jogadores() {
		return todos_Jogadores;
	}
	static public List<Tecnico> getTecnicos() {
		return tecnicos;
	}
	static public List<Selecao> getSelecoes() {
		return selecoes;
	}
	static public List<Arbitro> getArbitros() {
		return arbitros;
	}
}
