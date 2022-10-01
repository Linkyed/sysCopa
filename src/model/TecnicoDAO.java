package model;

import java.util.ArrayList;
import java.util.List;

public class TecnicoDAO {
	int a = 0;
	static private List<Tecnico> tecnicos = new ArrayList<>();
	static private int tamanhoLista = 0;
	
	static public boolean inserir(Tecnico tecnico) {
		if (tamanhoLista < 32){
			tecnicos.add(tecnico);
			tamanhoLista++;
			return true;
		}else {
			return false;
		}
	}
	static public boolean editar(Tecnico tecnico, String nome) {

		if (tecnico.getNome() == nome || nome.isEmpty() == true || nome == null) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
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
	static public void listar() {
		System.out.println("\nTECNICOS:");
		int contador = 0;
		for (Tecnico tecnico: tecnicos) {
			System.out.println("["+ contador +"]" + tecnico);	
		}
		System.out.println();
	}
	
	static public Tecnico getOneTecnico(int num) {
		if (num > tamanhoLista-1 || num < 0) {
			System.out.println("\nO numero esta fora da lista!\n");
			return null;
		} else {
			return tecnicos.get(num);
		}
	
	}
	
	static public Tecnico getTecnicoIndes(Tecnico tecnico) {
		return tecnicos.get(tecnicos.indexOf(tecnico));
	}
	
	static public int contarTecnicos() {
		return tecnicos.size();
	}

}
