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
	
	/**Metodo para inserir um tecnico já criado no banco de dados**/
	static public boolean inserir(Tecnico tecnico) {
		if (tecnicos.size() <= 32 && !existeTecnico(tecnico)){
			tecnicos.add(tecnico);
			return true;
		}else {
			return false;
		}
	}
	
	/**Metodo para editar um tecnico que já existente no banco de dados**/
	static public boolean editar(Tecnico tecnico, String nome) {

		if (tecnico.getNome() == nome || nome.isEmpty() == true || nome == null || verificarNome(nome)) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
	
	public static boolean editar(Tecnico tecnico, Selecao selecao) {
		if (selecao.getTecnico() == null) {
			tecnico.getSelecao().setTecnico(null);
			tecnico.setSelecao(selecao);
			selecao.setTecnico(tecnico);
			return true;			
		} else {
			return false;
		}
	}
	
	/**Metodo para excluir um tecnico existente no banco de dados**/
	static public boolean excluir(int num) {
		if (num <= tecnicos.size() && num >= 0) {
			tecnicos.get(num).getSelecao().setTecnico(null);
			tecnicos.remove(num);
			return true;
		} else {
			return false;
		}
		 
	}
	
	/**Metodo para mostrar todos os tecnicos que estão no banco de dados**/
	static public void listar() {
		if (tecnicos.size() > 0) {
			System.out.println("\nTECNICOS:");
			int contador = 0;
			for (Tecnico tecnico: tecnicos) {
				System.out.println("["+ contador +"]" + tecnico);	
				contador++;
			}			
		} else {
			System.out.println("\nO sistema ainda não possui nenhum tecnico salvo!\n");
		}
		System.out.println();
	}
	
	/**Metodo para retornar um tecnico com base em um numero dado para procurar no banco de dados**/
	static public Tecnico getOneTecnico(int num) {
		if (num > tecnicos.size() - 1 || num < 0) {
			System.out.println("\nO numero esta fora da lista!\n");
			return null;
		} else {
			return tecnicos.get(num);
		}
	
	}
	
	/**Metodo para retornar um tecnico do banco de dados com base no index de um tecnico**/
	static public Tecnico getTecnicoPorTecnico(Tecnico tecnico) {
		return tecnicos.get(tecnicos.indexOf(tecnico));
	}
	
	static public int getIndexPorTecnico(Tecnico tecnico) {
		return tecnicos.indexOf(tecnico);
	}
	
	/**Metodo para contar e retorna a quantidade de tecnicos presentes no banco de dados**/
	static public int quantidadeTecnicos() {
		return tecnicos.size();
	}
	
	public static List<Tecnico> getTecnicoNome(String nome) {
		List<Tecnico> listaTecnico = new ArrayList<>();
		for (Tecnico tecnico: tecnicos) {
			if (tecnico.getNome().contains(nome)) {
				listaTecnico.add(tecnico);
			}
		}
		return listaTecnico;
	}
	
	public static boolean existeTecnico(Tecnico tecnico) {
		return tecnicos.contains(tecnico);
	}
	
	public static boolean verificarNome(String nome) {
		for (Tecnico tecnico: tecnicos) {
			if (tecnico.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public static void resetarLista() {
		tecnicos = new ArrayList<Tecnico>();
	}
}
