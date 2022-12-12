package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** Classe DAO da partida **/
public class PartidaDAO {

	private static List<Partida> listaPartidas = new ArrayList<>();

	/** Metodo para inserir a partida **/
	public static boolean inserir(Partida partida) {
		if (!listaPartidas.contains(partida)) {
			listaPartidas.add(partida);
			return true;

		}
		return false;
	}

	/** Metodo para editar o Ano **/
	public static boolean editarAno(int ano) {
		if (ano > 0) {
			Partida.setAno(ano);
			return true;
		} else {
			return false;
		}
	}

	/** Metodo para editar o mês **/
	public static boolean editarMes(int mes, Partida partida) {
		if (0 < mes && mes < 13) {
			partida.setMes(mes);
			return true;
		} else {
			return false;
		}
	}

	/** Metodo para editar o dia **/
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

	/** Metodo para editar o horario **/
	public static boolean editarHorario(int hora, int minuto, Partida partida) {
		if (0 <= hora && hora <= 23 && 0 <= minuto && minuto <= 59) {
			partida.setHorario(hora);
			partida.setHorarioM(minuto);
			return true;
		}
		return false;
	}

	/** Metodo para editar o local **/

	public static boolean editarLocal(String local, Partida partida) {
		if (local.matches("[a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ\s]+")) {
			partida.setLocal(local);
			return true;
		}
		return false;
	}

	/** Metodo para editar os gols dos jogadores **/

	public static boolean editarGol(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
		if (numSelecao == 1) {
			diminuirGols(partida.getGolsMarcadosSelecao1());
			distribuirGols(jogasMap, partida, numSelecao);
			return true;
		} else if (numSelecao == 2) {
			diminuirGols(partida.getGolsMarcadosSelecao2());
			distribuirGols(jogasMap, partida, numSelecao);
			return true;
		}
		return false;

	}

	/** Metodo para diminuir od gols **/
	private static void diminuirGols(Map<Jogador, Integer> map) {
		for (Entry<Jogador, Integer> jogadoresGol : map.entrySet()) {
			Jogador modeloJogador = jogadoresGol.getKey();
			int golMarcadoReduzido = modeloJogador.getGolmarcado() - jogadoresGol.getValue();

			JogadorDAO.editarGolMarcado(modeloJogador, golMarcadoReduzido);

		}
	}

	/** Metodo para distribuir os gols **/
	private static void distribuirGols(Map<Jogador, Integer> jogasMap, Partida partida, int numSelecao) {
		int gols = 0;
		for (Entry<Jogador, Integer> jogadoresGol : jogasMap.entrySet()) {
			Jogador modeloJogador = jogadoresGol.getKey();
			int golMarcado = modeloJogador.getGolmarcado() + jogadoresGol.getValue();
			JogadorDAO.editarGolMarcado(modeloJogador, golMarcado);
			gols += jogasMap.get(modeloJogador);
		}
		if (numSelecao == 1) {
			partida.setGolsMarcadosSelecao1(jogasMap);
			partida.setGolSelecao1(gols);
		} else if (numSelecao == 2) {
			partida.setGolsMarcadosSelecao2(jogasMap);
			partida.setGolSelecao2(gols);
		}

	}

	/** Metodo para editar cartões amarelo dos jogadores **/

	public static boolean editarCartAmarelo(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
		if (numSelecao == 1) {
			diminuirCartaoAmarelo(partida.getCartaoAmareloSelecao1());
			distribuirCartaoAmarelo(jogasMap, partida, numSelecao);
			return true;
		} else if (numSelecao == 2) {
			diminuirCartaoAmarelo(partida.getCartaoAmareloSelecao2());
			distribuirCartaoAmarelo(jogasMap, partida, numSelecao);
			return true;
		}
		return false;
	}

	/** Metodo para diminuir cartões Amarelo **/
	private static void diminuirCartaoAmarelo(Map<Jogador, Integer> map) {
		for (Entry<Jogador, Integer> jogadoresCartAmarelo : map.entrySet()) {
			Jogador modeloJogador = jogadoresCartAmarelo.getKey();
			int cartAmareloReduzido = JogadorDAO.getQuantidadeCartAmarelo(modeloJogador)
					- jogadoresCartAmarelo.getValue();
			JogadorDAO.editarCartAmarelo(modeloJogador, cartAmareloReduzido);
		}
	}

	/** Metodo para distribuir os cartões Amarelo **/
	private static void distribuirCartaoAmarelo(Map<Jogador, Integer> jogasMap, Partida partida, int numSelecao) {
		for (Entry<Jogador, Integer> jogadoresCartAmarelo : jogasMap.entrySet()) {
			Jogador modeloJogador = jogadoresCartAmarelo.getKey();
			int cartAmarelo = modeloJogador.getCartaoAmarelo() + jogadoresCartAmarelo.getValue();
			JogadorDAO.editarCartAmarelo(modeloJogador, cartAmarelo);
		}
		if (numSelecao == 1) {
			partida.setCartaoAmareloSelecao1(jogasMap);
		} else if (numSelecao == 2) {
			partida.setCartaoAmareloSelecao2(jogasMap);
		}

	}

