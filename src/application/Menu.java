package application;

import model.ArbitroDAO;
import model.Funcoes;
import model.JogadorDAO;
import model.Pesquisa;
import model.Selecao;
import model.SelecaoDAO;
import model.TecnicoDAO;
import model.GrupoPrimeiraFase;

public class Menu {

	/** Menu principal onde o usuario terá que inserir seleções, jogadores, tecnios e arbitros e poderá exlcuir, editar, listar
	 * e pesquisar pelos mesmos durante o funcionamente, até que seja escolhido partir para a simulação de partidas **/
	public static void MenuPrincipal() {
		System.out.println("Bem vindo ao SysCopa, agora será necesario que todas as seleções,"
				+ "tecnicos, jogadores e arbitros\nsejam adicionados antes das simulações das partidas acontecerem!\n");

		int escolha = 0;

		int quantSelecoes = 32;
		/** Loop da criação de todas as 32 seleções, criando juntamente o tecnico e os jogadores, e apos a criação
		 * de uma seleção o usuario podera editar um dos objetos ou então exlcuir uma seleção**/
		while (SelecaoDAO.quantidadeSelecoes() < quantSelecoes) {
			criarSelecaoCompleta();

			while (escolha != 3) {
				escolha = Funcoes.entradaIntRanger("[1] Editar uma Seleção, Tecnico ou Jogador\n"
						+ "[2] Excluir uma Seleção\n" + "[3] Continuar o procedimento de inserir seleções completas\n"
						+ "Digite o numero relacionado a uma opção acima: ", 1, 3);
				if (escolha == 1) {
					edicaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n", 1, 3);
				} else if (escolha == 2) {
					MainSelecao.excluirSelecao();
				} else if (escolha == 3 && (quantSelecoes - SelecaoDAO.quantidadeSelecoes()) > 0) {
					System.out.println("\nFalta " + (quantSelecoes - SelecaoDAO.quantidadeSelecoes()) + " serem criadas "
							+ "para dar inicio as simulações das partidas!\n");
				} else if (escolha == 3 && (quantSelecoes - SelecaoDAO.quantidadeSelecoes()) == 0) {
					System.out
							.println("\nTodas seleções foram inseridas! Agora as simulações poderão ser realizadas!\n");
				}

			}
			escolha = 0;
		}
		/** Parte onde o usuario ira pre definir quantos arbitros farão parte da copa e ira criar a quantidade
		 * que ele escolheu **/
		int quantArbitros = Funcoes.entradaIntRanger("(Só sera aceitos numeros maiores que 1) Digite quantos arbitros deseja inserir: ", 1);
		for (int i = 0; i < quantArbitros; i++) {
			MainArbitro.inserirArbitro();
		}
		
		/** Loop onde o usuario podera ficar editando, excluindo e listando jogadores, seleções, arbitros e tecnicos
		 * até ele ir para a parte de simulação de partida **/
		while (escolha != 5) {
			escolha = Funcoes.entradaIntRanger("[1] Editar um(a) Seleção, Tecnico, Jogador ou Arbitro\n"
					+ "[2] Excluir um(a) Seleção, Tecnico, Jogador ou Arbitro\n"
					+ "[3] Listar as(os) Seleção, Tecnico, Jogador ou Arbitro\n" + "[4] Fazer pesquisa por nome\n"
					+ "[5] Simular Partidas"
					+ "Digite o numero relacionado a uma das opções acima: ", 1, 5);
			
			System.out.println();
			
			if (escolha == 1) {
				edicaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
			} else if (escolha == 2) {
				exclusaoObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
			} else if (escolha == 3) {
				mostrarObjetos("[1] Selecao\n[2] Tecnico\n[3] Jogador\n[4] Arbitro", 1, 4);
			} else if (escolha == 4) {
				sistemaDePesquisa();
			}
		}
	}

