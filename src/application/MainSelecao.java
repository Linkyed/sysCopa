package application;

import model.ArbitroDAO;
import model.Funcoes;
import model.Selecao;
import model.SelecaoDAO;

public class MainSelecao {

	public static Selecao inserirSelecao() {
		String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome da seleção que será inserida: ", true));
		Selecao selecao = new Selecao(nome);
		if (SelecaoDAO.inserir(selecao)) {
			System.out.println("\nSeleção foi inserida com sucesso!\n");
		} else {
			System.out.println("\nA seleção não pode ser inserida, a lista de seleções está cheia ou esse seleção já existe na lista!\n");
		}
		return selecao;
	}	
	
	public static void editarSelecao() {
		SelecaoDAO.listar();
		if (SelecaoDAO.quantidadeSelecoes() > 0) {			
			int escolhaSelecao = Funcoes.entradaIntRanger("Digite o numero correspondete a uma seleção para ser editada: ", 0, SelecaoDAO.quantidadeSelecoes()-1);
			if (SelecaoDAO.editar(SelecaoDAO.getOneSelecao(escolhaSelecao), Funcoes.entradaString("Digite o novo nome da seleção: ", true))) {
				System.out.println("\nNome da seleção foi editado com sucesso!\n");
			} else {
				System.out.println("\nO nome da seleção não pode ser editado, o novo nome já pode existir em outra seleção ou nada foi digitado!\n");
			}
		} else {
			System.out.println("\nNão existe nenhuma seleção para ser editada!\n");
		}
	}
	
	public static void excluirSelecao() {
		SelecaoDAO.listar();
		if (SelecaoDAO.quantidadeSelecoes() > 0) {
			int escolhaSelecao = Funcoes.entradaIntRanger("Digite o numero correspondete a uma seleção para ser excluido: ", 0, SelecaoDAO.quantidadeSelecoes()-1);
			if (SelecaoDAO.excluir(escolhaSelecao)) {
				System.out.println("\nSeleção foi excluida com sucesso!\n");
			} else {
				System.out.println("\nA seleção não pode ser excluida, tente novamente!\n");
			}			
		} else {
			System.out.println("\nNão existe nenhuma seleção para ser excluida!\n");
		}
	}
	
	
}
