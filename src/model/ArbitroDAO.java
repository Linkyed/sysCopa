package model;

import java.util.List;

public class ArbitroDAO {
	BancoDeDados dados = new BancoDeDados();
	private List<Arbitro> arbitros = dados.getArbitros();
	private int tamanhoLista = 0;
	boolean inserir(Arbitro arbitro) {
		arbitros.add(arbitro);
		tamanhoLista++;
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
	boolean excluir(int num) {
		if (num <= tamanhoLista && num >= 0) {
			arbitros.remove(num);
			tamanhoLista--;
			return true;
		} else {
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
