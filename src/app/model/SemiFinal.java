package app.model;

import java.util.ArrayList;
import java.util.List;

public class SemiFinal {
	private static List<Partida> partidasSemi = new ArrayList<>();

	public static void organizarPartidasSemi() {
		List<Selecao> selecoesQuartas = QuartasDeFinal.ClassificadosQuartas();
		for (int i = 0, c = 1; i < 4; i += 2, c += 2) {
			partidasSemi.add(new Partida(selecoesQuartas.get(i), selecoesQuartas.get(c), 3));
		}
		for (Partida partida : partidasSemi) {
			PartidaDAO.inserir(partida);
			SelecaoDAO.adicionarPartidas(partida, partida.getSelecao1());
			SelecaoDAO.adicionarPartidas(partida, partida.getSelecao2());
		}

	}

	public static List<Selecao> ClassificadosSemi() {
		List<Selecao> selecoesClassificadas = new ArrayList<>();
		for (Partida partidaSemi : partidasSemi) {
			selecoesClassificadas.add(PartidaDAO.GanhadorPartida(partidaSemi));
		}
		return selecoesClassificadas;
	}

	public static List<Selecao> NaoClassificadosSemi() {
		List<Selecao> selecoesNaoClassificadas = new ArrayList<>();
		for (Partida partidaSemi : partidasSemi) {
			if (!PartidaDAO.GanhadorPartida(partidaSemi).equals(partidaSemi.getSelecao1())) {
				selecoesNaoClassificadas.add(partidaSemi.getSelecao1());
			} else {
				selecoesNaoClassificadas.add(partidaSemi.getSelecao2());
			}
		}
		return selecoesNaoClassificadas;
	}

	public static void listarPartidasSemi() {
		int contador = 1;
		for (Partida partida : partidasSemi) {
			System.out.println("SeimiFinal" + contador + ": " + partida.getGolSelecao1() + " " + partida + " "
					+ partida.getGolSelecao2());
			contador++;
		}
	}

	public static List<Partida> listaPartidasSeimiFinal() {
		List<Partida> partidasSemiList = new ArrayList<>();
		for (Partida partida : partidasSemi) {
			partidasSemiList.add(partida);
		}
		return partidasSemiList;
	}
}
