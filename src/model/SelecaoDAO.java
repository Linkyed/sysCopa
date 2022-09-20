package model;

import java.util.ArrayList;
import java.util.List;

public class SelecaoDAO {
	private List<Selecao> selecoes = new ArrayList<>();
	private int tamanhoLista = 0;
	boolean inserir(Selecao selecao) {
		if (tamanhoLista < 32) {
			tamanhoLista++;
			selecoes.add(selecao);
			return true;
		} else {
			return false;
		}
	}
	boolean editar(Selecao selecao, String nome) {
		if (nome.isEmpty() == true) {
			return false;
		} else {
			selecao.setNome(nome);
			return true;
		}
	}
	
	boolean editar(Selecao selecao, Jogador jogador) {
		if (selecao.getJogadores().contains(jogador.getCodJog()) == true) {
			return selecao.removerJogador(jogador.getCodJog());
		} else {
			return selecao.addJogador(jogador.getCodJog());
		}
	}

	boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			selecoes.remove(num);
			return true;
		} else {
			return false;
		}
	}
	void listar() {
		System.out.println("SELEÇÕES:");
		for (Selecao selecao: selecoes) {
			System.out.println(selecao);	
		}
	}
	
	Selecao getOneSelecao(int num) {
		return selecoes.get(num);
	}
}
