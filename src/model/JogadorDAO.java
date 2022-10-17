package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO do Jogador.
 * Ela inseri o jogador em uma seleção. 
 * Ela edita alguns atributos do jogador. 
 * Ela excluir o jogador da seleção. 
 * Ela lista todos os Jogadores.
 * 
 * @author Nalbert Santos Araujo
 * @author Pedro Henrique
 *
 */
public class JogadorDAO implements JogadorDAOInterface{

	/**
	 * Lista que guarda todos os jogadores
	 */
	static private List<Jogador> todos_Jogadores = new ArrayList<>();

	/**
	 * inseir: Faz a inserção do jogador na seleção e na lista de todos_Jogadores.
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: Selecao
	 * @param Tipo: boolean
	 * @return true || false
	 */
	public static boolean inserir(Jogador jogador, Selecao selecao, boolean mensagem) {
		if (SelecaoDAO.existeSelecao(selecao) == true) {
			int tamanho_Max = 26;
			Selecao selecao_Modelo = SelecaoDAO.indexSelecao(selecao);
			if (selecao_Modelo.getTamanho() < tamanho_Max && !todos_Jogadores.contains(jogador)) {
				selecao_Modelo.addJogador(jogador);
				todos_Jogadores.add(jogador);
				if (mensagem) {
					System.out.println("Código do Jogador: " + jogador.getCodJog());
				}
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * editar_nome: Faz a edição do nome do jogador
	 * 
	 * @param Tipo: Jogador - jogador_Antigo
	 * @param Tipo: Jogador - jogador_Novo
	 * @return true || false
	 */
	public static boolean editarNome(Jogador jogador_Antigo, Jogador jogador_Novo) {

		if (todos_Jogadores.contains(jogador_Antigo) && !todos_Jogadores.contains(jogador_Novo)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador_Antigo);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setNome(jogador_Novo.getNome());
			return true;
		}
		return false;

	}

	/**
	 * editar_nome: Faz a edição do nome do jogador
	 * 
	 * @param Tipo: int - Número do jogador
	 * @param Tipo: String - Novo nome do jogador
	 * @return true || false
	 */
	public static boolean editarNome(int numJogador, String nome) {

		if (0 <= numJogador && numJogador < todos_Jogadores.size()) {
			for(Jogador jogador: todos_Jogadores) {
				if(jogador.getNome().equals(nome)) {
					return false;
				}
			}
			Jogador modelo_Jogador = todos_Jogadores.get(numJogador);
			if (todos_Jogadores.contains(modelo_Jogador)) {
				modelo_Jogador.setNome(nome);
				return true;
			}
		}
		return false;

	}

	/**
	 * editarCartAmarelo: Faz a edição do número de cartões Amarelos do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo número de cartões Amarelos do jogador
	 * @return true || false
	 */
	public static boolean editarCartAmarelo(Jogador jogador, int cartao_amarelo) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			if (0 < cartao_amarelo) {
				modelo_Jogador.setCartaoAmarelo(cartao_amarelo);
				return true;
			}
		}
		return false;
	}

	/**
	 * editarCartAmarelo: Faz a edição do número de cartões Amarelos do jogador
	 * 
	 * @param Tipo: int - Número do jogador
	 * @param Tipo: int - O novo número de cartões Amarelos do jogador
	 * @return true || false
	 */
	public static boolean editarCartAmarelo(int numJogador, int cartao_amarelo) {
		if (0 <= numJogador && numJogador < todos_Jogadores.size()) {
			Jogador modelo_Jogador = todos_Jogadores.get(numJogador);
			if (0 < cartao_amarelo) {
				modelo_Jogador.setCartaoAmarelo(cartao_amarelo);
				return true;
			}
		}
		return false;
	}

