package model;

import java.util.ArrayList;
import java.util.List;

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
	static private int tamanhoLista = 0;
	
	/**Metodo para inserir um arbitro já criado, no banco de dados**/
	static public boolean inserir(Arbitro arbitro) {
		if (!veriricarNomeArbitro(arbitro.getNome())) {
			arbitros.add(arbitro);
			tamanhoLista++;
			return true;	
		} else {
			return false;
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
		if (num <= tamanhoLista-1 && num >= 0) {
			arbitros.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
	}
	/**Metodo para mostrar todos os arbitros que estão no banco de dados**/
	static public void listar() {
		System.out.println("\nARBITROS:");
		int contador = 0;
		for (Arbitro arbitro: arbitros) {
			System.out.println("[" + contador + "] " + arbitro);	
			contador++;
		}
		System.out.println();
	}
	/**Metodo para retornar um arbitro com base em um numero dado para procurar no banco de dados**/
	static public Arbitro getOneArbitro(int num) {
		if (num > tamanhoLista-1 || num < 0) {
			return null;
		}else {
			System.out.println("\nO numero esta fora da lista!\n");
			return arbitros.get(num);			
		}
	}
	/**Metodo para contar e retorna a quantidade de arbitros presentes no banco de dados**/
	static public int contarArbitro() {
		return arbitros.size();
	}
	
	public static Arbitro getArbitroNome(String nome) {
		for(Arbitro arbitro: arbitros) {
			if (arbitro.getNome().equals(nome)) {
				return arbitro;
			}
			
		}
		return null;
	}
	
	private static boolean veriricarNomeArbitro(String nome) {
		for (Arbitro arbitro: arbitros) {
			if (arbitro.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
}
