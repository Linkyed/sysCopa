package application;

import model.Funcoes;
import model.GrupoPrimeiraFase;
import model.SelecaoDAO;
import model.Teste;
import model.Selecao;
import model.Jogador;
import model.PartidaDAO;

public class MainPartida {
	public static void criarPrimeiraFase() {
		GrupoPrimeiraFase.organizadorTodasPartidas();
		GrupoPrimeiraFase.listarTodosGrupos();

	}
	
	private static void listarGrupo(String grupo) {
		if (grupo.equalsIgnoreCase("A")) {
			PartidaDAO.listarPartidaGrupo(0, 5);
		} else if (grupo.equalsIgnoreCase("B")) {
			PartidaDAO.listarPartidaGrupo(6, 11);
		} else if (grupo.equalsIgnoreCase("C")) {
			PartidaDAO.listarPartidaGrupo(12, 17);
		} else if (grupo.equalsIgnoreCase("D")) {
			PartidaDAO.listarPartidaGrupo(18, 23);
		} else if (grupo.equalsIgnoreCase("E")) {
			PartidaDAO.listarPartidaGrupo(24, 29);
		} else if (grupo.equalsIgnoreCase("F")) {
			PartidaDAO.listarPartidaGrupo(30, 35);
		} else if (grupo.equalsIgnoreCase("G")) {
			PartidaDAO.listarPartidaGrupo(36, 41);
		} else if (grupo.equalsIgnoreCase("H")) {
			PartidaDAO.listarPartidaGrupo(42, 47);
		} else {
			System.out.println("Grupo não encontrado.");
		}
		
	}
	
	private static void buscarPartida() {
		
	}
	
	public static boolean excluirPartida() {
		String letraGrupo = Funcoes.entradaLetraGrupo("Digite a Letra do grupo que a seleção pertence [A-H]: ", true);
		listarGrupo(letraGrupo);
		int escolha = Funcoes.entradaIntRanger("Ditige o número da partida para excui-la [1-6]: ", 1,6);
		
		return false;
	}
	
}
