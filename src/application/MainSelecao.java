package application;


import model.Funcoes;
import model.GrupoPrimeiraFase;
import model.Selecao;
import model.SelecaoDAO;

public class MainSelecao {
	
	/** Metodo para inserir uma seleção **/
	public static Selecao inserirSelecao() {
		while (true) {
			String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome da seleção que será inserida: ", true));
			Selecao selecao = new Selecao(nome);
			if (SelecaoDAO.inserir(selecao)) {
				System.out.println("\nSeleção foi inserida com sucesso!\n");
				return selecao;
			} else {
				System.out.println("\nA seleção não pode ser inserida! Essa seleção já existe na lista!\n");
			}
		}
	}	
	
	/** Metodo para editar uma seleção **/
	public static void editarSelecao() {
		SelecaoDAO.listar();
		if (SelecaoDAO.quantidadeSelecoes() > 0) {			
			while (true) {
				int escolhaSelecao = Funcoes.entradaIntRanger("Digite o numero correspondete a uma seleção para ser editada: ", 0, SelecaoDAO.quantidadeSelecoes()-1);
				if (SelecaoDAO.editar(SelecaoDAO.getOneSelecao(escolhaSelecao), Funcoes.entradaString("Digite o novo nome da seleção: ", true))) {
					System.out.println("\nNome da seleção foi editado com sucesso!\n");
					break;
				} else {
					System.out.println("\nO nome da seleção não pode ser editado! O novo nome já pode existir em outra seleção ou nada foi digitado!\n");
				}
			}
		} else {
			System.out.println("\nNão existe nenhuma seleção para ser editada!\n");
		}
	}
	
	/** Metodo para excluir uma seleção **/
	public static String excluirSelecao() {
		SelecaoDAO.listar();
		String letra = "";
		if (SelecaoDAO.quantidadeSelecoes() > 0) {
			int escolhaSelecao = Funcoes.entradaIntRanger("Digite o numero correspondete a uma seleção para ser excluido: ", 0, SelecaoDAO.quantidadeSelecoes()-1);
			letra = GrupoPrimeiraFase.grupoSelecao(SelecaoDAO.getOneSelecao(escolhaSelecao));
			if (SelecaoDAO.excluir(escolhaSelecao)) {
				System.out.println("\nSeleção foi excluida com sucesso!\n");
			} else {
				System.out.println("\nA seleção não pode ser excluida, tente novamente!\n");
			}			
		} else {
			System.out.println("\nNão existe nenhuma seleção para ser excluida!\n");
		}
		return letra;
	}
	
	
}
