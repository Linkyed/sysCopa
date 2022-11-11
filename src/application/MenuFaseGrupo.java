package application;

import model.GrupoPrimeiraFase;
import model.Partida;
import model.PartidaDAO;

public class MenuFaseGrupo {
	
	
	public static void definirPartida(Partida partida) {
		if (PartidaDAO.statusAtuaisPartidas(partida) == false) {
			PartidaDAO.alteracaoDeStatusPartida(true, partida);
			System.out.println("\n| "+partida+" |\n");
			MainPartida.editarLugar(partida);
			System.out.println();
			MainPartida.editarData(partida);
			System.out.println();
			MainPartida.editarHoraMinuto(partida);
			System.out.println();
			MainPartida.editarGols(partida);
			System.out.println();
			MainPartida.editarCartaoAmarelo(partida);
			System.out.println();
			MainPartida.editarCartaoVermelho(partida);
			System.out.println();
			MainPartida.editarArbitros(partida);
			System.out.println();
		}
		else {
			System.out.println("Erro! A partida já foi feita.\n");
		}
	}
	public static void editarGols(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		GrupoPrimeiraFase.definirPontos(partida, false);
		MainPartida.editarGols(partida);
		System.out.println();
	}
	public static void editarCartaoAm(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarCartaoAmarelo(partida);
		System.out.println();
	}
	public static void editarCartVer(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarCartaoVermelho(partida);
		System.out.println();
	}
	public static void editarArbi(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarArbitros(partida);
		System.out.println();
	}
	public static void editarHorarios(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarHoraMinuto(partida);
		System.out.println();
	}
	public static void editarData(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarData(partida);
		System.out.println();
	}
	public static void editarLugar(Partida partida) {
		System.out.println("\n| "+partida+" |\n");
		MainPartida.editarLugar(partida);
		System.out.println();
	}
	
	
	
}