	/**
	 * editarCartVermelho: Faz a edição do número de cartões Vermelhos do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo número de cartões Vermelho do jogador
	 * @return true || false
	 */
	public static boolean editarCartVermelho(Jogador jogador, int cartao_vermelho) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			if (0 < cartao_vermelho) {
				modelo_Jogador.setCartaoVermelho(cartao_vermelho);
			}
			return true;
		}
		return false;

	}

	/**
	 * editarCartVermelho: Faz a edição do número de cartões Vermelhos do jogador
	 * 
	 * @param Tipo: int - Número do jogador
	 * @param Tipo: int - O novo número de cartões Vermelhos do jogador
	 * @return true || false
	 */
	public static boolean editarCartVermelho(int numJogador, int cartao_vermelho) {
		if (0 <= numJogador && numJogador < todos_Jogadores.size()) {
			Jogador modelo_Jogador = todos_Jogadores.get(numJogador);
			if (0 < cartao_vermelho) {
				modelo_Jogador.setCartaoVermelho(cartao_vermelho);
				return true;
			}
		}
		return false;
	}

	/**
	 * editarGolMarcado: Faz a edição do número de gols marcados pelo jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo número de gols marcados pelo jogador
	 * @return true || false
	 */
	public static boolean editarGolMarcado(Jogador jogador, int gol_Marcado) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setGolmarcado(gol_Marcado);
			return true;
		}
		return false;
	}

	/**
	 * editarGolMarcado: Faz a edição do número de gols marcados pelo jogador
	 * 
	 * @param Tipo: int - Número do jogador
	 * @param Tipo: int - O novo número de gols marcados pelo jogador
	 * @return true || false
	 */
	public static boolean editarGolMarcado(int numJogador, int gol_Marcado) {
		if (0 <= numJogador && numJogador < todos_Jogadores.size()) {
			Jogador modelo_Jogador = todos_Jogadores.get(numJogador);
			if (0 < gol_Marcado) {
				modelo_Jogador.setGolmarcado(gol_Marcado);
				return true;
			}
		}
		return false;
	}

	/**
	 * editarPosicao: Faz a edição da posição do jogador
	 * 
	 * @param Tipo: int - Número do jogador
	 * @param Tipo: int - O número da posição do jogador
	 * @return true || false
	 */
	public static boolean editarPosicao(int numJogador, int posicao) {
		if (0 <= numJogador && numJogador < todos_Jogadores.size()) {
			Jogador modelo_Jogador = todos_Jogadores.get(numJogador);
			if (0 <= posicao && posicao < 6) {
				modelo_Jogador.setPosicaoJogada(posicao);
				return true;
			}
		}
		return false;
	}

	/**
	 * editarPosicao: Faz a edição da posição do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O número da posição do jogador
	 * @return true || false
	 */
	public static boolean editarPosicao(Jogador jogador, int posicao) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			if (0 <= posicao && posicao < 6) {
				modelo_Jogador.setPosicaoJogada(posicao);
				return true;
			}
		}
		return false;
	}

	/**
	 * excluir: Exclui o jogador da seleção e da lista de todos os jogadores
	 * 
	 * @param Tipo: Jogador
	 * @return true || false
	 */
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

	/**
	 * excluir: Exclui o jogador da seleção e da lista de todos os jogadores
	 * 
	 * @param Tipo: int - Número do jogador
	 * @return true || false
	 */
	public static boolean excluir(int posicao) {
		if (getQuantidadeJogadores() > 0) {
			Jogador modelo_Jogador = todos_Jogadores.get(posicao);
			Selecao selecao_modelo = SelecaoDAO.indexSelecao(modelo_Jogador.getSelecao());
			selecao_modelo.removerJogador(modelo_Jogador);
			todos_Jogadores.remove(modelo_Jogador);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * excluir_Jogador_parcial: Exclui o jogador da lista de todos os jogadores
	 * 
	 * @param Tipo: Jogador
	 * @return true || false
	 */
	public static boolean excluirJogadorParcial(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			todos_Jogadores.remove(jogador);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * listar: Lista todos os jogadores cadastrados
	 * 
	 * @return true || false
	 */
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

	/**
	 * getQuantidade_jogadores: Mostra o número jogadores cadastrados
	 * 
	 * @return int
	 */
	public static int getQuantidadeJogadores() {
		return todos_Jogadores.size();
	}

	/**
	 * estaNaLista: Mostra se o jogador está na lista de jogadores
	 * 
	 * @param Tipo: Jogador
	 * @return true || false
	 */
	public static boolean estaNaLista(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			return true;
		}
		return false;

	}
	public static int getQuantidadeGols(Jogador jogador) {
		return jogador.getGolmarcado();
	}
	
	public static int getQuantidadeCartAmarelo(Jogador jogador) {
		return jogador.getCartaoAmarelo();
	}
	public static int getQuantidadeCartVermelho(Jogador jogador) {
		return jogador.getCartaoVermelho();
	}


	/**
	 * imprimirJogador: Imprime os dados do jogador
	 * 
	 * @param Tipo: Jogador
	 * @return true || false
	 */
	public static void imprimirJogador(Jogador jogador) {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			System.out.println(modelo_Jogador);
		}
	}
	public static Jogador getJogadorNome(String nome) {
		for (Jogador jogador: todos_Jogadores) {
			if(jogador.getNome().equals(nome)) {
				return jogador;
			}
		}
		return null;
	}
}
