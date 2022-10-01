package application;

//import javafx.application.Application;
//import javafx.stage.Stage;
import model.*;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;

public class Main {
	/*
	 * public void start(Stage primaryStage) { try { BorderPane root = new
	 * BorderPane(); Scene scene = new Scene(root,400,400);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); }
	 * catch(Exception e) { e.printStackTrace(); } }
	 */

	public static void main(String[] args) {
		// Variaveis para desiginar a escolha do usuario perante as ações que o progama
		// pode fazer
		int escolha = 0;
		int escolha_inserir = 0;
		int escolha_excluir = 0;
		int escolha_editar = 0;
		int escolha_listar = 0;

		// Loop principal onde todas as funcionalidades foram implementadas
		while (escolha != 5) {
			// Print para mostrar o usuario as opções que ele pode escolher
			System.out.println("[1] Inserir um jogador, tecnico, arbitro ou seleção.\n"
					+ "[2] Editar um jogador, tecnico, arbitro ou seleção.\n"
					+ "[3] Excluir um jogador, tecnico, arbitro ou seleção.\n"
					+ "[4] Listar os jogadores, tecnicos, arbitros ou seleções.\n" + "[5] Sair do programa.\n");

			// Coletando a escolha do usuario atraves de uma função criada
			escolha = Funcoes.entradaInt("Digite o numero relacionado a uma opção acima:");

			// MENU GERAL
			switch (escolha) {
			// INSERÇÃO de todos os objetos
			case 1:
				// Função para mostrar as opções que o usuario pode escolher e a função que
				// coleta a escolha do usuario
				Funcoes.mostrarOpcoes();

				escolha_inserir = Funcoes.entradaIntRanger("Digite o numero relacionado a uma opção acima:", 1, 5);

				// Inserção dividida entre seleção, aribtro, tecnico e jogador
				switch (escolha_inserir) {
				// INSERÇÃO SELEÇÃO
				case 1:
					// Apenas cria a seleção com o nome que o usuario escolher
					SelecaoDAO.inserir(new Selecao(Funcoes.entradaString("Digite o nome da Seleção: ")));

					break;

				// INSERÇÃO ARBITRO
				case 2:
					// Apenas cria o arbitro com o nome que o usuario escolher
					ArbitroDAO.inserir(new Arbitro(Funcoes.entradaString("Digite o nome do arbitro: ")));
					break;
				// INSERÇÃO TECNICO
				case 3:
					// So aceita a criação de um arbitro se existir uma seleção para ele poder fazer
					// parte
					if (SelecaoDAO.selecoesSemTecnico() > 0) {
						SelecaoDAO.imprimirSelecaoSemTecnico();
						int numSelecao = Funcoes.entradaInt("Digite o numero da seleção que o tecnico faz parte: ");
						String nomeTecnico = Funcoes.entradaString("Digite o nome do Tecnico: ");

						// Caso o usuario escolha um numero que não refere a nenhuma seleção ele não ira
						// criar o tecnico
						if (SelecaoDAO.getOneSelecao(numSelecao) == null) {
							break;
						} else {

							TecnicoDAO.inserir(new Tecnico(nomeTecnico, SelecaoDAO.getOneSelecao(numSelecao)));
							System.out.println();
						}
					} else {
						System.out.println(
								"\nAntes de criar um tecnico, é preciso criar uma seleção ou ter uma seleção sem tecnico alocado!\n");
					}
					break;
				case 4:

					if (SelecaoDAO.quantidadeSelecoes() > 0) {
						SelecaoDAO.imprimirSelecao();
						int numSelecao = Funcoes.entradaIntRanger(
								"Digite o numero da seleção que o jogador faz parte: ", 0,
								SelecaoDAO.quantidadeSelecoes() - 1);
						String nomeJogador = Funcoes.entradaString("Digite o nome do Jogador: ");
						int quant_Cart_Amarelo = Funcoes.entradaIntRanger("Digite a quantidade de Cartões Amarelos: ",
								0);
						int quant_Cart_Vermelho = Funcoes.entradaIntRanger("Digite a quantidade de Cartões Vermelhos: ",
								0);
						int gol_marcado = Funcoes
								.entradaIntRanger("Digite a quantidade de Gols marcados pelo jogador: ", 0);
						Selecao modelo_Selecao = SelecaoDAO.getOneSelecao(numSelecao);
						Jogador modelo_Jogador = new Jogador(nomeJogador, modelo_Selecao, quant_Cart_Vermelho,
								quant_Cart_Amarelo, gol_marcado);
						Boolean respostaBoolean = JogadorDAO.inserir(modelo_Jogador, modelo_Selecao);
						if (respostaBoolean) {
							System.out.println("\nJogador adicionado com Sucesso!\n");
						} else {
							System.out.println("\nErro! não é possivel adicionar mais de 26 jogadores na seleção.\n");
						}

					} else {
						System.out.println("\nAntes de criar um Jogador, é preciso criar uma seleção!\n");
					}
					break;
				}

				break;

			// EDIÇÃO
			case 2:
				Funcoes.mostrarOpcoes();
				escolha_editar = Funcoes.entradaIntRanger("Digite o numero relacionado a uma opção acima:", 1, 5);
				;

				switch (escolha_editar) {
				// EDIÇÃO SELEÇÃO onde pode ser mudado o nome, o tecnico (se pa lista de
				// jogadores)
				case 1:
					SelecaoDAO.listar();
					int numSelecao = Funcoes.entradaInt("Digite o numero da Seleção a ser editada: ");
					System.out.println("\n[0] Editar o nome da seleção\n[1] Editar o tecnico da seleção");
					// Parte onde o usuario vai decidir o que deve ser mudado na seleção
					int opcaoEditar = Funcoes
							.entradaInt("\n[0] Editar o nome da seleção\n[1] Editar o tecnico da seleção\n"
									+ "Digite o numero relacionado a uma opção acima:");

					// Primeira opção onde só edita o nome da seleção
					if (opcaoEditar == 0) {

						String novoNome = Funcoes.entradaString("Digite o novo nome da seleção: ");
						if (SelecaoDAO.editar(SelecaoDAO.getOneSelecao(numSelecao), novoNome) == true) {
							System.out.println("\nA operação foi um sucesso!\n");
						} else {
							System.out.println("\nA operação foi uma falha!\n");
						}
						// Segunda opção onde só edita o tecnico da seleção
					} else if (opcaoEditar == 1) {
						// Teste de erro para caso a seleção não possua um tecnico
						try {
							String novoNomeTecnico = Funcoes.entradaString("Digite o novo nome do tecnico: ");
							if (TecnicoDAO.editar(
									TecnicoDAO.getTecnicoIndes(SelecaoDAO.getOneSelecao(numSelecao).getTecnico()),
									novoNomeTecnico) == true) {
								System.out.println("\nA operação foi um sucesso!\n");
							} else {
								System.out.println("\nA operação foi uma falha!\n");
							}
						} catch (Exception e) {
							System.out.println("\nSeleção ainda não possui tecnico ou não existe\n");
						}

					} else {
						System.out.println("\nOpção digitada invalida!\n");
					}
					break;

				// EDIÇÃO ARBITRO onde só pode ter seu nome mudado
				case 2:
					ArbitroDAO.listar();
					int numArbitro = Funcoes.entradaInt("Digite o numero do arbitro a ser editado: ");
					String nomeArbitro = Funcoes.entradaString("Digite o novo nome do arbitro: ");
					// Caso receba um novo nome invalido, o nome não será alterado
					if (ArbitroDAO.editar(ArbitroDAO.getOneArbitro(numArbitro), nomeArbitro) == true) {
						System.out.println("\nA operação foi um sucesso!\n");
					} else {
						System.out.println("\nA operação foi uma falha!\n");
					}
					
					break;
				// EDIÇÂO TECNICO onde poderá mudar seu nome sua seleção
				case 3:
					TecnicoDAO.listar();
					int numTecnico = Funcoes.entradaInt("Digite o numero do tecnico a ser editado: ");
					System.out.println("\n[0] Editar o nome\n[1] Editar a seleção\n");
					// Parte onde o usuario ira decidir o que mudar no tecnico
					int escolhaEdicaoTecnico = Funcoes.entradaInt(
							"\n[0] Editar o nome\n[1] Editar a seleção\n" + "Digite o que deseja editar no tecnico: ");
					// Primeira opção so mudando o nome do tecnico
					if (escolhaEdicaoTecnico == 0) {
						String nomeTecnico = Funcoes.entradaString("Digite o novo nome do tecnico: ");
						if (TecnicoDAO.editar(TecnicoDAO.getOneTecnico(numTecnico), nomeTecnico) == true) {
							System.out.println("\nA operação foi um sucesso!\n");
						} else {
							System.out.println("\nA operação foi uma falha!\n");
						}
						// Segunda opção onde muda a seleção, porem é necessario a existencia de uma
						// seleção que ainda não possua tecnico
					} else if (escolhaEdicaoTecnico == 1) {
						// Caso não exista seleções sem tecnico, a edição não pode ser concluida
						if (SelecaoDAO.selecoesSemTecnico() == 0) {
							System.out.println(
									"Todas seleções já possuem tecnicos, se quiser editar a seleção de un tecnico é preciso exister uma seleção\n"
											+ "sem tecnico");
						} else {
							int numNovaSelecao = Funcoes.entradaInt("Digite o numero da seleção nova do tecnico: ");
							try {

								SelecaoDAO.getOneSelecao(numNovaSelecao)
										.setTecnico(TecnicoDAO.getOneTecnico(numTecnico));
								TecnicoDAO.getOneTecnico(numTecnico).getSelecao().setTecnico(null);
								TecnicoDAO.getOneTecnico(numTecnico)
										.setSelecao(SelecaoDAO.getOneSelecao(numNovaSelecao));
							} catch (Exception e) {
								System.out.println("Tente novamente!\n");
							}

						}
					} else {
						System.out.println("\nOpção digitada invalida!\n");
					}
				case 4:
					JogadorDAO.listar();
					
					break;
				}
				break;

			// EXCLUSÃO
			case 3:
				Funcoes.mostrarOpcoes();
				escolha_excluir = Funcoes.entradaIntRanger("Digite o numero relacionado a uma opção acima:", 1, 5);
				;
				switch (escolha_excluir) {
				// EXCLUSÃO SELEÇÃO
				case 1:
					// Mostra ao usuario as seleções existente e apos isso recebe o numero digitado
					// pelo mesmo, e só ira excluir caso o numero digitado se
					// refira a uma seleção, caso não nenhuma seleção será excluida
					SelecaoDAO.listar();
					if (SelecaoDAO.excluir(Funcoes.entradaInt("Digite o numero da Seleção a ser excluida: ")) == true) {
						System.out.println("\nA operação foi um sucesso!\n");
					} else {
						System.out.println("\nA operação foi uma falha!\n");
					}
					break;

				// EXCLUSÃO ARBITRO
				case 2:
					ArbitroDAO.listar();
					if (ArbitroDAO.excluir(Funcoes.entradaInt("Digite o numero do arbitro a ser excluido: ")) == true) {
						System.out.println("\nA operação foi um sucesso!\n");
					} else {
						System.out.println("\nA operação foi uma falha!\n");
					}
					;
					break;
				// EXCLUSÃO TECNICO
				case 3:
					TecnicoDAO.listar();
					if (TecnicoDAO.excluir(Funcoes.entradaInt("Digite o numero do tecnico a ser exlcuido: ")) == true) {
						System.out.println("\nA operação foi um sucesso!\n");
					} else {
						System.out.println("\nA operação foi uma falha!\n");
					}
					
					break;
				// EXCLUSÃO JOGADOR
				case 4:
					JogadorDAO.listar();
					if (JogadorDAO.excluir(Funcoes.entradaInt("Digite o numero do Jogador a ser exlcuido: ")) == true) {
						System.out.println("\nA operação foi um sucesso!\n");
					} else {
						System.out.println("\nA operação foi uma falha!\n");
					}
					break;
				}
				break;

			// LISTAR
			case 4:
				Funcoes.mostrarOpcoes();
				escolha_listar = Funcoes.entradaIntRanger("Digite o numero relacionado a uma opção acima:", 1, 5);
				switch (escolha_listar) {
				// LISTAR SELEÇÃO
				case 1:
					SelecaoDAO.listar();
					break;
				// LISTAR ARBITRO
				case 2:
					ArbitroDAO.listar();
					break;
				// LISTAR TECNICO
				case 3:
					TecnicoDAO.listar();
					break;
				// LISTAR JOGADOR
				case 4:
					JogadorDAO.listar();
					break;
				}
				break;

			// SAIDA
			case 5:
				System.out.println("\nSaindo do programa!");
				break;
			default:
				System.out.println("\nLembre-se de digitar apenas os numeros relacionados a opções.\n");

			}
		}

	}
}
