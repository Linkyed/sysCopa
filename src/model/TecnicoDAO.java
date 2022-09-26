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

		if (tecnico.getNome() == nome) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
	static public boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			tecnicos.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
		 
	}
	static public void listar() {
		System.out.println("TECNICOS:");
		for (Tecnico tecnico: tecnicos) {
			System.out.println(tecnico);	
		}
	}
	
	static public Tecnico getOneTecnico(int num) {
		return tecnicos.get(num);
	}
	
	static public Tecnico getTecnicoIndes(Tecnico tecnico) {
		return tecnicos.get(tecnicos.indexOf(tecnico));
	}

}
