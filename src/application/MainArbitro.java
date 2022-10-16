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
	
	public static void editarArbitro() {
		ArbitroDAO.listar();
		int escolhaArbitro = Funcoes.entradaIntRanger("Digite o numero correspondete a um arbitro para ser editado: ", 0, ArbitroDAO.contarArbitro()-1);
		String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do arbitro que será inserido: ", true));
		if (ArbitroDAO.editar(ArbitroDAO.getOneArbitro(escolhaArbitro), nome)) {
			System.out.println("\nArbitro editado com sucesso!\n");
		} else {
			System.out.println("\nO arbitro não foi editado, verifica que o novo nome é diferente do antigo ou se ele não existe na lista!\n");
		}
	}
}
