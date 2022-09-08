package model;


import java.util.ArrayList;

public class TecnicoDAO {
	private ArrayList<Tecnico> tecnicos = new ArrayList<>();
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
	boolean excluir(Tecnico tecnico) {
		if (tecnicos.contains(tecnico) == true){
			tecnicos.remove(tecnico);
			tamanhoLista--;
			return true;
		}else {
			return false;
		}
		
	}
	void listar() {
		int contador = 1;
		System.out.println("TECNICOS:");
		for (Tecnico tecnico: tecnicos) {
			System.out.println(tecnico);	
		}
	}
	
	Tecnico getOneTecnico(int num) {
		return tecnicos.get(num);
	}

	void pedroLixo(){
		System.out.print("Lixo");
	}
	
}
