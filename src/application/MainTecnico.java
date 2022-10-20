package application;

import model.Arbitro;
import model.Funcoes;
import model.SelecaoDAO;
import model.Tecnico;
import model.TecnicoDAO;

public class MainTecnico {

	public static void inserirTecnico() {
		if (SelecaoDAO.selecoesSemTecnico() > 0) {
			System.out.println("As seguintes seleções ainda não possuem tecnicos:");
			SelecaoDAO.imprimirSelecaoSemTecnico();
			int escolhaSelecao = Funcoes.entradaInt("Digite o numero relacionado a uma das seleções onde o tecnico será inserido: ");
			while (SelecaoDAO.getOneSelecao(escolhaSelecao).getTecnico() != null) {
				SelecaoDAO.imprimirSelecaoSemTecnico();
				escolhaSelecao = Funcoes.entradaInt("Por favor digite apenas um dos numeros relacionado a uma das seleções onde o tecnico será inserido: ");
			}
			String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do tecnico que será inserido: ", true));
			Tecnico tecnico = new Tecnico(nome, SelecaoDAO.getOneSelecao(escolhaSelecao));
			TecnicoDAO.inserir(tecnico);
			System.out.println("\nTecnico inserido com sucesso!\n");
		} else {
			System.out.println("\nUm tecnico ainda não pode ser inserido pois ou não existem seleções ou não existe vagas para tecnicos disponiveis!\n");
		}
	}
	
	public static void editarTecnico() {
		TecnicoDAO.listar();
		int escolhaTecnico = Funcoes.entradaIntRanger("Digite o numero relacionado a um tecnico para ser editado: ", 0, TecnicoDAO.contarTecnicos()-1);
		int escolhaEdicao = Funcoes.entradaIntRanger("[1] Editar nome\n[2] Editar a seleção\nAgora digite o numero do que deseja editar: ", 1, 2);
		if (escolhaEdicao == 1) {
			String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do tecnico que será inserido: ", true));
			if (TecnicoDAO.editar(TecnicoDAO.getOneTecnico(escolhaTecnico), nome)) {
				System.out.println("\nNome do tecnico editado com sucesso!\n");
			} else {
				System.out.println("\nNome não editado, ou o tecnico já possui o nome igual ao novo ou nada foi digitado!\n");
			}
		} else {
			SelecaoDAO.imprimirSelecaoSemTecnico();
			int escolhaSelecao = Funcoes.entradaInt("\nDigite o numero de uma seleção que ainda não possui o tecnico para receber o tecnico atual: ");
			while (SelecaoDAO.getOneSelecao(escolhaSelecao).getTecnico() != null) {
				SelecaoDAO.imprimirSelecaoSemTecnico();
				escolhaSelecao = Funcoes.entradaInt("\nPor favor, digite apenas um dos numeros de uma seleção que ainda não possui o tecnico para receber o tecnico atual: ");
			}
			if (TecnicoDAO.editar(TecnicoDAO.getOneTecnico(escolhaTecnico), SelecaoDAO.getOneSelecao(escolhaSelecao))) {
				System.out.println("Seleção do tecnico editada com sucesso!\n");
			} else {
				System.out.println("\nA seleção escolhida já possui um tecnico, tente outra que ainda não possua um tecnico!\n");
			}
		}
	}
	
	public static void excluirTecnico() {
		TecnicoDAO.listar();
		int escolhaTecnico = Funcoes.entradaIntRanger("Digite o numero relacionado a um tecnico para ser excluido: ", 0, TecnicoDAO.contarTecnicos()-1);
		if (TecnicoDAO.excluir(escolhaTecnico)) {
			System.out.println("\nTecnico excluido com sucesso!\n");
		} else {
			System.out.println("\nTecnico não pode ser excluido, tente novamente!\n");
		}
	}
	
}
