package application;

import model.Funcoes;

public class Menu {

	public static void escolhaPrincipal() {
		int escolha = Funcoes.entradaIntRanger("Bem vindo ao Syscopa, o menu para realizar as ações do programa sera mostrado a seguir:\n"+
				"[1] Inserir um(a) nova(o) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[2] Editar um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[3] Excluir um(a) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"[4] Listar as(os) Seleção, Tecnico, Jogador ou Arbitro\n" +
				"Digite o numero relacionado a uma das opções acima: ", 1, 4);
		
		if (escolha == 1) {
			int inserir = escolhaDoObjeto();
			if (inserir == 1) {
				System.out.println();
			} else if (inserir == 1) {
				System.out.println();
			} else if (inserir == 1) {
				System.out.println();
			} else {
				MainArbitro.inserirArbitro();
			}
		}
		
	}
	
	private static int escolhaDoObjeto() {
		System.out.println("\n[1] Seleção\n[2] Tecnicon\n[3] Jogador\n[4] Arbitro\n");
		return Funcoes.entradaIntRanger("Escolha um numero relacionado as opções acima: ", 1, 4);
	}
	
}
