package model;

import java.util.List;

public class SelecaoDAO {
	private List<Selecao> selecoes = BancoDeDados.getSelecoes() ;
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
		if (selecao.getJogadores().contains(jogador) == true) {
			BancoDeDados.getTodos_Jogadores().remove(jogador);
			return selecao.removerJogador(jogador);
		} else {
			BancoDeDados.getTodos_Jogadores().add(jogador);
			return selecao.addJogador(jogador);
		}
	}

	boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			List<Jogador> jogadores = getOneSelecao(num).getJogadores();
			for (Jogador jogador : jogadores) {
				BancoDeDados.getTodos_Jogadores().remove(jogador);
			}
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
