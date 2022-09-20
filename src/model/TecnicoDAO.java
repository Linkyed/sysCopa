package model;

import java.util.List;

public class TecnicoDAO {
	BancoDeDados dados = new BancoDeDados();
	private List<Tecnico> tecnicos = dados.getTecnicos();
	private int tamanhoLista = 0;
	
	boolean inserir(Tecnico tecnico) {
		if (tamanhoLista < 32){
			tecnicos.add(tecnico);
			tamanhoLista++;
			return true;
		}else {
			return false;
		}
	}
	boolean editar(Tecnico tecnico, String nome) {

		if (tecnico.getNome() == nome) {
			return false;
		}else {
			tecnico.setNome(nome);
			return true;
		}
	}
	boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			tecnicos.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
		
	}
	void listar() {
		System.out.println("TECNICOS:");
		for (Tecnico tecnico: tecnicos) {
			System.out.println(tecnico);	
		}
	}
	
	Tecnico getOneTecnico(int num) {
		return tecnicos.get(num);
	}

}
