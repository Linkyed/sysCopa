package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO do Tecnico.
 * Ela inseri o jogador em um tecnico na seleção. 
 * Ela edita alguns atributos do tecnico. 
 * Ela excluir o tecnico da seleção. 
 * Ela lista todos os tecnicos.
 * 
 * @author Nalbert Santos Araujo
 * @author Pedro Henrique
 *
 */
public class TecnicoDAO implements TecnicoDAOInterface{
	int a = 0;
	/**Lista para guarda os tecnicos**/
	static private List<Tecnico> tecnicos = new ArrayList<>();
	static private int tamanhoLista = 0;
	
	/**Metodo para inserir um tecnico já criado no banco de dados**/
	static public boolean inserir(Tecnico tecnico) {
		if (tamanhoLista < 32){
			tecnicos.add(tecnico);
			tamanhoLista++;
			return true;
		}else {
			return false;
		}
	}
	
	/**Metodo para editar um tecnico que já existente no banco de dados**/
	static public boolean editar(Tecnico tecnico, String nome) {

		if (tecnico.getNome() == nome || nome.isEmpty() == true || nome == null) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
	/**Metodo para excluir um tecnico existente no banco de dados**/
	static public boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			tecnicos.get(num).getSelecao().setTecnico(null);
			tecnicos.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
		 
	}
	
	/**Metodo para mostrar todos os tecnicos que estão no banco de dados**/
	static public void listar() {
		System.out.println("\nTECNICOS:");
		int contador = 0;
		for (Tecnico tecnico: tecnicos) {
			System.out.println("["+ contador +"]" + tecnico);	
		}
		System.out.println();
	}
	
	/**Metodo para retornar um tecnico com base em um numero dado para procurar no banco de dados**/
	static public Tecnico getOneTecnico(int num) {
		if (num > tamanhoLista-1 || num < 0) {
			System.out.println("\nO numero esta fora da lista!\n");
			return null;
		} else {
			return tecnicos.get(num);
		}
	
	}
	
	/**Metodo para retornar um tecnico do banco de dados com base no index de um tecnico**/
	static public Tecnico getTecnicoIndes(Tecnico tecnico) {
		return tecnicos.get(tecnicos.indexOf(tecnico));
	}
	
	/**Metodo para contar e retorna a quantidade de tecnicos presentes no banco de dados**/
	static public int contarTecnicos() {
		return tecnicos.size();
	}

}
