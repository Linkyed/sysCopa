package application;

import model.Arbitro;
import model.ArbitroDAO;
import model.Funcoes;

public class MainArbitro {

	public static void inserirArbitro() {
		String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do arbitro que será inserido: ", true));
		Arbitro arbitro = new Arbitro(nome);
		if (!ArbitroDAO.inserir(arbitro)) {
			System.out.println("\nArbitro inserido com sucesso!\n");
		} else {
			System.out.println("\nO arbitro " + nome + " já esta presente na lista!");
		}
	}
	
}
