package application;

import model.Arbitro;
import model.ArbitroDAO;
import model.Funcoes;

public class MainArbitro {

	/** Metodo para criar e inserir um arbitro **/
	public static void inserirArbitro() {
		String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do arbitro que será inserido: ", true));
		Arbitro arbitro = new Arbitro(nome);
		while (true) {
			if (ArbitroDAO.inserir(arbitro)) {
				System.out.println("\nArbitro inserido com sucesso!\n");
				break;
			} else {
				System.out.println("\nO arbitro já esta presente na lista!");
			}			
		}
	}
	
	/** Metodo para editar o nome de um arbitro **/
	public static void editarArbitro() {
		ArbitroDAO.listar();
		if (ArbitroDAO.quantidadeArbitro() > 0) {
			while (true) {
				int escolhaArbitro = Funcoes.entradaIntRanger("Digite o numero correspondete a um arbitro para ser editado: ", 0, ArbitroDAO.quantidadeArbitro()-1);
				String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do arbitro que será inserido: ", true));
				if (ArbitroDAO.editar(ArbitroDAO.getOneArbitro(escolhaArbitro), nome)) {
					System.out.println("\nArbitro editado com sucesso!\n");
					break;
				} else {
					System.out.println("\nO arbitro não foi editado, verifica que o novo nome é diferente do antigo ou se ele não existe na lista!\n");
				}							
			}
		} else {
			System.out.println("\nNão existe nenhum arbitro para ser editado!\n");
		}
	}
	
	/** Metodo para excluir um arbitro **/
	public static void excluirArbitro() {
		ArbitroDAO.listar();
		if (ArbitroDAO.quantidadeArbitro() > 0) {
			int escolhaArbitro = Funcoes.entradaIntRanger("Digite o numero correspondete a um arbitro para ser excluido: ", 0, ArbitroDAO.quantidadeArbitro()-1);
			if (ArbitroDAO.excluir(escolhaArbitro)) {
				System.out.println("\nO arbitro foi excluido com sucesso!\n");
			} else {
				System.out.println("\nO arbitro não pode ser exlcuido, tente novamente!\n");
			}			
		} else {
			System.out.println("\nNão existe nenhum arbitro para ser excluido!\n");
		}
	}
}