	/** Metodo para editar cartões vermelhos dos jogadores **/
	public static boolean editarCartVermelho(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
		if (numSelecao == 1) {
			diminuirCartaoVermelho(partida.getCartaoVermelhoSelecao1());
			distribuirCartaoVermelho(jogasMap, partida, numSelecao);
			return true;
		} else if (numSelecao == 2) {
			diminuirCartaoVermelho(partida.getCartaoVermelhoSelecao2());
			distribuirCartaoVermelho(jogasMap, partida, numSelecao);
			return true;
		}
		return false;
	}

	/** Metodo para diminuir cartões vermelho **/
	private static void diminuirCartaoVermelho(Map<Jogador, Integer> map) {
		for (Entry<Jogador, Integer> jogadoresCartVermelho : map.entrySet()) {
			Jogador modeloJogador = jogadoresCartVermelho.getKey();
			int cartVermelhoReduzido = JogadorDAO.getQuantidadeCartVermelho(modeloJogador)
					- jogadoresCartVermelho.getValue();
			JogadorDAO.editarCartVermelho(modeloJogador, cartVermelhoReduzido);
		}
	}

	/** Metodo para distribuir os cartões Vermelho **/

	private static void distribuirCartaoVermelho(Map<Jogador, Integer> jogasMap, Partida partida, int numSelecao) {
		for (Entry<Jogador, Integer> jogadoresCartVermelho : jogasMap.entrySet()) {
			Jogador modeloJogador = jogadoresCartVermelho.getKey();
			int cartVermelho = modeloJogador.getCartaoVermelho() + jogadoresCartVermelho.getValue();
			JogadorDAO.editarCartVermelho(modeloJogador, cartVermelho);
		}
		if (numSelecao == 1) {
			partida.setCartaoVermelhoSelecao1(jogasMap);
		} else if (numSelecao == 2) {
			partida.setCartaoVermelhoSelecao2(jogasMap);
		}

	}

	/** Metodo para editar a lista de arbitros **/

	public static boolean editarArbitros(Arbitro arbitros, Partida partida) {
		if (!arbitros.equals(null)) {
			partida.setListaArbitro(arbitros);
			return true;
		}
		return false;
	}

	/** Metodo para excluir os dados **/

	public static boolean excluir(Partida partida) {
		if (listaPartidas.contains(partida)) {
			diminuirGols(partida.getGolsMarcadosSelecao1());
			diminuirGols(partida.getGolsMarcadosSelecao2());
			diminuirCartaoAmarelo(partida.getCartaoAmareloSelecao1());
			diminuirCartaoAmarelo(partida.getCartaoAmareloSelecao2());
			diminuirCartaoVermelho(partida.getCartaoVermelhoSelecao1());
			diminuirCartaoVermelho(partida.getCartaoVermelhoSelecao2());
			partida.getCartaoAmareloSelecao1().clear();
			partida.getCartaoVermelhoSelecao1().clear();
			partida.getGolsMarcadosSelecao1().clear();
			partida.getCartaoAmareloSelecao2().clear();
			partida.getCartaoVermelhoSelecao2().clear();
			partida.getGolsMarcadosSelecao2().clear();
			partida.setListaArbitro(null);
			if(partida.getFasePartida().equals("FaseDeGrupo"))
				GrupoPrimeiraFase.definirPontos(partida, false);
			partida.setStatus(false);
			return true;
		}
		return false;
	}

	/** Metodo para definir o resultado da partida **/

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

	/** Metodo para listar as partidas de um grupo **/
	public static void alteracaoDeStatusPartida(boolean statusPartida, Partida partida) {
		partida.setStatus(statusPartida);
	}

	/** Metodo para listar as partidas **/
	public static void listar() {
		if (listaPartidas.size() > 0) {
			System.out.println("Lista de Partidas:");
			System.out.println("=======================================");
			int contador = 1;
			for (Partida partida : listaPartidas) {
				System.out.println("[" + contador + "]- " + partida);
				contador++;
			}
		} else {
			System.out.println("Não Existe nenhuma partida feita.");
		}
	}

	/** Metodo para listar as partidas **/

	public static void listarPartidaGrupo(int inicio, int fim) {
		if (listaPartidas.size() > 0) {
			System.out.println("Lista de Partidas:");
			System.out.println("=======================================");
			System.out.println();
			int contador = 1;
			for (int i = inicio; i <= fim; i++) {
				System.out.println("[" + contador + "]- " + listaPartidas.get(i));
				contador++;
			}
			System.out.println();
		} else {
			System.out.println("Não Existe nenhuma partida feita.");
		}
	}

	/** Metodo para listar as partidas de um grupo **/

