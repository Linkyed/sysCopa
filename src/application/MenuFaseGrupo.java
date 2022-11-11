package application;

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
			MainPartida.editarCartaoAmarelo(partida);
			System.out.println();
		}
		else {
			System.out.println("Erro! A partida já foi feita.\n");
		}
	}
}
