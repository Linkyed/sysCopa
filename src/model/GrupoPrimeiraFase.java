package model;

import java.util.HashMap;
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
			if (grupo.equalsIgnoreCase("A") && grupoA.size() > 5) {
				grupoA.put(selecao, 0);
			} else if (grupo.equalsIgnoreCase("B")&& grupoB.size() > 5) {
				grupoB.put(selecao, 0);
			} else if (grupo.equalsIgnoreCase("C")&& grupoC.size() > 5) {
				grupoC.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("D")&& grupoD.size() > 5) {
				grupoD.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("E")&& grupoE.size() > 5) {
				grupoE.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("F")&& grupoF.size() > 5) {
				grupoF.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("G")&& grupoG.size() > 5) {
				grupoG.put(selecao, 0);

			} else if (grupo.equalsIgnoreCase("H")&& grupoH.size() > 5) {
				grupoH.put(selecao, 0);

			}else {
				return false;
			}
			return true;
		}

		return false;
	}
	
	public static boolean organizadorPartidas() {
		int totalSelecoes = grupoA.size() + grupoB.size() + grupoC.size()+ grupoD.size()+ grupoE.size()+ grupoF.size() + grupoG.size() + grupoH.size();
		if(totalSelecoes == 32) {
			for(int i = 0; i < 9; i++) {
				
			}
			return true;
		}
		return false;
		
	}

}
