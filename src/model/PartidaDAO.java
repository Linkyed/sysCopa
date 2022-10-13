package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class PartidaDAO {
	private static List<Partida> listaPartidas = new ArrayList<>();

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
				int cartAmarelo = jogadoresCartAmarelo.getValue()+ JogadorDAO.getQuantidadeCartAmarelo(modeloJogador);
				JogadorDAO.editarCartAmarelo(modeloJogador, cartAmarelo);
			}
			
			for (Entry<Jogador, Integer> jogadoresCartVermelho : partida.getCartaoAmareloPartida().entrySet()) {
				Jogador modeloJogador = jogadoresCartVermelho.getKey();
				int cartVermelho = jogadoresCartVermelho.getValue()+ JogadorDAO.getQuantidadeCartVermelho(modeloJogador);
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
		if(listaPartidas.contains(partida)) {
			
			listaPartidas.remove(partida);
			return true;
		}
		return false;
	}
	
	public static void listar() {
		if(listaPartidas.size() > 0) {
			System.out.println("Lista de Partidas:");
			System.out.println("=======================================");
			for(Partida partida: listaPartidas){
				System.out.println(partida);
			}
		}
		else {
			System.out.println("N�o Existe nenhuma partida feita.");
		}
	}
}
