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

	public static boolean editarGol(Map<Jogador, Integer> golsJogador, Partida partida, int numSelecao ) {
		Selecao modeloSelecao;
		int golSelecao;
		if(numSelecao == 0) {
			modeloSelecao = partida.getSelecao1();
			
		}else if (numSelecao == 1) {
			modeloSelecao = partida.getSelecao2();
		}
		else {
			return false;
		}
		for (Map.Entry<Jogador, Integer> entry : golsJogador.entrySet()) {
			Integer gol = entry.getValue();
			if(gol < 0) {
				return false;
			}
		}
		for (Map.Entry<Jogador, Integer> entry : golsJogador.entrySet()) {
			return true;
		}
		return false;
	}
	private static void distribuidorGols(Selecao selecao) {
		List<Partida> partidas = SelecaoDAO.listaPartidas(selecao);
		for (Partida partida : partidas) {
			
		}
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
