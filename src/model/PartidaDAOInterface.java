package model;

import java.util.List;
import java.util.Map;


public interface PartidaDAOInterface {


	public static boolean inserir(Partida partida) {
	
		return false;
	}

	public static boolean editarAno(int ano) {
		
			return false;
		
	}

	public static boolean editarMes(int mes, Partida partida) {
		
			return false;
		
	}

	public static boolean editarDia(int dia, Partida partida) {
		
			return false;
		
	}

	public static boolean editarHorario(int hora, int minuto, Partida partida) {
		
		return false;
	}

	public static boolean editarLocal(String local, Partida partida) {
		
		return false;
	}

	public static boolean editarGol(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
		
		return false;

	}


	public static boolean editarCartAmarelo(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
	
		return false;
	}


	
	public static boolean editarCartVermelho(Partida partida, Map<Jogador, Integer> jogasMap, int numSelecao) {
		
		return false;
	}


	

	public static boolean editarArbitros(List<Arbitro> arbitros, Partida partida) {
		
		return false;
	}

	public static boolean excluir(Partida partida) {
		
		return false;
	}



	public static void alteracaoDeStatusPartida(boolean statusPartida, Partida partida) {
		
	}

	public static void listar() {
		
	}

	public static void listarPartidaGrupo(int inicio, int fim) {
		
	}

	public static void listarGrupo(String grupo) {
		

	}

	public static Partida procurarPartida(String grupo, int numeroPartida) {
		return null;
		

	}

	public static int quantidadePartidasNaoRealizada() {
		return 0;
		
	}
	
	public static int quantidadePartidasRealizada() {
		return 0;
		
	}
	
	public static Partida partidaRealizadas() {
		
		return null;
	}
	
	public static Partida partidaSemRealizar() {
		
		return null;
	}
	

	public static List<Partida> getPartidaData(int dia, int mes){
		return null;
		
	}
 
}
