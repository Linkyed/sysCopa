package model;

import java.util.ArrayList;
import java.util.List;

public class TecnicoDAO {

	static private List<Tecnico> tecnicos = new ArrayList<>();
	static private int tamanhoLista = 0;
	
	static boolean inserir(Tecnico tecnico) {
		if (tamanhoLista < 32){
			tecnicos.add(tecnico);
			tamanhoLista++;
			return true;
		}else {
			return false;
		}
	}
	static boolean editar(Tecnico tecnico, String nome) {

		if (tecnico.getNome() == nome) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
	static boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			tecnicos.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
		 
	}
	static void listar() {
		System.out.println("TECNICOS:");
		for (Tecnico tecnico: tecnicos) {
			System.out.println(tecnico);	
		}
	}
	
	static Tecnico getOneTecnico(int num) {
		return tecnicos.get(num);
	}

}