	/** Metodo para criar uma seleção inteira, com tecnico, e todos os jogadores de forma sequencial e escolhendo de que
	 * grupo ela faz parte**/
	private static void criarSelecaoCompleta() {
		Selecao selecao = MainSelecao.inserirSelecao();
		MainTecnico.inserirTecnico(selecao);
		int tamanhoTime = 11;

		while (selecao.getJogadores().size() < tamanhoTime) {
			MainJogador.inserirJogador(selecao);
			if (selecao.getJogadores().size() == tamanhoTime) {
				System.out.println("\nA seleção foi completada com sucesso!\n");
			} else {
				System.out
						.println("\nFalta " + (tamanhoTime - selecao.getJogadores().size() + " serem adicionados!\n"));
			}
		}

		String letraGrupo = Funcoes.entradaLetraGrupo("Digite a Letra do grupo que a seleção pertence [A-H]: ", true);
		while (GrupoPrimeiraFase.quantidadeGupo(letraGrupo) == 4) {
			System.out.println("Erro! O grupo selecionado está cheio!");
			System.out.println("Grupo A: " + GrupoPrimeiraFase.quantidadeGupo("A") + " |Grupo B: "
					+ GrupoPrimeiraFase.quantidadeGupo("B") + " |Grupo C: " + GrupoPrimeiraFase.quantidadeGupo("C")
					+ " |Grupo D: " + GrupoPrimeiraFase.quantidadeGupo("D") + " |Grupo E: "
					+ GrupoPrimeiraFase.quantidadeGupo("E") + " |Grupo F: " + GrupoPrimeiraFase.quantidadeGupo("F")
					+ " |Grupo G: " + GrupoPrimeiraFase.quantidadeGupo("G") + " |Grupo H: "
					+ GrupoPrimeiraFase.quantidadeGupo("H"));
			letraGrupo = Funcoes.entradaLetraGrupo("Digite a Letra do grupo que a seleção pertence [A-H]: ", true);
		}
		GrupoPrimeiraFase.adicionarSelecao(letraGrupo, selecao);
	}
	
	/** Metodo para criar uma seleção completa, com tecnico e jogadores de forma sequencial porem com um grupo já pre
	 * definido **/
	private static void criarSelecaoCompleta(String letra) {
		Selecao selecao = MainSelecao.inserirSelecao();
		MainTecnico.inserirTecnico(selecao);
		int tamanhoTime = 11;

		while (selecao.getJogadores().size() < tamanhoTime) {
			MainJogador.inserirJogador(selecao);
			if (selecao.getJogadores().size() == tamanhoTime) {
				System.out.println("\nA seleção foi completada com sucesso!\n");
			} else {
				System.out
						.println("\nFalta " + (tamanhoTime - selecao.getJogadores().size() + " serem adicionados!\n"));
			}
		}
		GrupoPrimeiraFase.adicionarSelecao(letra, selecao);
	}

	/** Metodo para o usuario escolher que tipo de objeto ele ira escolher para realizar uma determinada ação **/
	private static int escolhaDoObjeto(String texto, int menorEscolha, int maiorEscolha) {
		System.out.println(texto);
		return Funcoes.entradaIntRanger("Escolha um numero relacionado as opções acima: ", menorEscolha, maiorEscolha);
	}
	
	/** Metodo para um usuario inserir um jogador, tecnico, arbitro ou seleção **/
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

	/** Metodo para um usuario editar um jogador, tecnico, arbitro ou seleção **/
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

	/** Metodo para um usuario excluir um jogador, tecnico, arbitro ou seleção **/
	private static int exclusaoObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int excluir = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
		if (excluir == 1) {
			String letra = MainSelecao.excluirSelecao();
			if (letra != "0") {
				criarSelecaoCompleta(letra);				
			}
		} else if (excluir == 2) {
			Selecao selecao = MainTecnico.excluirTecnico();
			if (selecao != null) {
				MainTecnico.inserirTecnico(selecao);
			}
		} else if (excluir == 3) {
			Selecao selecao = MainJogador.excluirJogador();
			if (selecao != null) {
				MainJogador.inserirJogador(selecao);
			}
		} else {
			MainArbitro.excluirArbitro();
			MainArbitro.inserirArbitro();
		}
		return excluir;
	}

	/** Metodo para um usuario listar um jogador, tecnico, arbitro ou seleção **/
	private static void mostrarObjetos(String texto, int menorEscolha, int maiorEscolha) {
		int listar = escolhaDoObjeto(texto, menorEscolha, maiorEscolha);
		if (listar == 1) {
			SelecaoDAO.listar();
			;
		} else if (listar == 2) {
			TecnicoDAO.listar();
			;
		} else if (listar == 3) {
			JogadorDAO.listar();
		} else {
			ArbitroDAO.listar();
			;
		}
	}

	/** Metodo para um usuario pesquisar por um jogador, tecnico, arbitro ou seleção **/
	private static void sistemaDePesquisa() {
		int escolha = Funcoes.entradaIntRanger(
				"[1] Pesquisar por uma seleção\n[2] Pesquisar por uma pessoa\nDigite o numero relacionado uma forma de pesquisa: ",
				1, 2);
		if (escolha == 1) {
			System.out.println(Pesquisa.buscarSelecao());
		} else if (escolha == 2) {
			System.out.println(Pesquisa.buscarPessoa());
		}
	}

}