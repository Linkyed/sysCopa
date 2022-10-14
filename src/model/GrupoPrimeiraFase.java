package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrupoPrimeiraFase {
	private static Map<Selecao, Integer> grupoA = new HashMap<>();
	private static Map<Selecao, Integer> grupoB = new HashMap<>();
	private static Map<Selecao, Integer> grupoC = new HashMap<>();
	private static Map<Selecao, Integer> grupoD = new HashMap<>();
	private static Map<Selecao, Integer> grupoE = new HashMap<>();
	private static Map<Selecao, Integer> grupoF = new HashMap<>();
	private static Map<Selecao, Integer> grupoG = new HashMap<>();
	private static Map<Selecao, Integer> grupoH = new HashMap<>();

	public static boolean adicionarSelecao(String grupo, Selecao selecao) {
		boolean addBoolean = SelecaoDAO.inserir(selecao);
		if (addBoolean) {
			if (grupo.equalsIgnoreCase("A") && grupoA.size() < 5) {
				grupoA.put(selecao, 0);
			} else if (grupo.equalsIgnoreCase("B") && grupoB.size() < 5) {
				grupoB.put(selecao, 0);
			} else if (grupo.equalsIgnoreCase("C") && grupoC.size() < 5) {
				grupoC.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("D") && grupoD.size() < 5) {
				grupoD.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("E") && grupoE.size() < 5) {
				grupoE.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("F") && grupoF.size() < 5) {
				grupoF.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("G") && grupoG.size() < 5) {
				grupoG.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("H") && grupoH.size() < 5) {
				grupoH.put(selecao, 0);

			} else {
				return false;
			}
			return true;
		}

		return false;
	}

	private static void organizadorGrupo(Map<Selecao, Integer> grupo) {
		List<Selecao> selecoesGrupoList = new ArrayList<>();
		for (Map.Entry<Selecao, Integer> selecaoEpontos : grupo.entrySet()) {
			Selecao selecao = selecaoEpontos.getKey();
			selecoesGrupoList.add(selecao);
		}
		for (int i = 1; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(0), selecoesGrupoList.get(i));
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 2; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(1), selecoesGrupoList.get(i));
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 3; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(2), selecoesGrupoList.get(i));
			PartidaDAO.inserir(modeloPartida);
		}

	}

	public static boolean organizadorTodasPartidas() {
		int totalSelecoes = grupoA.size() + grupoB.size() + grupoC.size() + grupoD.size() + grupoE.size()
				+ grupoF.size() + grupoG.size() + grupoH.size();
		if (totalSelecoes == 32) {
			organizadorGrupo(grupoA);
			organizadorGrupo(grupoB);
			organizadorGrupo(grupoC);
			organizadorGrupo(grupoD);
			organizadorGrupo(grupoE);
			organizadorGrupo(grupoF);
			organizadorGrupo(grupoG);
			organizadorGrupo(grupoH);
			return true;
		}
		return false;

	}

	public static void definirPontos(Partida partida) {
		List<Selecao> resultadoList = PartidaDAO.resultadoPartida(partida);
		if (resultadoList.size() == 1) {
			if (grupoA.containsKey(resultadoList.get(0))) {
				int pontos = grupoA.get(resultadoList.get(0)) + 3;
				grupoA.put(resultadoList.get(0), pontos);
			} else if (grupoB.containsKey(resultadoList.get(0))) {
				int pontos = grupoB.get(resultadoList.get(0)) + 3;
				grupoB.put(resultadoList.get(0), pontos);
			} else if (grupoC.containsKey(resultadoList.get(0))) {
				int pontos = grupoC.get(resultadoList.get(0)) + 3;
				grupoC.put(resultadoList.get(0), pontos);
			} else if (grupoD.containsKey(resultadoList.get(0))) {
				int pontos = grupoD.get(resultadoList.get(0)) + 3;
				grupoD.put(resultadoList.get(0), pontos);
			} else if (grupoE.containsKey(resultadoList.get(0))) {
				int pontos = grupoE.get(resultadoList.get(0)) + 3;
				grupoE.put(resultadoList.get(0), pontos);
			} else if (grupoF.containsKey(resultadoList.get(0))) {
				int pontos = grupoF.get(resultadoList.get(0)) + 3;
				grupoF.put(resultadoList.get(0), pontos);
			} else if (grupoG.containsKey(resultadoList.get(0))) {
				int pontos = grupoG.get(resultadoList.get(0)) + 3;
				grupoG.put(resultadoList.get(0), pontos);
			} else if (grupoH.containsKey(resultadoList.get(0))) {
				int pontos = grupoH.get(resultadoList.get(0)) + 3;
				grupoH.put(resultadoList.get(0), pontos);
			}
		}else {
			
		}
	}

}
