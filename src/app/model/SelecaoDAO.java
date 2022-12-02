package app.model;

import java.util.ArrayList;
import java.util.List;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

/**
 * Classe DAO da Selecao. Ela inseri a seleção na lista de seleções. Ela edita
 * alguns atributos da seleção. Ela excluir a seleção. Ela lista tados as
 * seleções.
 * 
 * @author Nalbert Santos Araujo
 * @author Pedro Henrique
 *
 */
public class SelecaoDAO implements SelecaoDAOInterface {
	int a = 0;
	/** Lista para guarda as seleções **/
	static private List<Selecao> selecoes = new ArrayList<>();

	/** Metodo para inserir uma seleção já criada no banco de dados **/
	static public void inserir(Selecao selecao) throws ObjetoJaExisteException, CaracterInvalidoException, ListaCheiaException, StringVaziaException, StringIndexOutOfBoundsException{
		if (selecao.getNome().isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(selecao.getNome(), "O nome só aceita letras!");			
		}
		
		if (selecoes.size() == 32) {
			throw new ListaCheiaException("A lista de seleções já esta cheia!");
		} else if (selecoes.contains(selecao)) {
			throw new ObjetoJaExisteException("A seleção já existe na lista!");
		} else {
			selecoes.add(selecao);
		}
	}

	static public boolean inserirConsole(Selecao selecao) {
		if (selecoes.size() < 32 && !selecoes.contains(selecao)) {
			selecoes.add(selecao);
			return true;
		} else {
			return false;
		}
	}

	
	/** Metodo para editar uma seleção que já existente no banco de dados 
	 * @throws ObjetoJaExisteException 
	 * @throws ObjetoNaoExisteException 
	 * @throws CaracterInvalidoException 
	 * @throws StringVaziaException **/
	static public void editar(Selecao selecao, String nome) throws ObjetoJaExisteException, ObjetoNaoExisteException, CaracterInvalidoException, StringVaziaException {
		if (nome.isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(nome, "O nome só aceita letras!");
		}
		if (selecao == null) {
			throw new ObjetoNaoExisteException("Seleção não existe!");
		} else if (SelecaoDAO.existeSelecao(new Selecao(nome))) {
			throw new ObjetoJaExisteException("A Seleção já existe na lista!");
		}
		selecao.setNome(nome);
	}

	/** Metodo para excluir uma seleção existente no banco de dados **/
	static public boolean excluir(int num) {
		if (num < selecoes.size() && num >= 0) {
			List<Jogador> jogadores = getOneSelecao(num).getJogadores();
			for (Jogador jogador : jogadores) {
				JogadorDAO.excluirJogadorParcial(jogador);
			}
			TecnicoDAO.excluir(TecnicoDAO.getIndexPorTecnico(getOneSelecao(num).getTecnico()));
			GrupoPrimeiraFase.excluirSelecaoGrupo(selecoes.get(num));
			selecoes.remove(num);
			return true;
		} else {
			return false;
		}
	}
	
	static public void excluir(Selecao selecao) throws ObjetoNaoExisteException {
		if (selecoes.contains(selecao)) {
			selecao = SelecaoDAO.getSelecaoPorSelecao(selecao);
			List<Jogador> jogadores = selecao.getJogadores();
			for (Jogador jogador : jogadores) {
				JogadorDAO.excluirJogadorParcial(jogador);
			}
			TecnicoDAO.excluir(TecnicoDAO.getIndexPorTecnico(selecao.getTecnico()));
			GrupoPrimeiraFase.excluirSelecaoGrupo(selecao);
			selecoes.remove(selecao);
		} else {
			throw new ObjetoNaoExisteException("Seleção não existe na lista");
		}
	}

	/** Metodo para mostrar todas as seleções que estão no banco de dados **/
	static public void listar() {
		if (selecoes.size() > 0) {
			System.out.println("\nSELEÇÕES:");
			int contador = 0;
			for (Selecao selecao : selecoes) {
				System.out.println("[" + contador + "] " + selecao);
				contador++;
			}			
		} else {
			System.out.println("\nO sistema ainda não possui nenhuma seleção salva!\n");
		}
		System.out.println();
	}

