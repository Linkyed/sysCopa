package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class PartidaDAO {
	// Colocar Privado depois de fazer os Testes
	public static List<Partida> listaPartidas = new ArrayList<>();

	public static boolean inserir(Partida partida) {
		if (!listaPartidas.contains(partida)) {
			listaPartidas.add(partida);
			for (Entry<Jogador, Integer> jogadoresGol : partida.getGolsMarcaosPartida().entrySet()) {
				Jogador modeloJogador = jogadoresGol.getKey();
				int golMarcado = jogadoresGol.getValue() + JogadorDAO.getQuantidadeGols(modeloJogador);
				JogadorDAO.editarGolMarcado(modeloJogador, golMarcado);
			}
			for (Entry<Jogador, Integer> jogadoresCartAmarelo : partida.getCartaoAmareloPartida().entrySet()) {
				Jogador modeloJogador = jogadoresCartAmarelo.getKey();
				int cartAmarelo = jogadoresCartAmarelo.getValue() + JogadorDAO.getQuantidadeCartAmarelo(modeloJogador);
				JogadorDAO.editarCartAmarelo(modeloJogador, cartAmarelo);
			}

			for (Entry<Jogador, Integer> jogadoresCartVermelho : partida.getCartaoAmareloPartida().entrySet()) {
				Jogador modeloJogador = jogadoresCartVermelho.getKey();
				int cartVermelho = jogadoresCartVermelho.getValue()
						+ JogadorDAO.getQuantidadeCartVermelho(modeloJogador);
				JogadorDAO.editarCartVermelho(modeloJogador, cartVermelho);
			}
			Selecao modeloSelecao1 = partida.getSelecao1();
			int golsAtuaisSele1 = SelecaoDAO.getQuantidadeGols(modeloSelecao1) + partida.getGolSelecao1();
			SelecaoDAO.editarGolsSelecao(modeloSelecao1, golsAtuaisSele1);

			Selecao modeloSelecao2 = partida.getSelecao1();
			int golsAtuaisSele2 = SelecaoDAO.getQuantidadeGols(modeloSelecao2) + partida.getGolSelecao2();
			SelecaoDAO.editarGolsSelecao(modeloSelecao2, golsAtuaisSele2);
			return true;
		}
		return false;
	}

	public static boolean excluir(Partida partida) {
		if (listaPartidas.contains(partida)) {
			for (Entry<Jogador, Integer> jogadoresGol : partida.getGolsMarcaosPartida().entrySet()) {
				Jogador modeloJogador = jogadoresGol.getKey();
				int golMarcadoReduzido = JogadorDAO.getQuantidadeGols(modeloJogador) - jogadoresGol.getValue();
				JogadorDAO.editarGolMarcado(modeloJogador, golMarcadoReduzido);
			}
			for (Entry<Jogador, Integer> jogadoresCartAmarelo : partida.getCartaoAmareloPartida().entrySet()) {
				Jogador modeloJogador = jogadoresCartAmarelo.getKey();
				int cartAmareloReduzido = JogadorDAO.getQuantidadeCartAmarelo(modeloJogador)
						- jogadoresCartAmarelo.getValue();
				JogadorDAO.editarCartAmarelo(modeloJogador, cartAmareloReduzido);
			}

			for (Entry<Jogador, Integer> jogadoresCartVermelho : partida.getCartaoAmareloPartida().entrySet()) {
				Jogador modeloJogador = jogadoresCartVermelho.getKey();
				int cartVermelhoReduzido = JogadorDAO.getQuantidadeCartVermelho(modeloJogador)
						- jogadoresCartVermelho.getValue();
				JogadorDAO.editarCartVermelho(modeloJogador, cartVermelhoReduzido);
			}
			Selecao selecao1 = partida.getSelecao1();
			int golSelecao1 = SelecaoDAO.getQuantidadeGols(selecao1) - partida.getGolSelecao1();
			SelecaoDAO.editarGolsSelecao(selecao1, golSelecao1);
			Selecao selecao2 = partida.getSelecao1();
			int golSelecao2 = SelecaoDAO.getQuantidadeGols(selecao2) - partida.getGolSelecao2();
			SelecaoDAO.editarGolsSelecao(selecao2, golSelecao2);
			partida.getCartaoAmareloPartida().clear();
			partida.getCartaoVermelhoPartida().clear();
			partida.getGolsMarcaosPartida().clear();
			GrupoPrimeiraFase.definirPontos(partida, false);
			partida.setStatus(false);
			return true;
		}
		return false;
	}

	public static List<Selecao> resultadoPartida(Partida partida) {
		List<Selecao> resultadoList = new ArrayList<>();
		Selecao selecao1 = partida.getSelecao1();
		Selecao selecao2 = partida.getSelecao2();

		if (partida.getGolSelecao1() > partida.getGolSelecao2()) {
			partida.setResultadoSelecao(selecao1);
			resultadoList.add(selecao1);

		} else if (partida.getGolSelecao1() < partida.getGolSelecao2()) {
			partida.setResultadoSelecao(selecao2);
			resultadoList.add(selecao2);
		} else {
			partida.setResultadoSelecao(null);
			resultadoList.add(selecao1);
			resultadoList.add(selecao2);
		}
		return resultadoList;
	}

	public static void alteracaoDeStatusPartida(boolean statusPartida, Partida partida) {
		partida.setStatus(statusPartida);
	}

	public static void listar() {
		if (listaPartidas.size() > 0) {
			System.out.println("Lista de Partidas:");
			System.out.println("=======================================");
			for (Partida partida : listaPartidas) {
				System.out.println(partida);
			}
		} else {
			System.out.println("Não Existe nenhuma partida feita.");
		}
	}
}
