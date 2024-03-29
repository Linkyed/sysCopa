package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

/**
 * Classe DAO do Jogador.
 * Ela inseri o jogador em uma sele��o. 
 * Ela edita alguns atributos do jogador. 
 * Ela excluir o jogador da sele��o. 
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
	 * inseir: Faz a inser��o do jogador na sele��o e na lista de todos_Jogadores.
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: Selecao
	 * @param Tipo: boolean
	 * @return true || false
	 * @throws ObjetoNaoExisteException 
	 * @throws ObjetoJaExisteException 
	 * @throws StringVaziaException
	 * @throws CaracterInvalidoException
	 */
	public static void inserir(Jogador jogador, Selecao selecao, boolean mensagem) throws ListaCheiaException, ObjetoJaExisteException, CaracterInvalidoException, StringVaziaException, ObjetoNaoExisteException {
		if (jogador.getNome().isEmpty()) {
			throw new StringVaziaException("O nome est� vazio!");
		} else {
			Funcoes.verificarString(jogador.getNome(), "O nome s� aceita letras!");			
		}
		
		
		if (todos_Jogadores.contains(jogador)) {
			throw new ObjetoJaExisteException("O jogador j� existe na lista!");
		} else if (SelecaoDAO.existeSelecao(selecao) == true) {
			int tamanho_Max = 11;
			Selecao selecao_Modelo = SelecaoDAO.getSelecaoPorSelecao(selecao);
			if (selecao_Modelo.getTamanho() < tamanho_Max) {
				selecao_Modelo.addJogador(jogador);
				todos_Jogadores.add(jogador);
				if (mensagem) {
					System.out.println("C�digo do Jogador: " + jogador.getCodJog());
				}
				
			} else {
				throw new ListaCheiaException("A lista de jogadores da sele��o j� esta cheia!");
			}
	
		}

	}
	/**
	 * inseir: Faz a inser��o do jogador na sele��o e na lista de todos_Jogadores.
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: Selecao
	 * @param Tipo: boolean 
	 * **/
	public static boolean inserirConsole(Jogador jogador, Selecao selecao, boolean mensagem) {
		if (SelecaoDAO.existeSelecao(selecao) == true) {
			int tamanho_Max = 11;
			Selecao selecao_Modelo = null;
			try {
				selecao_Modelo = SelecaoDAO.getSelecaoPorSelecao(selecao);
			} catch (ObjetoNaoExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (selecao_Modelo.getTamanho() < tamanho_Max && !todos_Jogadores.contains(jogador)) {
				selecao_Modelo.addJogador(jogador);
				todos_Jogadores.add(jogador);
				if (mensagem) {
					System.out.println("C�digo do Jogador: " + jogador.getCodJog());
				}
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * editar_nome: Faz a edi��o do nome do jogador
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
	 * editar_nome: Faz a edi��o do nome do jogador
	 * 
	 * @param Tipo: int - N�mero do jogador
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
	
	public static void editarNome(Jogador jogador, String novoNome) throws ObjetoNaoExisteException, StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException{
		if (novoNome.isEmpty()) {
			throw new StringVaziaException("O nome est� vazio!");
		} else {
			Funcoes.verificarString(novoNome, "O nome s� aceita letras!");			
		}
		existeJogadorComNome(novoNome);		
		jogador.setNome(novoNome);
		
		
	}

	/**
	 * editarCartAmarelo: Faz a edi��o do n�mero de cart�es Amarelos do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo n�mero de cart�es Amarelos do jogador
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
	 * editarCartAmarelo: Faz a edi��o do n�mero de cart�es Amarelos do jogador
	 * 
	 * @param Tipo: int - N�mero do jogador
	 * @param Tipo: int - O novo n�mero de cart�es Amarelos do jogador
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
	 * editarCartVermelho: Faz a edi��o do n�mero de cart�es Vermelhos do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo n�mero de cart�es Vermelho do jogador
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
	 * editarCartVermelho: Faz a edi��o do n�mero de cart�es Vermelhos do jogador
	 * 
	 * @param Tipo: int - N�mero do jogador
	 * @param Tipo: int - O novo n�mero de cart�es Vermelhos do jogador
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
	 * editarGolMarcado: Faz a edi��o do n�mero de gols marcados pelo jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O novo n�mero de gols marcados pelo jogador
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
	 * editarGolMarcado: Faz a edi��o do n�mero de gols marcados pelo jogador
	 * 
	 * @param Tipo: int - N�mero do jogador
	 * @param Tipo: int - O novo n�mero de gols marcados pelo jogador
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
	 * editarPosicao: Faz a edi��o da posi��o do jogador
	 * 
	 * @param Tipo: int - N�mero do jogador
	 * @param Tipo: int - O n�mero da posi��o do jogador
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
	 * editarPosicao: Faz a edi��o da posi��o do jogador
	 * 
	 * @param Tipo: Jogador
	 * @param Tipo: int - O n�mero da posi��o do jogador
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
	public static void editarPosicao(Jogador jogador, String posicao) throws ObjetoNaoExisteException {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			modelo_Jogador.setPosicaoJogada(posicao);
		} else {
			throw new ObjetoNaoExisteException("O jogador n�o existe na lista!");
		}
	}

	/**
	 * excluir: Exclui o jogador da sele��o e da lista de todos os jogadores
	 * 
	 * @param Tipo: Jogador
	 * @return true || false
	 * @throws ObjetoNaoExisteException 
	 */
	public static void excluir(Jogador jogador) throws ObjetoNaoExisteException {
		if (todos_Jogadores.contains(jogador)) {
			int posicao_lista_jogadores = todos_Jogadores.indexOf(jogador);
			Jogador modelo_Jogador = todos_Jogadores.get(posicao_lista_jogadores);
			Selecao selecao_modelo = SelecaoDAO.getSelecaoPorSelecao(modelo_Jogador.getSelecao());
			selecao_modelo.removerJogador(modelo_Jogador);
			todos_Jogadores.remove(modelo_Jogador);
	
		} else {
			throw new ObjetoNaoExisteException("Jogador n�o existe na lista!");
		}
	}

	
	/**
	 * excluir: Exclui o jogador da sele��o e da lista de todos os jogadores
	 * 
	 * @param Tipo: int - N�mero do jogador
	 * @return true || false
	 * @throws ObjetoNaoExisteException 
	 */
	public static boolean excluir(int posicao) throws ObjetoNaoExisteException {
		if (getQuantidadeJogadores() > 0 && (posicao >= 0 && posicao < todos_Jogadores.size())) {
			Jogador modelo_Jogador = todos_Jogadores.get(posicao);
			Selecao selecao_modelo = SelecaoDAO.getSelecaoPorSelecao(modelo_Jogador.getSelecao());
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
			System.out.println("N�o existe nenhum jogador cadastrado.");
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
	 * getQuantidade_jogadores: Mostra o n�mero jogadores cadastrados
	 * 
	 * @return int
	 */
	public static int getQuantidadeJogadores() {
		return todos_Jogadores.size();
	}

	/**
	 * estaNaLista: Mostra se o jogador est� na lista de jogadores
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
	/** Metodo para retorna a quantidades de gol de um jogador **/
	public static int getQuantidadeGols(Jogador jogador) {
		return jogador.getGolmarcado();
	}
	
	/** Metodo para retorna a quantidade de cart�es amarelo de um jogador **/
	public static int getQuantidadeCartAmarelo(Jogador jogador) {
		return jogador.getCartaoAmarelo();
	}
	
	/** Metodo para retorna a quantidade de cart�es vermelhos de um jogador **/
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
	
	/** Metodo para retorna uma lista de jogadores que possuem uma determinada string no nome **/
	public static List<Jogador> getJogadorNome(String nome) {
		List<Jogador> listaJogadores = new ArrayList<>();
		for (Jogador jogador: todos_Jogadores) {
			if(jogador.getNome().toLowerCase().contains(nome.toLowerCase())) {
				listaJogadores.add(jogador);
			}
		}
		return listaJogadores;
	}
	
	/** Metodo para resetar a lista **/
	public static void resetarLista() {
		todos_Jogadores.clear();
		SelecaoDAO.resetarLista();
	}
	
	/** Metodo para retorna um jogador da lista com base em um index **/
	public static Jogador getOneJogador(int num) {
		if (num >= 0 && num < todos_Jogadores.size()) {
			return todos_Jogadores.get(num);
		} else {
			return null;
		}
	}
	
	/**Metodo para buscar um determinado jogador com base em um nome**/
	public static Jogador getJogadorPorNome(String nome) throws ObjetoNaoExisteException {
		for (Jogador jogador: todos_Jogadores) {
			if (jogador.getNome().equals(nome)) {
				return jogador;
			}
		}
		throw new ObjetoNaoExisteException("O jogador n�o existe na lista!");
	}
	
	/**Metodo para retorna um true ou false caso exista um jogador com determinado nome**/
	public static boolean existeJogadorComNome(String nome) throws ObjetoJaExisteException {
		for (Jogador jogador: todos_Jogadores) {
			if (jogador.getNome().equals(nome)) {
				throw new ObjetoJaExisteException("O jogador j� existe na lista!");
			}
		}
		return false;
	}
	
	/**Metodo para retorna o nome de todos os jogadores existentes na lista**/
	public static List<String> jogadoresExistentes(){
		List<String> lista = new ArrayList<>();
		for (Jogador jogador: todos_Jogadores) {
			lista.add(jogador.getNome());
		}
		return lista;
	}
	
	public static HashMap<String, String> jogadoresEPosicoes(){
		HashMap<String, String> lista = new HashMap<>();
		for (Jogador jogador: todos_Jogadores) {
			lista.put(jogador.getNome(), jogador.getPosicaoJogada());
		}
		return lista;
	}
	
}