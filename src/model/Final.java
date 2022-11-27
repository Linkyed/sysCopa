package model;

import java.util.List;

public class Final {
	private static Partida grandeFinalPartida = new Partida(null, null, 0);
	
	public static void partidaGrandeFinal() {
		List<Selecao> partidaFinal = SemiFinal.ClassificadosSemi();
		Partida finalPartida = new Partida(partidaFinal.get(0), partidaFinal.get(1), 4);
		grandeFinalPartida = finalPartida;
		PartidaDAO.inserir(finalPartida);
	}
	
	public static void partidaFinal() {
		System.out.println("Quartas de Final: "+ grandeFinalPartida.getGolSelecao1() +" "+grandeFinalPartida+" " +grandeFinalPartida.getGolSelecao2());
	}
	
	public static void campeaoDelMundo() {
		System.out.println("Campeão do Mundo: "+ grandeFinalPartida.getResultadoSelecao());
	}
	public static Selecao CampeaoMundo() {
		return grandeFinalPartida.getResultadoSelecao();
	}
	
}
