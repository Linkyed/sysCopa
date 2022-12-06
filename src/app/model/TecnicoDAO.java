package app.model;

import java.util.ArrayList;
import java.util.List;

import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ListaCheiaException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

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
	static public void inserir(Tecnico tecnico, Selecao selecao) throws ListaCheiaException, ObjetoJaExisteException, CaracterInvalidoException, StringVaziaException {
		if (tecnico.getNome().isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(tecnico.getNome(), "O nome só aceita letras!");			
		}
		
		if (tecnicos.size() == 32) {
			throw new ListaCheiaException("A lista de tenicos já esta cheia!");
		} else if (tecnicos.contains(tecnico)) {
			throw new ObjetoJaExisteException("O tecnico já existe na lista!");
		} else {
			tecnicos.add(tecnico);
			selecao.setTecnico(tecnico);
		}
	}
	
	static public boolean inserirConsole(Tecnico tecnico) {
		if (tecnicos.size() <= 32 && !existeTecnico(tecnico)){
			tecnicos.add(tecnico);
			return true;
		}else {
			return false;
		}
	}
	
	/**Metodo para editar um tecnico que já existente no banco de dados
	 * @throws StringVaziaException 
	 * @throws CaracterInvalidoException 
	 * @throws ObjetoNaoExisteException 
	 * @throws ObjetoJaExisteException **/
	static public void editar(Tecnico tecnico, String nome) throws StringVaziaException, CaracterInvalidoException, ObjetoNaoExisteException, ObjetoJaExisteException {
		if (nome.isEmpty()) {
			throw new StringVaziaException("O nome está vazio!");
		} else {
			Funcoes.verificarString(nome, "O nome só aceita letras!");
		}
		if (tecnico == null) {
			throw new ObjetoNaoExisteException("Tecnico não existe!");
		} else if (TecnicoDAO.existeTecnico(new Tecnico(nome, null))) {
			throw new ObjetoJaExisteException("O Tecnico já existe na lista!");
		}
		tecnico.setNome(nome);
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
	
	static public void excluir(Tecnico tecnico) throws ObjetoNaoExisteException {
		if (!tecnicos.remove(tecnico)) {
			throw new ObjetoNaoExisteException("O tecnico não existe na lista!");
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
			if (tecnico.getNome().toLowerCase().contains(nome.toLowerCase())) {
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
	
	public static List<String> tecnicosExistentes(){
		List<String> lista = new ArrayList<>();
		for (Tecnico tecnico: tecnicos) {
			lista.add(tecnico.getNome());
		}
		return lista;
	}
	
}
