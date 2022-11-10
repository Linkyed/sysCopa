package application;

import model.ArbitroDAO;
import model.Funcoes;
import model.JogadorDAO;
import model.Pesquisa;
import model.Selecao;
import model.SelecaoDAO;
import model.TecnicoDAO;

public class Menu {

	public static void escolhaPrincipal() {
		System.out.println("Bem vindo ao SysCopa, agora será necesario que todas as seleções," +
	"tecnicos, jogadores e arbitros\nsejam adicionados antes das simulações das partidas acontecerem!\n");
		
		int escolha = 0;
		
		while (SelecaoDAO.quantidadeSelecoes() < 32) {
			criarSelecaoCompleta();
			
			while (escolha != 2) {
				escolha = Funcoes.entradaIntRanger("[1] Editar uma Seleção, Tecnico ou Jogador\n"
						+ "[2] Excluir uma Seleção\n"
						+ "[3] Continuar o procedimento de inserir seleções completas\n"
						+ "Digite o numero relacionado a uma opção acima: ", 1, 3);
				if (escolha == 1) {
					edicaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n", 1, 3);
				} else if (escolha == 2) {
					MainSelecao.excluirSelecao();
				} else if (escolha == 3 && (32 - SelecaoDAO.quantidadeSelecoes()) > 0){
					System.out.println("\nFalta " + (32 - SelecaoDAO.quantidadeSelecoes()) + " serem criadas "
							+ "para dar inicio as simulações das partidas!\n");
				} else if (escolha == 3 && (32 - SelecaoDAO.quantidadeSelecoes()) == 0){
					System.out.println("\nTodas seleções foram inseridas! Agora as simulações poderão ser realizadas!\n");
				}
			}
		}
		
		escolha = Funcoes.entradaIntRanger("[1] Inserir um(a) nova(o) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[2] Editar um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[3] Excluir um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[4] Listar as(os) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[5] Fazer pesquisa por nome\n" +
				"Digite o numero relacionado a uma das opções acima: ", 1, 5);
	
		System.out.println();
		
		if (escolha == 1) {
			insercaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
		} else if (escolha == 2){
			edicaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
		} else if (escolha == 3) {
			exclusaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
		} else if (escolha == 4){
			mostrarObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
		} else if (escolha == 5){
			sistemaDePesquisa();
		}
		
	}
	
	private static void criarSelecaoCompleta() {
		Selecao selecao = MainSelecao.inserirSelecao();
		MainTecnico.inserirTecnico(selecao);
		while (selecao.getJogadores().size() < 11){
			MainJogador.inserirJogador(selecao);	
			if (selecao.getJogadores().size() == 11) {
				System.out.println("\nA seleção foi completada com sucesso!\n");
			} else {
				System.out.println("\nFalta "+(11-selecao.getJogadores().size()+" serem adicionados!\n"));				
			}
		}
	}
	
	
	private static int escolhaDoObjeto(String texto, int menorEscolha, int maiorEscolha) {
		System.out.println(texto);
		return Funcoes.entradaIntRanger("Escolha um numero relacionado as opções acima: ", menorEscolha, maiorEscolha);
	}
	
	private static void insercaoObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int inserir = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
		if (inserir == 1) {
			MainSelecao.inserirSelecao();
		} else if (inserir == 2) {
			MainTecnico.inserirTecnico();
		} else if (inserir == 3) {
			MainJogador.inserirJogador();
		} else {
			MainArbitro.inserirArbitro();
		}
	}
	
	private static void edicaoObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int editar = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
		if (editar == 1) {
			MainSelecao.editarSelecao();
		} else if (editar == 2) {
			MainTecnico.editarTecnico();
		} else if (editar == 3) {
			MainJogador.editarJogador();
		} else {
			MainArbitro.editarArbitro();
		}
	}
	
	private static int exclusaoObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int excluir = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
		if (excluir == 1) {
			MainSelecao.excluirSelecao();
		} else if (excluir == 2) {
			MainTecnico.excluirTecnico();
		} else if (excluir == 3) {
			MainJogador.excluirJogador();
		} else {
			MainArbitro.excluirArbitro();
		}
		return excluir;
	}
	
	private static void mostrarObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int listar = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
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
