package application;

import java.util.ArrayList;
import java.util.List;

import model.Funcoes;
import model.Jogador;
import model.JogadorDAO;
import model.Selecao;
import model.SelecaoDAO;

public class MainJogador {
	public static void inserirJogador(Selecao selecao) {
		String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do jogador que será inserido: ", true));
		int posicao = Funcoes.entradaIntRanger("[0] Goleiro\n[1] Lateral direito\n[2] Lateral esquerdo\n"+
		"[3] Zagueiro\n[4] Volante\n[5] Meia atacante\nDigite a posição do jogador:", 0, 5);
		Jogador jogador = new Jogador(nome, selecao, posicao);
		if (JogadorDAO.inserir(jogador, selecao, true)) {
			System.out.println("\nO joador foi inserido com sucesso!\n");
		} else {
			System.out.println("\nO jogador não pode ser inserido! Ele já está na cadastrado!\n");
		}	
	}	
	
	public static void inserirJogador() {
		if (SelecaoDAO.selecoesComVagaJogador().size() > 0) {
			String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome do jogador que será inserido: ", true));
			int posicao = Funcoes.entradaIntRanger("[0] Goleiro\n[1] Lateral direito\n[2] Lateral esquerdo\n"+
					"[3] Zagueiro\n[4] Volante\n[5] Meia atacante\nDigite a posição do jogador: ", 0, 5);
			SelecaoDAO.selecoesComVagaJogador().forEach(n -> System.out.println("["+SelecaoDAO.getIndexSelecao(n)+"] "+n.getNome()+"\n"));
			List<Integer> numerosPossiveis = new ArrayList<>();
			SelecaoDAO.selecoesComVagaJogador().forEach(n -> numerosPossiveis.add(SelecaoDAO.getIndexSelecao(n)));
			int selecao = Funcoes.entradaIntList("Digite o numero relacionado a seleção onde o jogador sera adicionado: ", numerosPossiveis);
			
			Jogador jogador = new Jogador(nome, SelecaoDAO.getOneSelecao(selecao), posicao);
			if (JogadorDAO.inserir(jogador, SelecaoDAO.getOneSelecao(selecao), true)) {
				System.out.println("\nO joador foi inserido com sucesso!\n");
			} else {
				System.out.println("\nO jogador não pode ser inserido! Ou ele já está na cadastrado ou a seleção esta cheia!\n");
			}	
		} else {
			System.out.println("\nNão existe seleções para o jogador ser adicionado! Crie uma antes de inserir o jogador!\n");
		}
	}	
	
	public static void editarJogador() {
		JogadorDAO.listar();
		if (JogadorDAO.getQuantidadeJogadores() > 0) {
			int jogador = Funcoes.entradaIntRanger("Digite o numero do jogador que será editado: ", 0, JogadorDAO.getQuantidadeJogadores()-1);
			int edicao = Funcoes.entradaIntRanger("[0] Nome\n[1] Posição\nDigite o que deseja editar do joador: ", 0, 1);
			if (edicao == 0) {
				String nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o novo nome do jogador: ", true));
				if (JogadorDAO.editarNome(jogador, nome)) {
					System.out.println("\nJoador editado com sucesso!\n");
				} else {
					System.out.println("\nNão foi possivel editar o jogador! Tente novamente!\n");
				}
			} else {
				int posicao = Funcoes.entradaIntRanger("[0] Goleiro\n[1] Lateral direito\n[2] Lateral esquerdo\n"+
						"[3] Zagueiro\n[4] Volante\n[5] Meia atacante\nDigite a posição do Jogador: ", 0, 5);
				if (JogadorDAO.editarPosicao(jogador, posicao)) {
					System.out.println("\nJoador editado com sucesso!\n");
				} else {
					System.out.println("\nNão foi possivel editar o jogador! Tente novamente!\n");
				}
			}
		} else {
			System.out.println("\nNão existe nenhum jogador para ser editado!\n");
		}
	}
	
	public static Selecao excluirJogador() {
		JogadorDAO.listar();
		Selecao selecao = null;
		if(JogadorDAO.getQuantidadeJogadores()> 0) {
			int escolhaJogador = Funcoes.entradaIntRanger("Digite o numero correspondete a um jogador para ser excluido: ", 0, JogadorDAO.getQuantidadeJogadores()-1);
			selecao = JogadorDAO.getOneJogador(escolhaJogador).getSelecao();
			boolean exclusao = JogadorDAO.excluir(escolhaJogador);
			while (exclusao == false) {
				System.out.println("\nO jogador não pode ser excluido, tente novamente!\n");
				escolhaJogador = Funcoes.entradaIntRanger("Digite o numero correspondete a um jogador para ser excluido: ", 0, JogadorDAO.getQuantidadeJogadores()-1);
				selecao = JogadorDAO.getOneJogador(escolhaJogador).getSelecao();
				exclusao = JogadorDAO.excluir(escolhaJogador);
			} 
			System.out.println("\nJogador foi excluido com sucesso!\n");
						
		} else {
			System.out.println("\nNão existe nenhum jogador para ser excluido!\n");
		}
		return selecao;
	}
}