	/** Metodo para mostrar todos os jogadores das seleções **/
	static public void listarJogadors() {
		for (Selecao selecao : selecoes) {
			System.out.println(selecao);
			System.out.println(selecao.getTamanho());
			for (Jogador jogador : selecao.getJogadores()) {
				System.out.println(jogador);
			}
			System.out.println();
		}
	}

	/**
	 * Metodo para retornar uma seleção com base em um numero dado para procurar no
	 * banco de dados
	 **/
	static public Selecao getOneSelecao(int num) {
		if (num > selecoes.size() - 1 || num < 0) {
			System.out.println("\nO numero esta fora da lista!\n");
			return null;
		} else {
			return selecoes.get(num);
		}

	}

	/**
	 * Metodo para retornar a existencia ou não de uma seleção no banco de dados
	 **/
	static public boolean existeSelecao(Selecao selecao) {
		return selecoes.contains(selecao);
	}

	
	/**
	 * Metodo para retornar uma seleção do banco de dados com base no index de uma
	 * seleção
	 * @throws ObjetoNaoExisteException 
	 **/
	
	
	
	static public Selecao getSelecaoPorSelecao(Selecao selecao) throws ObjetoNaoExisteException {
		if (selecoes.contains(selecao)) {
			return selecoes.get(selecoes.indexOf(selecao));			
		}
		else {
			throw new ObjetoNaoExisteException("Não existe");
		}
	}

	static public int getIndexSelecao(Selecao selecao) {
		return selecoes.indexOf(selecao);
	}
	
	/**
	 * Metodo para retornar a quantidade de seleções presentes no banco de dados
	 **/
	static public int quantidadeSelecoes() {
		return selecoes.size();
	}

	/** Metodo para mostrar as seleções que ainda não possuem tecnicos **/
	static public void imprimirSelecaoSemTecnico() {
		System.out.println("\nSELEÇÕES:");
		int contador = 0;
		for (Selecao selecao : selecoes) {
			if (selecao.getTecnico() == null) {
				System.out.println("[" + selecoes.indexOf(selecao) + "] " + selecao);
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("Não existe seleção sem tecnico.");
		}
	}

	/** Metodo para mostrar todas as seleções que estão no banco de dados **/
	static public void imprimirSelecao() {
		System.out.println("\nSELEÇÕES:");
		for (Selecao selecao : selecoes) {
			System.out.println("[" + selecoes.indexOf(selecao) + "] " + selecao);
		}
	}

	/** Metodo para retornar a quantidade de seleções sem tecnico **/
	static public int selecoesSemTecnico() {
		int contador = 0;
		for (Selecao selecao : selecoes) {
			if (selecao.getTecnico() == null) {
				contador++;
			}
		}
		return contador;
	}

	
	public static void adicionarPartidas(Partida partida,Selecao selecao) {
		selecao.getListaPartdasList().add(partida);
	}
	
	public static List<Partida> listaPartidas(Selecao selecao){
		return selecao.getListaPartdasList();
	}

	public static List<Selecao> getSelecaoNome(String nome) {
		List<Selecao> lista = new ArrayList<Selecao>();
		for (Selecao selecao: selecoes) {
			if (selecao.getNome().contains(nome)) {
				lista.add(selecao);
			}
		}
		return lista;
	}
	
	public static void resetarLista() {
		selecoes = new ArrayList<Selecao>();
	}
	
	public static List<Selecao> selecoesComVagaJogador(){
		List<Selecao> lista = new ArrayList<>();
		for (Selecao selecao: selecoes) {
			if (selecao.getJogadores().size() < 11) {
				lista.add(selecao);
			}
		}
		return lista;
	}
	
	public static void imprimirCaracteristicas(int numSelecao) {
		selecoes.get(numSelecao).listarJogadores();
	}
	
	public static List<String> selecoesExistentes(){
		List<String> lista = new ArrayList<>();
		for (Selecao selecao: selecoes) {
			lista.add(selecao.getNome());
		}
		return lista;
	}
	
}
