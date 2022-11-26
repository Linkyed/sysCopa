package model;

import java.util.ArrayList;
import java.util.List;

public class OitavasDeFinal {
	private static List<Partida> partidasOitavas =  new ArrayList<>();
	
	public static void OrganizarPartidasOitavas() {
		List<List<Selecao>> listaSelecoesClassificadas = GrupoPrimeiraFase.ganhadoresFasedeGrupos();
		partidasOitavas.add( new Partida(listaSelecoesClassificadas.get(0).get(0), listaSelecoesClassificadas.get(1).get(1), 1));
		partidasOitavas.add( new Partida(listaSelecoesClassificadas.get(2).get(0), listaSelecoesClassificadas.get(3).get(1), 1));
		partidasOitavas.add(new Partida(listaSelecoesClassificadas.get(4).get(0), listaSelecoesClassificadas.get(5).get(1), 1));
		partidasOitavas.add(new Partida(listaSelecoesClassificadas.get(6).get(0), listaSelecoesClassificadas.get(7).get(1), 1));
		partidasOitavas.add( new Partida(listaSelecoesClassificadas.get(1).get(0), listaSelecoesClassificadas.get(0).get(1), 1));
		partidasOitavas.add(new Partida(listaSelecoesClassificadas.get(3).get(0), listaSelecoesClassificadas.get(2).get(1), 1));
		partidasOitavas.add(new Partida(listaSelecoesClassificadas.get(5).get(0), listaSelecoesClassificadas.get(4).get(1), 1));
		partidasOitavas.add(new Partida(listaSelecoesClassificadas.get(7).get(0), listaSelecoesClassificadas.get(6).get(1), 1));

		for (Partida partidaOitava : partidasOitavas) {
			PartidaDAO.inserir(partidaOitava);
		}
		
	}
	
	public static List<Selecao> selecoesClassificadasOitavas() {
		List<Selecao> selecoesClassificadas = new ArrayList<>();
		for (Partida partidaOitava : partidasOitavas) {
			selecoesClassificadas.add(PartidaDAO.GanhadorPartida(partidaOitava));
		}
		return selecoesClassificadas;
	}
	
	public static void listarPartidasOitavas() {
		int contador = 1;
		for (Partida partida : partidasOitavas) {
			System.out.println("Oitavas de Final "+contador+": "+ partida);
			contador++;
		}
	}
}
