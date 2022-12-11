package app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

	private static List<Partida> partidasGrupo = new ArrayList<>();

	/**
	 * Metodo para retornar um Map(Seleção/Integer) com base em uma seleção e o
	 * grupo que ela esta
	 **/
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

	/** Metodo para retorna a String da letra do grupo que uma seleção está **/
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

	/** Metodo para excluir uma seleção do grupo que elá está **/
	public static void excluirSelecaoGrupo(Selecao selecao) {
		Map<Selecao, Integer> grupoMap = selecionarGrupo(selecao);
		if (grupoMap != null) {
			grupoMap.remove(selecao);
		}
	}

	/** Metodo para retornar os pontos que uma seleção possui dentro do grupo **/
	public static int pontuacaoSelecao(Selecao selecao) {
		int pontos = selecionarGrupo(selecao).get(selecao);
		return pontos;
	}

	/** Metodo para adicionar a seleção em um grupo **/
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

	/**
	 * Metodo para organizar um Map(Seleção/Integer) com base em quem tem os maiores
	 * valores inteiros ficando no inicio da fila
	 **/
	private static void organizadorGrupo(Map<Selecao, Integer> grupo) {
		List<Selecao> selecoesGrupoList = new ArrayList<>();
		for (Map.Entry<Selecao, Integer> selecaoEpontos : grupo.entrySet()) {
			Selecao selecao = selecaoEpontos.getKey();
			selecoesGrupoList.add(selecao);
		}
		for (int i = 1; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(0), selecoesGrupoList.get(i), 0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(0));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 2; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(1), selecoesGrupoList.get(i), 0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(1));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
			PartidaDAO.inserir(modeloPartida);
		}
		for (int i = 3; i < 4; i++) {
			Partida modeloPartida = new Partida(selecoesGrupoList.get(2), selecoesGrupoList.get(i), 0);
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(2));
			SelecaoDAO.adicionarPartidas(modeloPartida, selecoesGrupoList.get(i));
			partidasGrupo.add(modeloPartida);
			PartidaDAO.inserir(modeloPartida);
		}

	}

	public static List<Selecao> selecoesGrupo(String letraGrupo) {
		Map<Selecao, Integer> grupo = encontrarGrupo(letraGrupo);
		Map<Selecao, List<Integer>> criteriosMap = new HashMap<>();
		for (Map.Entry<Selecao, Integer> entry : grupo.entrySet()) {
			List<Integer> criterios = new ArrayList<>();
			Selecao selecao = entry.getKey();
			criterios.add(selecao.getPontos());
			criterios.add(selecao.getSaldoDeGols());
			criterios.add(selecao.getGolsMarcados());
			criteriosMap.put(selecao, criterios);
		}
		List<List<Integer>> criteriosList = new ArrayList<>(criteriosMap.values());
		System.out.println(criteriosList);
		List<Selecao> selecoes = new ArrayList<>();
		criteriosList.sort((x, y) -> {
			for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
				if (x.get(i) != y.get(i)) {
					return x.get(i) - y.get(i);
				}
			}
			return x.size() - y.size();
		});
		for (List<Integer> list : criteriosList) {
			for (Entry<Selecao, List<Integer>> entry : criteriosMap.entrySet()) {
				Selecao selecao = entry.getKey();
				List<Integer> lis = entry.getValue();
				if (list.equals(lis) && !selecoes.contains(selecao))
					selecoes.add(selecao);
			}
		}
		Collections.reverse(selecoes);
		return selecoes;
	}

	/** Metodo para para organizar todos os grupos de uma vez **/
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

	/**
	 * Metodo para decidir com base numa partida os pontos que uma seleção deve
	 * receber
	 **/
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
				SelecaoDAO.definirPontos(pontos, resultadoList.get(0));
			} else {
				int pontos1 = grupoSelecionado.get(resultadoList.get(0)) + empate;
				grupoSelecionado.put(resultadoList.get(0), pontos1);
				SelecaoDAO.definirPontos(pontos1, resultadoList.get(0));
				int pontos2 = grupoSelecionado.get(resultadoList.get(1)) + empate;
				grupoSelecionado.put(resultadoList.get(1), pontos2);
				SelecaoDAO.definirPontos(pontos2, resultadoList.get(1));
			}
		}
	}

	/** Metodo para imprimir todos os grupos e suas seleções **/
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

	/** Metodo para listar um determinado grupo **/
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

	/**
	 * Metodo que retorna uma lista de seleções que com base nos pontos foram
	 * classificadas para a proxima fase
	 **/
	private static List<Selecao> maisPontosGrupo(String grupo) {
		List<Selecao> selecaoClassificada = new ArrayList<>();
		List<Selecao> listGrupo = selecoesGrupo(grupo);

		selecaoClassificada.add(listGrupo.get(0));
		selecaoClassificada.add(listGrupo.get(1));

		return selecaoClassificada;
	}

	/** Metodo para listar todos os grupos **/
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

	/**
	 * Metodo para retorna a quantidade de seleções que existem em um determinado
	 * grupo
	 **/
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

	/** Metodo para retorna um Map com base na String de seu grupo **/
	private static Map<Selecao, Integer> encontrarGrupo(String grupo) {
		if (grupo.equalsIgnoreCase("A")) {
			return grupoA;
		} else if (grupo.equalsIgnoreCase("B")) {
			return grupoB;
		} else if (grupo.equalsIgnoreCase("C")) {
			return grupoC;
		} else if (grupo.equalsIgnoreCase("D")) {
			return grupoD;
		} else if (grupo.equalsIgnoreCase("E")) {
			return grupoE;
		} else if (grupo.equalsIgnoreCase("F")) {
			return grupoF;
		} else if (grupo.equalsIgnoreCase("G")) {
			return grupoG;
		} else if (grupo.equalsIgnoreCase("H")) {
			return grupoH;
		} else {
			System.out.println("Grupo não encontrado.");
			return null;
		}
	}

	/**
	 * Metodo para retorna uma lista de string com o nome das seleções classificadas
	 * para proxima fase
	 **/
	public static List<String> selecoesClassificacaoNome(String grupo) {
		List<String> listaSelecoes = new ArrayList<>();
		Map<Selecao, Integer> selecoesMap = encontrarGrupo(grupo);
		List<Entry<Selecao, Integer>> list = new ArrayList<>(selecoesMap.entrySet());
		list.sort(Entry.comparingByValue());
		Collections.reverse(list);
		for (Entry<Selecao, Integer> entry : list) {
			listaSelecoes.add(entry.getKey().getNome());
		}
		return listaSelecoes;
	}

	/**
	 * Metodo para retorna uma lista de Integger com os pontos das seleções
	 * classificadas para proxima fase
	 **/
	public static List<Integer> selecoesClassificacaoPontos(String grupo) {
		List<Integer> listaSelecoes = new ArrayList<>();
		Map<Selecao, Integer> selecoesMap = encontrarGrupo(grupo);
		List<Entry<Selecao, Integer>> list = new ArrayList<>(selecoesMap.entrySet());
		list.sort(Entry.comparingByValue());
		Collections.reverse(list);
		for (Entry<Selecao, Integer> entry : list) {
			listaSelecoes.add(entry.getValue());
		}
		return listaSelecoes;
	}

	/**
	 * Metodo que retorna uma lista de lista de seleções que possuem as seleções
	 * classificadas de cada grupo
	 **/
	public static List<List<Selecao>> ganhadoresFasedeGrupos() {
		List<List<Selecao>> listaSelecoesClassificadas = new ArrayList<>();
		listaSelecoesClassificadas.add(maisPontosGrupo("A"));
		listaSelecoesClassificadas.add(maisPontosGrupo("B"));
		listaSelecoesClassificadas.add(maisPontosGrupo("C"));
		listaSelecoesClassificadas.add(maisPontosGrupo("D"));
		listaSelecoesClassificadas.add(maisPontosGrupo("E"));
		listaSelecoesClassificadas.add(maisPontosGrupo("F"));
		listaSelecoesClassificadas.add(maisPontosGrupo("G"));
		listaSelecoesClassificadas.add(maisPontosGrupo("H"));
		return listaSelecoesClassificadas;
	}

	/**
	 * Metodo para retorna uma lista de string com o nome de todas as selções de
	 * todos os grupos e caso o grupo não esteja completo, o metodo completa a lista
	 * com a string "Nenhuma"
	 **/
	public static List<String> selecoesTodosGrupos() {
		List<String> nomesSelecoes = new ArrayList<>();
		String grupo = "";
		if (grupoA.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoA.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 4) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoB.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoB.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 8) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoC.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoC.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 12) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoD.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoD.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 16) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoE.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoE.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 20) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoF.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoF.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 24) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoG.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoG.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 28) {
			nomesSelecoes.add("Vazio");
		}

		if (grupoH.size() > 0) {
			List<Entry<Selecao, Integer>> list = new ArrayList<>(grupoH.entrySet());
			list.sort(Entry.comparingByValue());
			Collections.reverse(list);
			for (Entry<Selecao, Integer> selecaoEpontos : list) {
				nomesSelecoes.add(selecaoEpontos.getKey().getNome());
			}
		}
		while (nomesSelecoes.size() < 32) {
			nomesSelecoes.add("Vazio");
		}

		return nomesSelecoes;
	}

	/**
	 * Metodo que retorna uma lista de String com os grupos que ainda possui vaga
	 * para seleções serem inseridas
	 **/
	public static List<String> gruposVazios() {
		List<String> lista = new ArrayList<>();
		if (grupoA.size() < 4) {
			lista.add("A");
		}
		if (grupoB.size() < 4) {
			lista.add("B");
		}
		if (grupoC.size() < 4) {
			lista.add("C");
		}
		if (grupoD.size() < 4) {
			lista.add("D");
		}
		if (grupoE.size() < 4) {
			lista.add("E");
		}
		if (grupoF.size() < 4) {
			lista.add("F");
		}
		if (grupoG.size() < 4) {
			lista.add("G");
		}
		if (grupoH.size() < 4) {
			lista.add("H");
		}
		return lista;
	}

	/** Metodo para resetar todos os grupos **/
	public static void resetarGrupos() {
		grupoA.clear();
		grupoB.clear();
		grupoC.clear();
		grupoD.clear();
		grupoE.clear();
		grupoF.clear();
		grupoG.clear();
		grupoH.clear();

	}

}
