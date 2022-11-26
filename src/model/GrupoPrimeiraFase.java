package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class GrupoPrimeiraFase {
	private static Map<Selecao, Integer> grupoA = new HashMap<>();
	private static Map<Selecao, Integer> grupoB = new HashMap<>();
	private static Map<Selecao, Integer> grupoC = new HashMap<>();
	private static Map<Selecao, Integer> grupoD = new HashMap<>();
	private static Map<Selecao, Integer> grupoE = new HashMap<>();
	private static Map<Selecao, Integer> grupoF = new HashMap<>();
	private static Map<Selecao, Integer> grupoG = new HashMap<>();
	private static Map<Selecao, Integer> grupoH = new HashMap<>();
	
	private static List<Partida> partidasGrupo =  new ArrayList<>();

	private static Map<Selecao, Integer> selecionarGrupo(Selecao selecao) {
		if (grupoA.containsKey(selecao)) {
			return grupoA;
		} else if (grupoB.containsKey(selecao)) {
			return grupoB;
		} else if (grupoC.containsKey(selecao)) {
			return grupoC;
		} else if (grupoD.containsKey(selecao)) {
			return grupoD;
		} else if (grupoE.containsKey(selecao)) {
			return grupoE;
		} else if (grupoF.containsKey(selecao)) {
			return grupoF;
		} else if (grupoG.containsKey(selecao)) {
			return grupoG;
		} else if (grupoH.containsKey(selecao)) {
			return grupoH;
		}
		return null;
	}
	
	public static String grupoSelecao(Selecao selecao) {
		if (grupoA.containsKey(selecao)) {
			return "A";
		} else if (grupoB.containsKey(selecao)) {
			return "B";
		} else if (grupoC.containsKey(selecao)) {
			return "C";
		} else if (grupoD.containsKey(selecao)) {
			return "D";
		} else if (grupoE.containsKey(selecao)) {
			return "E";
		} else if (grupoF.containsKey(selecao)) {
			return "F";
		} else if (grupoG.containsKey(selecao)) {
			return "G";
		} else if (grupoH.containsKey(selecao)) {
			return "H";
		} else {
			return "0";
		}
	}	
	public static void excluirSelecaoGrupo(Selecao selecao) {
		Map<Selecao, Integer> grupoMap = selecionarGrupo(selecao);
		if(grupoMap != null) {
			grupoMap.remove(selecao);			
		}
	}
	
	
	public static int pontuacaoSelecao(Selecao selecao) {
		int pontos = selecionarGrupo(selecao).get(selecao);
		return pontos;
	}

	public static boolean adicionarSelecao(String grupo, Selecao selecao) {
		if (grupo.equalsIgnoreCase("A") && grupoA.size() < 4) {
			grupoA.put(selecao, 0);
		} else if (grupo.equalsIgnoreCase("B") && grupoB.size() < 4) {
			grupoB.put(selecao, 0);
		} else if (grupo.equalsIgnoreCase("C") && grupoC.size() < 4) {
			grupoC.put(selecao, 0);

		} else if (grupo.equalsIgnoreCase("D") && grupoD.size() < 4) {
			grupoD.put(selecao, 0);

		} else if (grupo.equalsIgnoreCase("E") && grupoE.size() < 4) {
			grupoE.put(selecao, 0);

		} else if (grupo.equalsIgnoreCase("F") && grupoF.size() < 4) {
			grupoF.put(selecao, 0);

		} else if (grupo.equalsIgnoreCase("G") && grupoG.size() < 4) {
			grupoG.put(selecao, 0);

		} else if (grupo.equalsIgnoreCase("H") && grupoH.size() < 4) {
			grupoH.put(selecao, 0);

		} else {
			return false;
		}
		return true;
	}

	private static void organizadorGrupo(Map<Selecao, Integer> grupo) {
		List<Selecao> selecoesGrupoList = new ArrayList<>();
		for (Map.Entry<Selecao, Integer> selecaoEpontos : grupo.entrySet()) {
			Selecao selecao = selecaoEpontos.getKey();
			selecoesGrupoList.add(selecao);
		}
		for (int i = 1; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(0), selecoesGrupoList.get(i),0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(0));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 2; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(1), selecoesGrupoList.get(i),0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(1));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 3; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(2), selecoesGrupoList.get(i),0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(2));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
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

	public static void definirPontos(Partida partida, boolean positivo) {
		if (PartidaDAO.statusAtuaisPartidas(partida)) {
			int vitoria;
			int empate;
			List<Selecao> resultadoList = PartidaDAO.resultadoPartida(partida);
			Map<Selecao, Integer> grupoSelecionado = selecionarGrupo(resultadoList.get(0));
			if (positivo) {
				vitoria = 3;
				empate = 1;
			} else {
				
				vitoria = -3;
				empate = -1;
			}
			if (resultadoList.size() == 1) {
				int pontos = grupoSelecionado.get(resultadoList.get(0)) + vitoria;
				grupoSelecionado.put(resultadoList.get(0), pontos);
			} else {
				int pontos1 = grupoSelecionado.get(resultadoList.get(0)) + empate;
				grupoSelecionado.put(resultadoList.get(0), pontos1);
				int pontos2 = grupoSelecionado.get(resultadoList.get(1)) + empate;
				grupoSelecionado.put(resultadoList.get(1), pontos2);
			}
		}
	}

	public static void listaGrupoString(String grupo) {
		if (grupo.equalsIgnoreCase("A")) {
			System.out.println("A");
			listarGrupo(grupoA);
		} else if (grupo.equalsIgnoreCase("B")) {
			System.out.println("B");
			listarGrupo(grupoB);
		} else if (grupo.equalsIgnoreCase("C")) {
			System.out.println("C");
			listarGrupo(grupoC);
		} else if (grupo.equalsIgnoreCase("D")) {
			System.out.println("D");
			listarGrupo(grupoD);
		} else if (grupo.equalsIgnoreCase("E")) {
			System.out.println("E");
			listarGrupo(grupoE);
		} else if (grupo.equalsIgnoreCase("F")) {
			System.out.println("F");
			listarGrupo(grupoF);
		} else if (grupo.equalsIgnoreCase("G")) {
			System.out.println("G");
			listarGrupo(grupoG);
		} else if (grupo.equalsIgnoreCase("H")) {
			System.out.println("H");
			listarGrupo(grupoH);
		} else {
			System.out.println("Grupo não encontrado.");
		}
	}

	private static void listarGrupo(Map<Selecao, Integer> grupo) {
		System.out.println("====================");
		List<Entry<Selecao, Integer>> list = new ArrayList<>(grupo.entrySet());
		list.sort(Entry.comparingByValue());
		Collections.reverse(list);
		for (Entry<Selecao, Integer> selecaoEpontos : list) {
			System.out.println("|| " + selecaoEpontos.getKey() + " | " + selecaoEpontos.getValue() + " ||");
		}
		System.out.println("===================");

	}
	
	private static List<Selecao> maisPontosGrupo(Map<Selecao, Integer> grupo) {
		List<Selecao> selecaoClassificada = new ArrayList<>();
		List<Entry<Selecao, Integer>> list = new ArrayList<>(grupo.entrySet());
		list.sort(Entry.comparingByValue());
		int contador = 0;
		for (Entry<Selecao, Integer> selecaoEpontos : list) {
			if(contador == 2 || contador == 3) {
				selecaoClassificada.add(selecaoEpontos.getKey());
			}
			contador++;
		}
		return selecaoClassificada;
	}

	public static void listarTodosGrupos() {
		System.out.println("A");
		listarGrupo(grupoA);
		System.out.println("B");
		listarGrupo(grupoB);
		System.out.println("C");
		listarGrupo(grupoC);
		System.out.println("D");
		listarGrupo(grupoD);
		System.out.println("E");
		listarGrupo(grupoE);
		System.out.println("F");
		listarGrupo(grupoF);
		System.out.println("G");
		listarGrupo(grupoG);
		System.out.println("H");
		listarGrupo(grupoH);
	}
	
	public static int quantidadeGupo(String grupo) {
		if (grupo.equalsIgnoreCase("A")) {
			return grupoA.size();
		} else if (grupo.equalsIgnoreCase("B")) {
			return grupoB.size();
		} else if (grupo.equalsIgnoreCase("C")) {
			return grupoC.size();
		} else if (grupo.equalsIgnoreCase("D")) {
			return grupoD.size();
		} else if (grupo.equalsIgnoreCase("E")) {
			return grupoE.size();
		} else if (grupo.equalsIgnoreCase("F")) {
			return grupoF.size();
		} else if (grupo.equalsIgnoreCase("G")) {
			return grupoG.size();
		} else if (grupo.equalsIgnoreCase("H")) {
			return grupoH.size();
		} else {
			System.out.println("Grupo não encontrado.");
			return 0;
		}
	}
	
	public static List<List<Selecao>> ganhadoresFasedeGrupos() {
		List<List<Selecao>> listaSelecoesClassificadas = new ArrayList<>();
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoA));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoB));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoC));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoD));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoE));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoF));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoG));
		listaSelecoesClassificadas.add( maisPontosGrupo(grupoH));
		return listaSelecoesClassificadas;
	}

}
