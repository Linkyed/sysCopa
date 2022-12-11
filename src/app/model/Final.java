package app.model;

import java.util.List;

public class Final {
	private static Partida terceiroLugarPartida = new Partida(null, null, 0);
	private static Partida grandeFinalPartida = new Partida(null, null, 0);
	
	public static void partidaGrandeFinal() {
		List<Selecao> partidaFinal = SemiFinal.ClassificadosSemi();
		Partida finalPartida = new Partida(partidaFinal.get(0), partidaFinal.get(1), 4);
		grandeFinalPartida = finalPartida;
		PartidaDAO.inserir(finalPartida);
		SelecaoDAO.adicionarPartidas(finalPartida, finalPartida.getSelecao1());
		SelecaoDAO.adicionarPartidas(finalPartida, finalPartida.getSelecao2());
	}
	
	public static void partidaTerceiroLugar() {
		List<Selecao> partidaTerceiroLugar = SemiFinal.NaoClassificadosSemi();
		Partida terceiroLugar = new Partida(partidaTerceiroLugar.get(0), partidaTerceiroLugar.get(1), 5);
		terceiroLugarPartida = terceiroLugar;
		PartidaDAO.inserir(terceiroLugarPartida);
		SelecaoDAO.adicionarPartidas(terceiroLugarPartida, terceiroLugarPartida.getSelecao1());
		SelecaoDAO.adicionarPartidas(terceiroLugarPartida, terceiroLugarPartida.getSelecao2());
	}
	
	
	public static void campeaoDelMundo() {
		System.out.println("Campeão do Mundo: "+ grandeFinalPartida.getResultadoSelecao());
	}
	
	public static Partida partidaTerceiro() {
		return terceiroLugarPartida;
	}
	
	public static Partida partidaFinal() {
		return grandeFinalPartida;
	}
	
	public static Selecao CampeaoMundo() {
		return grandeFinalPartida.getResultadoSelecao();
	}

	
}
