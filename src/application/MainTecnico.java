package application;

import model.Arbitro;
import model.Funcoes;
import model.Selecao;
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
	
	public static void inserirTecnico(Selecao selecao) {
		if (SelecaoDAO.selecoesSemTecnico() > 0) {
			while (true) {
				String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do tecnico que será inserido: ", true));
				Tecnico tecnico = new Tecnico(nome, selecao);
				if (TecnicoDAO.inserir(tecnico)) {
					System.out.println("\nTecnico inserido com sucesso!\n");
					break;
				}				
			}
		} else {
			System.out.println("\nUm tecnico ainda não pode ser inserido pois ou não existem seleções ou não existe vagas para tecnicos disponiveis!\n");
		}
	}
	
	public static void editarTecnico() {
		TecnicoDAO.listar();
		if (TecnicoDAO.quantidadeTecnicos() > 0) {
			int escolhaTecnico = Funcoes.entradaIntRanger("Digite o numero relacionado a um tecnico para ser editado: ", 0, TecnicoDAO.quantidadeTecnicos()-1);
			String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do tecnico que será inserido: ", true));
			if (TecnicoDAO.editar(TecnicoDAO.getOneTecnico(escolhaTecnico), nome)) {
				System.out.println("\nNome do tecnico editado com sucesso!\n");
			} else {
				System.out.println("\nNome não editado, ou o tecnico já possui o nome igual ao novo ou nada foi digitado!\n");
			}
		} else {
			System.out.println("\nNão existe nenhum tecnico para ser editado!\n");
		}
	}
	
	public static Selecao excluirTecnico() {
		TecnicoDAO.listar();
		Selecao selecao = null;
		if (TecnicoDAO.quantidadeTecnicos() > 0) {
			int escolhaTecnico = Funcoes.entradaIntRanger("Digite o numero relacionado a um tecnico para ser excluido: ", 0, TecnicoDAO.quantidadeTecnicos()-1);
			selecao = TecnicoDAO.getOneTecnico(escolhaTecnico).getSelecao();
			boolean exclusao = TecnicoDAO.excluir(escolhaTecnico);
			while (exclusao == false) {
				System.out.println("\nTecnico não pode ser excluido, tente novamente!\n");		
				escolhaTecnico = Funcoes.entradaIntRanger("Digite o numero relacionado a um tecnico para ser excluido: ", 0, TecnicoDAO.quantidadeTecnicos()-1);
				selecao = TecnicoDAO.getOneTecnico(escolhaTecnico).getSelecao();
				exclusao = TecnicoDAO.excluir(escolhaTecnico);
			} 
			System.out.println("\nTecnico excluido com sucesso!\n");
		} else {
			System.out.println("\nNão existe nenhum tecnico para ser excluido!\n");
		}
		return selecao;
	}
	
}
