package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PartidaDAO {
	// Colocar Privado depois de fazer os Testes
	public static List<Partida> listaPartidas = new ArrayList<>();

	public static boolean inserir(Partida partida) {
		if (!listaPartidas.contains(partida)) {
			listaPartidas.add(partida);
			return true;
		
		}
		return false;
	}

	public static boolean editarAno(int ano) {
		if (ano > 0) {
			Partida.setAno(ano);
			return true;
		} else {
			return false;
		}
	}

	public static boolean editarMes(int mes, Partida partida) {
		if (0 < mes && mes < 13) {
			partida.setMes(mes);
			return true;
		} else {
			return false;
		}
	}

	public static boolean editarDia(int dia, Partida partida) {
		int mes = partida.getMes();
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if (0 < dia && dia < 32) {
				partida.setDia(dia);
				return true;
			}
			return false;
		} else if (mes == 2) {
			if (0 < dia && dia < 29) {
				partida.setDia(dia);
				return true;
			}
			return false;
		} else {
			if (0 < dia && dia < 31) {
				partida.setDia(dia);
				return true;
			}
			return false;
		}
	}

	public static boolean editarHorario(int hora, int minuto, Partida partida) {
		if (0 <= hora && hora <= 23 && 0 <= minuto && minuto <= 59) {
			partida.setHorario(hora);
			partida.setHorarioM(minuto);
			return true;
		}
		return false;
	}

	public static boolean editarLocal(String local, Partida partida) {
		if (local.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\s]+")) {
			partida.setLocal(local);
			return true;
		}
		return false;
	}

	

	

	public static boolean excluir(Partida partida) {
		if (listaPartidas.contains(partida)) {
			for (Entry<Jogador, Integer> jogadoresGol : partida.getGolsMarcadosSelecao1().entrySet()) {
				Jogador modeloJogador = jogadoresGol.getKey();
				int golMarcadoReduzido = JogadorDAO.getQuantidadeGols(modeloJogador) - jogadoresGol.getValue();
				JogadorDAO.editarGolMarcado(modeloJogador, golMarcadoReduzido);
			}
			for (Entry<Jogador, Integer> jogadoresCartAmarelo : partida.getCartaoAmareloSelecao1().entrySet()) {
				Jogador modeloJogador = jogadoresCartAmarelo.getKey();
				int cartAmareloReduzido = JogadorDAO.getQuantidadeCartAmarelo(modeloJogador)
						- jogadoresCartAmarelo.getValue();
				JogadorDAO.editarCartAmarelo(modeloJogador, cartAmareloReduzido);
			}

			for (Entry<Jogador, Integer> jogadoresCartVermelho : partida.getCartaoVermelhoSelecao1().entrySet()) {
				Jogador modeloJogador = jogadoresCartVermelho.getKey();
				int cartVermelhoReduzido = JogadorDAO.getQuantidadeCartVermelho(modeloJogador)
						- jogadoresCartVermelho.getValue();
				JogadorDAO.editarCartVermelho(modeloJogador, cartVermelhoReduzido);
			}
			for (Entry<Jogador, Integer> jogadoresGol : partida.getGolsMarcadosSelecao2().entrySet()) {
				Jogador modeloJogador = jogadoresGol.getKey();
				int golMarcadoReduzido = JogadorDAO.getQuantidadeGols(modeloJogador) - jogadoresGol.getValue();
				JogadorDAO.editarGolMarcado(modeloJogador, golMarcadoReduzido);
			}
			for (Entry<Jogador, Integer> jogadoresCartAmarelo : partida.getCartaoAmareloSelecao2().entrySet()) {
				Jogador modeloJogador = jogadoresCartAmarelo.getKey();
				int cartAmareloReduzido = JogadorDAO.getQuantidadeCartAmarelo(modeloJogador)
						- jogadoresCartAmarelo.getValue();
				JogadorDAO.editarCartAmarelo(modeloJogador, cartAmareloReduzido);
			}

			for (Entry<Jogador, Integer> jogadoresCartVermelho : partida.getCartaoVermelhoSelecao2().entrySet()) {
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
			partida.getCartaoAmareloSelecao1().clear();
			partida.getCartaoVermelhoSelecao1().clear();
			partida.getGolsMarcadosSelecao1().clear();
			partida.getCartaoAmareloSelecao2().clear();
			partida.getCartaoVermelhoSelecao2().clear();
			partida.getGolsMarcadosSelecao2().clear();
			partida.getListaArbitro().clear();
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

	public static boolean statusAtuaisPartidas(Partida partida) {
		return partida.getStatus();
	}
}
