package app.model;


import java.util.ArrayList;
import java.util.List;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

/**
 * Classe DAO do Arbitro Ela inseri o arbritro em uma lista. 
 * Ela edita alguns atributos do arbitro. 
 * Ela excluir o arbitro. 
 * Ela lista todos os arbitros.
 * 
 * @author Nalbert Santos Araujo
 * @author Pedro Henrique
 *
 */
public class ArbitroDAO implements ArbitroDAOInterface{

	static private List<Arbitro> arbitros = new ArrayList<>();
	
	
	/**Metodo para inserir um arbitro já criado, no banco de dados
	 * @throws StringVaziaException 
	 * @throws CaracterInvalidoException 
	 * @throws ObjetoJaExisteException **/
	static public void inserir(Arbitro arbitro) throws StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException {
		if (arbitro.getNome().isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(arbitro.getNome(), "O nome só aceita letras!");			
		}
		
		if (arbitros.contains(arbitro)) {
			throw new ObjetoJaExisteException("O Arbitro já existe na lista!");
		} else {
			arbitros.add(arbitro);
		}
	}
	
	static public boolean inserirConsole(Arbitro arbitro) {
		if (arbitro.getNome().isEmpty()) {
			return false;
		} else {
			try {
				Funcoes.verificarString(arbitro.getNome(), "O nome só aceita letras!");							
			} catch (CaracterInvalidoException e) {
				return false;
			}
		}
		
		if (arbitros.contains(arbitro)) {
			return false;
		} else {
			arbitros.add(arbitro);
			return true;
		}
	}
	/**Metodo para editar um arbitro que já existente no banco de dados, passando a referencia dele e o novo nome que ele deve receber
	 * @throws ObjetoJaExisteException 
	 * @throws ObjetoNaoExisteException 
	 * @throws CaracterInvalidoException 
	 * @throws StringVaziaException **/
	static public void editar(Arbitro arbitro, String nome) throws ObjetoJaExisteException, ObjetoNaoExisteException, CaracterInvalidoException, StringVaziaException {
		if (nome.isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(nome, "O nome só aceita letras!");
		}
		if (arbitro == null) {
			throw new ObjetoNaoExisteException("Arbitro não existe!");
		} else if (ArbitroDAO.existeArbitro(nome)) {
			throw new ObjetoJaExisteException("O Arbitro já existe na lista!");
		}
		arbitro.setNome(nome);
	}
	/**Metodo para excluir um arbitro existente no banco de dados com base no index do mesmo
	 * @throws ObjetoNaoExisteException **/
	static public void excluir(String nome) throws ObjetoNaoExisteException {
		Arbitro arbitroComparacao = new Arbitro(nome);
		if (!arbitros.remove(arbitroComparacao)) {
			throw new ObjetoNaoExisteException("Arbitro não existe na lista!");
		}
	}
	/**Metodo para mostrar todos os arbitros que estão no banco de dados**/
	static public void listar() {
		if (arbitros.size() > 0) {
			System.out.println("\nARBITROS:");
			int contador = 0;
			for (Arbitro arbitro: arbitros) {
				System.out.println("[" + contador + "] " + arbitro);	
				contador++;
			}			
		} else {
			System.out.println("\nO sistema ainda não possui nenhum arbitro salvo!\n");
		}
		System.out.println();
	}
	/**Metodo para retornar um arbitro com base em um numero dado para procurar no banco de dados**/
	static public Arbitro getOneArbitro(int num) {
		if (num > arbitros.size() - 1 || num < 0) {
			return null;
		}else {
			//System.out.println("\nO numero esta fora da lista!\n");
			return arbitros.get(num);			
		}
	}
	/**Metodo para contar e retorna a quantidade de arbitros presentes no banco de dados**/
	static public int quantidadeArbitro() {
		return arbitros.size();
	}
	/** Metodo para retorna uma lista de arbitros que possuem uma determina string no nome **/
	public static List<Arbitro> getArbitroNome(String nome) {
		List<Arbitro> listaArbitro = new ArrayList<>();
		for(Arbitro arbitro: arbitros) {
			if (arbitro.getNome().toLowerCase().contains(nome.toLowerCase())) {
				listaArbitro.add(arbitro);
			}
			
		}
		return listaArbitro;
	}
	
	/** Metodo para verificar se algum arbitro possui um determinado nome **/
	private static boolean existeArbitro(String nome) {
		for (Arbitro arbitro: arbitros) {
			if (arbitro.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	/** Metodo para resetar a lista de arbitros **/
	public static void resetarLista() {
		arbitros.clear();
	}
	
	/**Metodo para retornar todos os nomes dos arbitros presentes na lista de arbitros**/
	public static List<String> todosNomesArbitros(){
		List<String> lista = new ArrayList<>();
		for (Arbitro arbitro: arbitros) {
			lista.add(arbitro.getNome());
		}
		return lista;
	}
	
	/**Metodo para retorna um arbitro com base no nome escolhido**/
	public static Arbitro getArbitroPorNome(String nome) throws ObjetoNaoExisteException {
		for (Arbitro arbitro: arbitros) {
			if (arbitro.getNome().equals(nome)) {
				return arbitro;
			}
		}
		throw new ObjetoNaoExisteException("Arbitro não existe na lista!");
	}
	

	
}