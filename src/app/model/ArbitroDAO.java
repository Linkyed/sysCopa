package app.model;


import java.util.ArrayList;
import java.util.List;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
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
	int a = 0;
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
	/**Metodo para editar um arbitro que já existente no banco de dados, passando a referencia dele e o novo nome que ele deve receber**/
	static public boolean editar(Arbitro arbitro, String nome) {
		if (arbitro.getNome().equals(nome) || veriricarNomeArbitro(nome)) {
			return false;
		}else {
			arbitro.setNome(nome);
			return true;
		}
	}
	/**Metodo para excluir um arbitro existente no banco de dados com base no index do mesmo**/
	static public boolean excluir(int num) {
		if (num <= arbitros.size()-1 && num >= 0) {
			arbitros.remove(num);

			return true;
		} else {
			return false;
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
			if (arbitro.getNome().contains(nome)) {
				listaArbitro.add(arbitro);
			}
			
		}
		return listaArbitro;
	}
	
	/** Metodo para verificar se algum arbitro possui um determinado nome **/
	private static boolean veriricarNomeArbitro(String nome) {
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
}