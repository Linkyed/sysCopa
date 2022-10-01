package model;

import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

	static private List<Jogador> todos_Jogadores = new ArrayList<>();

	public static boolean inserir(Jogador jogador, Selecao selecao,boolean menssagem) {
		if (SelecaoDAO.existeSelecao(selecao) == true) {
			int tamanho_Max = 26;
			Selecao selecao_Modelo = SelecaoDAO.indexSelecao(selecao);
			if (selecao_Modelo.getTamanho() < tamanho_Max && !todos_Jogadores.contains(jogador)) {
				selecao_Modelo.addJogador(jogador);
				todos_Jogadores.add(jogador);
				if(menssagem) {
					System.out.println("Código do Jogador: "+ jogador.getCodJog());
				}
				return true;
			}
			return false;
		}
		return false;
	}

	public static boolean editar_nome(Jogador jogador_Antigo, Jogador jogador_Novo) {

		if (todos_Jogadores.contains(jogador_Antigo) && !todos_Jogadores.contains(jogador_Novo)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador_Antigo);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			if (modelo_Jogador.getNome().equalsIgnoreCase(jogador_Novo.getNome())) {
				return true;
			}
			return false;
		}
		return false;

	}

	public static boolean editar_Cart_Amarelo(Jogador jogador, int cartao_amarelo) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setCartaoAmarelo(cartao_amarelo);
			return true;
		}
		return false;
	}

	public static boolean editar_Cart_Vermelho(Jogador jogador, int cartao_vermelho) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setCartaoVermelho(cartao_vermelho);
			return true;
		}
		return false;

	}

	public static boolean editar_Gol_Marcado(Jogador jogador, int gol_Marcado) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setGolmarcado(gol_Marcado);
			return true;
		}
		return false;
	}

	public static boolean excluir(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			Selecao selecao_modelo = SelecaoDAO.indexSelecao(modelo_Jogador.getSelecao());
			selecao_modelo.removerJogador(modelo_Jogador);
			todos_Jogadores.remove(modelo_Jogador);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean excluir(int posicao) {
		if (getQuantidade_jogadores() > 0) {
			Jogador modelo_Jogador = todos_Jogadores.get(posicao);
			Selecao selecao_modelo = SelecaoDAO.indexSelecao(modelo_Jogador.getSelecao());
			selecao_modelo.removerJogador(modelo_Jogador);
			todos_Jogadores.remove(modelo_Jogador);
			return true;
		} else {
			return false;
		}
	}

	public static boolean excluir_Jogador_parcial(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			todos_Jogadores.remove(jogador);
			return true;
		} else {
			return false;
		}
	}
	

	public static boolean listar() {
		int contador = 0;
		if (todos_Jogadores.isEmpty()) {
			System.out.println("Não existe nenhum jogador cadastrado.");
			return false;
		} else {
			System.out.println("Lista de Todos os Jogadores");
			System.out.println("=================================");

			for (Jogador jogador : todos_Jogadores) {
				System.out.println("[" + contador + "] " + jogador);
				contador++;
			}
			System.out.println();
		}
		return true;
	}
	
	public static int getQuantidade_jogadores() {
		return todos_Jogadores.size();
		}
	
}
