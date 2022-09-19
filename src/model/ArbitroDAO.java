package model;

import java.util.ArrayList;

public class ArbitroDAO {
	private ArrayList<Arbitro> arbitros = new ArrayList<>();
	
	boolean inserir(Arbitro arbitro) {
		arbitros.add(arbitro);
		return true;
	}
	boolean editar(Arbitro arbitro, String nome) {
		if (arbitro.getNome() == nome) {
			return false;
		}else {
			arbitro.setNome(nome);
			return true;
		}
	}
	boolean excluir(Arbitro arbitro) {
		if (arbitros.contains(arbitro) == true){
			arbitros.remove(arbitro);
			return true;
		}else {
			return false;
		}
	}
	void listar() {
		System.out.println("ARBITROS:");
		for (Arbitro arbitro: arbitros) {
			System.out.println(arbitro);	
		}
	}
	
	Arbitro getOneArbitro(int num) {
		return arbitros.get(num);
	}
}
