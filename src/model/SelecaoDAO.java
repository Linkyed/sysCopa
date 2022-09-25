package model;

import java.util.ArrayList;
import java.util.List;

public class SelecaoDAO {
	int a = 0;
	static private List<Selecao> selecoes = new ArrayList<>();
	static private int tamanhoLista = 0;
	static public boolean inserir(Selecao selecao) {
		if (tamanhoLista < 32) {
			tamanhoLista++;
			selecoes.add(selecao);
			return true;
		} else {
			return false;
		}
	}
	static public boolean editar(Selecao selecao, String nome) {
		if (nome.isEmpty() == true) {
			return false;
		} else {
			selecao.setNome(nome);
			return true;
		}
	}
	
	static public boolean editar(Selecao selecao, Jogador jogador) {
		if (selecao.getJogadores().contains(jogador) == true) {
			JogadorDAO.excluir(jogador);
			return selecao.removerJogador(jogador);
		} else {
			JogadorDAO.inserir(jogador, selecao);
			return selecao.addJogador(jogador);
		}
	}

	static public boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			List<Jogador> jogadores = getOneSelecao(num).getJogadores();
			for (Jogador jogador : jogadores) {
				JogadorDAO.excluir(jogador);
			}
			selecoes.remove(num);
			return true;
		} else {
			return false;
		}
	}
	static public void listar() {
		System.out.println("SELEÇÕES:");
		for (Selecao selecao: selecoes) {
			System.out.println(selecao);	
		}
	}
	
	static public Selecao getOneSelecao(int num) {
		return selecoes.get(num);
	}
	
	static public boolean existeSelecao(Selecao selecao) {
		return selecoes.contains(selecao);
	}
	
	static public Selecao indexSelecao(Selecao selecao) {
		return selecoes.get(selecoes.indexOf(selecao));
	}
}
