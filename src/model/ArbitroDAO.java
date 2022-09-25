package model;

import java.util.ArrayList;
import java.util.List;

public class ArbitroDAO {
	int a = 0;
	static private List<Arbitro> arbitros = new ArrayList<>();
	static private int tamanhoLista = 0;
	static boolean inserir(Arbitro arbitro) {
		arbitros.add(arbitro);
		tamanhoLista++;
		return true;
	}
	static boolean editar(Arbitro arbitro, String nome) {
		if (arbitro.getNome() == nome) {
			return false;
		}else {
			arbitro.setNome(nome);
			return true;
		}
	}
	static boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			arbitros.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
	}
	static void listar() {
		System.out.println("ARBITROS:");
		for (Arbitro arbitro: arbitros) {
			System.out.println(arbitro);	
		}
	}
	
	static Arbitro getOneArbitro(int num) {
		return arbitros.get(num);
	}
}