	public static void listarGrupo(String grupo) {
		if (grupo.equalsIgnoreCase("A")) {
			listarPartidaGrupo(0, 5);
		} else if (grupo.equalsIgnoreCase("B")) {
			listarPartidaGrupo(6, 11);
		} else if (grupo.equalsIgnoreCase("C")) {
			listarPartidaGrupo(12, 17);
		} else if (grupo.equalsIgnoreCase("D")) {
			listarPartidaGrupo(18, 23);
		} else if (grupo.equalsIgnoreCase("E")) {
			listarPartidaGrupo(24, 29);
		} else if (grupo.equalsIgnoreCase("F")) {
			listarPartidaGrupo(30, 35);
		} else if (grupo.equalsIgnoreCase("G")) {
			listarPartidaGrupo(36, 41);
		} else if (grupo.equalsIgnoreCase("H")) {
			listarPartidaGrupo(42, 47);
		} else {
			System.out.println("Grupo não encontrado.");
		}

	}

	/** Metodo para pegar uma partida no grupo **/

	public static Partida procurarPartida(String grupo, int numeroPartida) {
		if (grupo.equalsIgnoreCase("A")) {
			Partida partida = listaPartidas.get(0 + numeroPartida - 1);
			return partida;
		} else if (grupo.equalsIgnoreCase("B")) {
			Partida partida = listaPartidas.get(6 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("C")) {
			Partida partida = listaPartidas.get(12 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("D")) {
			Partida partida = listaPartidas.get(18 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("E")) {
			Partida partida = listaPartidas.get(24 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("F")) {
			Partida partida = listaPartidas.get(30 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("G")) {
			Partida partida = listaPartidas.get(36 + numeroPartida - 1);
			return partida;

		} else if (grupo.equalsIgnoreCase("H")) {
			Partida partida = listaPartidas.get(42 + numeroPartida - 1);
			return partida;

		} else {
			System.out.println("Grupo não encontrado.");
			return null;
		}

	}

	public static List<Partida> listaDePartidasGrupo(String grupo) {
		List<Partida> partidasLista = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			partidasLista.add(procurarPartida(grupo, i));
		}
		return partidasLista;
	}

	/** Metodo para ver quantidade de partidas sem ser realizada **/

	public static int quantidadePartidasNaoRealizada() {
		int contador = 0;
		for (Partida partida : listaPartidas) {
			if (partida.getStatus() == false) {
				contador++;
			}
		}
		return contador;
	}

	/** Metodo para ver quantidade de partidas que foi realizada **/

	public static int quantidadePartidasRealizada() {
		int contador = 0;
		for (Partida partida : listaPartidas) {
			if (partida.getStatus() == true) {
				contador++;
			}
		}
		return contador;
	}

	/** Metodo para pegar uma partida que foi realizada **/
	public static Partida partidaRealizadas() {
		for (Partida partida : listaPartidas) {
			if (partida.getStatus() == true) {
				return partida;
			}
		}
		return null;
	}

	/** Metodo para pegar uma partida que não foi realizada **/

	public static Partida partidaSemRealizar() {
		for (Partida partida : listaPartidas) {
			if (partida.getStatus() == false) {
				return partida;
			}
		}
		return null;
	}

	/** Metodo para encontrar uma partida **/
	public static Partida encontrar(int num) {
		return listaPartidas.get(num);

	}

	/** Metodo para atualizar o status da partida **/
	public static boolean statusAtuaisPartidas(Partida partida) {
		return partida.getStatus();
	}

	/** Metodo para resetar a lista **/
	public static void resetarLista() {
		listaPartidas.clear();
	}

	/** Metodo para encontrar uma partida **/
	public static List<Partida> getPartidaData(int dia, int mes) {
		List<Partida> lista = new ArrayList<Partida>();
		for (Partida partida : listaPartidas) {
			if ((partida.getDia().equals(dia) && partida.getMes().equals(mes)) && partida.getStatus()) {
				lista.add(partida);
			}
		}
		return lista;
	}

	public static Selecao GanhadorPartida(Partida partida) {
		return partida.getResultadoSelecao();
	}

	public static void DefinirGanhador(Selecao selecao, Partida partida) {
		if (!selecao.equals(null))
			partida.setGanhador(selecao);
	}

	public static void editorGols(Partida partida, int golSele1, int golSele2) {
		partida.setGolSelecao1(golSele1);
		partida.setGolSelecao2(golSele2);
	}

	public static int quantidaPartidas() {
		return listaPartidas.size();
	}

	public static void excluirTotalPartida(Partida partida) {
		listaPartidas.remove(partida);
	}

	public static void limparPartidas() {
		for (Partida partida : listaPartidas) {
			excluir(partida);
		}
	}

	public static List<Partida> listaPartidasRealizadas(int fase) {
		List<Partida> list = new ArrayList<>();
		if (fase == 1) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("FaseDeGrupo")) {
					list.add(partida);
				}
			}
		} else if (fase == 2) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("Oitavas")) {
					list.add(partida);
				}
			}

		}else if (fase == 3) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("Quartas")) {
					list.add(partida);
				}
			}

		}else if (fase == 4) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("Semi")) {
					list.add(partida);
				}
			}

		}else if (fase == 5) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("Terceiro Lugar")) {
					list.add(partida);
				}
			}

		}else if (fase == 6) {
			for (Partida partida : listaPartidas) {
				if (partida.getStatus() == true && partida.getFasePartida().equals("Final")) {
					list.add(partida);
				}
			}

		}
		return list;

	}
}
