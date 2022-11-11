package application;

import java.util.HashMap;
import java.util.Map;

import model.Funcoes;
import model.GrupoPrimeiraFase;
import model.SelecaoDAO;
import model.Selecao;
import model.Jogador;
import model.Partida;
import model.PartidaDAO;

public class MainPartida {
	public static void criarPrimeiraFase() {
		GrupoPrimeiraFase.organizadorTodasPartidas();
		GrupoPrimeiraFase.listarTodosGrupos();

	}

	public static void editarGols(Partida partida, boolean verificaoAddPonto) {
		Map<Jogador, Integer> jogadorGolsMap = new HashMap<>();
		int golSelecao1 = Funcoes
				.entradaIntRanger("Digite o número de gols da Seleção |" + partida.getSelecao1() + "| : ", 0);
		int cont = 1;
		for (Jogador jogador : partida.getSelecao1().getJogadores()) {
			System.out.println("[" + cont + "]- " + jogador);
			cont++;
		}
		for (int i = 0; i < golSelecao1; i++) {
			int numJogador = Funcoes.entradaIntRanger("Ditige o número do jogador que marcou o " + i + 1 + "° gol: ", 1,
					11);
			Jogador modeloJogador = partida.getSelecao1().getJogadores().get(numJogador - 1);
			if (jogadorGolsMap.containsKey(modeloJogador)) {
				int golJogador = jogadorGolsMap.get(modeloJogador);
				jogadorGolsMap.put(modeloJogador, golJogador + 1);
			} else {
				jogadorGolsMap.put(modeloJogador, 1);
			}
		}
		PartidaDAO.editarGol(partida, jogadorGolsMap, 1);
		if (verificaoAddPonto == false) {
			GrupoPrimeiraFase.definirPontos(partida, false);
		}
		GrupoPrimeiraFase.definirPontos(partida, true);

	}

	public static void excluirPartida() {
		String letraGrupo = Funcoes.entradaLetraGrupo("Digite a Letra do grupo que a seleção pertence [A-H]: ", true);
		PartidaDAO.listarGrupo(letraGrupo);
		int escolha = Funcoes.entradaIntRanger("Ditige o número da partida para excui-la [1-6]: ", 1, 6);
		Partida modeloPartida = PartidaDAO.procurarPartida(letraGrupo, escolha);
		if (PartidaDAO.excluir(modeloPartida)) {
			System.out.println("Todos os dados dessa Partida foram excuídos.");
			System.out.println(modeloPartida);
		} else {
			System.out.println("Erro! Partida Não encontrada!");
		}
	}

}
