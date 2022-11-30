package app.model;

import java.util.ArrayList;
import java.util.List;

public class QuartasDeFinal {
	
	private static List<Partida> partidasQuartas = new ArrayList<>();

	public static void organizarPartidasQuartas() {
		List<Selecao> selecoesOitavas = OitavasDeFinal.selecoesClassificadasOitavas();
		for (int i = 0, c = 1; i < 8; i+=2, c+=2) {
			partidasQuartas.add(new Partida(selecoesOitavas.get(i), selecoesOitavas.get(c), 2));
			
		}
		for (Partida partida : partidasQuartas) {
			PartidaDAO.inserir(partida);
			SelecaoDAO.adicionarPartidas(partida, partida.getSelecao1());
			SelecaoDAO.adicionarPartidas(partida, partida.getSelecao2());
		}
	}
	
	public static List<Selecao> ClassificadosQuartas() {
		List<Selecao> selecoesClassificadas = new ArrayList<>();
		for (Partida partidaQuarta : partidasQuartas) {
			selecoesClassificadas.add(PartidaDAO.GanhadorPartida(partidaQuarta));
		}
		return selecoesClassificadas;
	}
	public static void listarPartidasQuartas() {
		int contador = 1;
		for (Partida partida : partidasQuartas) {
			System.out.println("Quartas de Final"+contador+": "+ partida.getGolSelecao1() +" "+partida+" " +partida.getGolSelecao2() );
			contador++;
		}
	}
}
