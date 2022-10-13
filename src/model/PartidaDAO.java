package model;

import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {
	private static List<Partida> listaPartidas = new ArrayList<>();

	public static boolean inserir(Partida partida) {
		if (!listaPartidas.contains(partida)) {
			listaPartidas.add(partida);
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
			System.out.println("Não Existe nenhuma partida feita.");
		}
	}
}
