package model;

import java.util.List;

public class JogadorDAO {

	private List<Jogador> todos_Jogadores = BancoDeDados.getTodos_Jogadores();
	private List<Selecao> todas_Selecao = BancoDeDados.getSelecoes();

	boolean inserir(Jogador jogador, Selecao selecao) {
		if (todas_Selecao.contains(selecao) == true) {
			int posicao_lista = todas_Selecao.indexOf(selecao);
			Selecao selecao_Modelo = todas_Selecao.get(posicao_lista);
			if (selecao_Modelo.getTamanho() < 26 && !selecao_Modelo.getJogadores().contains(jogador)) {
				selecao_Modelo.addJogador(jogador);
				todos_Jogadores.add(jogador);
			}
			return true;
		}
		return false;
	}

	boolean editar_nome(Jogador jogador, String nome) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setNome(nome);
			return true;
		}
		return false;

	}

	boolean editar_Cart_Amarelo(Jogador jogador, int cartao_amarelo) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setCartaoAmarelo(cartao_amarelo);
			return true;
		}
		return false;
	}

	boolean editar_Cart_Vermelho(Jogador jogador, int cartao_vermelho) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setCartaoVermelho(cartao_vermelho);
			return true;
		}
		return false;

	}

	boolean editar_Gol_Marcado(Jogador jogador, int gol_Marcado) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setGolmarcado(gol_Marcado);
			return true;
		}
		return false;
	}

	boolean excluir(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			Selecao selecao_modelo = modelo_Jogador.getSelecao();
			selecao_modelo.getJogadores().remove(modelo_Jogador);
			todos_Jogadores.remove(modelo_Jogador);
			return true;
		} else {
			return false;
		}
	}

	boolean listar() {

		if (todos_Jogadores.isEmpty()) {
			System.out.println("Não existe nenhum jogador cadastrado.");
			return false;
		} else {
			System.out.println("Lista de Todos os Jogadores");
			System.out.println("=================================");
			for (Jogador jogador : todos_Jogadores) {
				System.out.println(jogador);
			}
			return true;
		}
	}
}
