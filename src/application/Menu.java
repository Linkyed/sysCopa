package application;

import model.ArbitroDAO;
import model.Funcoes;
import model.JogadorDAO;
import model.Pesquisa;
import model.SelecaoDAO;
import model.TecnicoDAO;

public class Menu {

	public static void escolhaPrincipal() {
		int escolha = Funcoes.entradaIntRanger("[1] Inserir um(a) nova(o) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[2] Editar um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[3] Excluir um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[4] Listar as(os) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[5] Fazer pesquisa por nome\n" +
				"Digite o numero relacionado a uma das opções acima: ", 1, 5);
	
		System.out.println();
		
		if (escolha == 1) {
			insercaoObjetos();
		} else if (escolha == 2){
			edicaoObjetos();
		} else if (escolha == 3) {
			exclusaoObjetos();
		} else if (escolha == 4){
			mostrarObjetos();
		} else if (escolha == 5){
			sistemaDePesquisa();
		}
		
	}
	
	private static int escolhaDoObjeto() {
		System.out.println("\n[1] Seleção\n[2] Tecnico\n[3] Jogador\n[4] Arbitro\n");
		return Funcoes.entradaIntRanger("Escolha um numero relacionado as opções acima: ", 1, 4);
	}
	
	private static void insercaoObjetos() {
		int inserir = escolhaDoObjeto();
		if (inserir == 1) {
			MainSelecao.inserirSelecao();
		} else if (inserir == 2) {
			MainTecnico.inserirTecnico();
		} else if (inserir == 3) {
			System.out.println();
		} else {
			MainArbitro.inserirArbitro();
		}
	}
	
	private static void edicaoObjetos() {
		int editar = escolhaDoObjeto();
		if (editar == 1) {
			MainSelecao.editarSelecao();
		} else if (editar == 2) {
			MainTecnico.editarTecnico();
		} else if (editar == 3) {
			System.out.println();
		} else {
			MainArbitro.editarArbitro();
		}
	}
	
	private static void exclusaoObjetos() {
		int excluir = escolhaDoObjeto();
		if (excluir == 1) {
			MainSelecao.excluirSelecao();
		} else if (excluir == 2) {
			MainTecnico.excluirTecnico();
		} else if (excluir == 3) {
			System.out.println();
		} else {
			MainArbitro.excluirArbitro();
		}
	}
	
	private static void mostrarObjetos() {
		int listar = escolhaDoObjeto();
		if (listar == 1) {
			SelecaoDAO.listar();;
		} else if (listar == 2) {
			TecnicoDAO.listar();;
		} else if (listar == 3) {
			JogadorDAO.listar();
		} else {
			ArbitroDAO.listar();;
		}
	}
	
	private static void sistemaDePesquisa() {
		int escolha = Funcoes.entradaIntRanger("[1] Pesquisar por uma seleção\n[2] Pesquisar por uma pessoa\nDigite o numero relacionado uma forma de pesquisa: ", 1, 2);
		if (escolha == 1) {
			System.out.println(Pesquisa.buscarSelecao());
		} else if (escolha == 2) {
			System.out.println(Pesquisa.buscarPessoa());
		}
	}
	
}
