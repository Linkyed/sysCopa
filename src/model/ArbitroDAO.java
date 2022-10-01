package model;

import java.util.ArrayList;
import java.util.List;

public class ArbitroDAO implements ArbitroDAOInterface{
	int a = 0;
	static private List<Arbitro> arbitros = new ArrayList<>();
	static private int tamanhoLista = 0;
	static public boolean inserir(Arbitro arbitro) {
		arbitros.add(arbitro);
		tamanhoLista++;
		return true;
	}
	static public boolean editar(Arbitro arbitro, String nome) {
		if (arbitro.getNome().equals(nome)) {
			return false;
		}else {
			arbitro.setNome(nome);
			return true;
		}
	}
	static public boolean excluir(int num) {
		if (num <= tamanhoLista-1 && num >= 0) {
			arbitros.remove(num);
			tamanhoLista--;
			return true;
		} else {
			return false;
		}
	}
	static public void listar() {
		System.out.println("\nARBITROS:");
		int contador = 0;
		for (Arbitro arbitro: arbitros) {
			System.out.println("[" + contador + "] " + arbitro);	
			contador++;
		}
		System.out.println();
	}
	
	static public Arbitro getOneArbitro(int num) {
		if (num > tamanhoLista-1 || num < 0) {
			return null;
		}else {
			System.out.println("\nO numero esta fora da lista!\n");
			return arbitros.get(num);			
		}
	}
	static public int contarArbitro() {
		return arbitros.size();
	}
}
