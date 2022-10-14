package model;

public class Teste {

	public static void main(String[] args) {
		
		Selecao selecao1 = new Selecao("Qatar");
		Selecao selecao2 = new Selecao("Ecuador");
		Selecao selecao3 = new Selecao("Senegal");
		Selecao selecao4 = new Selecao("Holanda");
		Selecao selecao5 = new Selecao("Inglaterra");
		Selecao selecao6 = new Selecao("Irã");
		Selecao selecao7 = new Selecao("Estados Unidos");
		Selecao selecao8 = new Selecao("Pais de Gales");
		Selecao selecao9 = new Selecao("Argentina");
		Selecao selecao10 = new Selecao("Árabia Saudita");
		Selecao selecao11 = new Selecao("México");
		Selecao selecao12 = new Selecao("Polônia");
		Selecao selecao13 = new Selecao("França");
		Selecao selecao14 = new Selecao("Australia");
		Selecao selecao15 = new Selecao("Dinamarca");
		Selecao selecao16 = new Selecao("Tunísia");
		Selecao selecao17 = new Selecao("Espanha");
		Selecao selecao18 = new Selecao("Costa Rica");
		Selecao selecao19 = new Selecao("Alemanha");
		Selecao selecao20 = new Selecao("Japão");
		Selecao selecao21 = new Selecao("Bélgica");
		Selecao selecao22 = new Selecao("Canadá");
		Selecao selecao23 = new Selecao("Marrocos");
		Selecao selecao24 = new Selecao("Croácia");
		Selecao selecao25 = new Selecao("Brasil");
		Selecao selecao26 = new Selecao("Sérvia");
		Selecao selecao27 = new Selecao("Suíça");
		Selecao selecao28 = new Selecao("Camarões");
		Selecao selecao29 = new Selecao("Portugal");
		Selecao selecao30 = new Selecao("Gana");
		Selecao selecao31 = new Selecao("Uruguai");
		Selecao selecao32 = new Selecao("Coreia do Sul");
		
		GrupoPrimeiraFase.adicionarSelecao("A", selecao1);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao2);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao3);
		GrupoPrimeiraFase.adicionarSelecao("A", selecao4);
		
		GrupoPrimeiraFase.adicionarSelecao("B", selecao5);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao6);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao7);
		GrupoPrimeiraFase.adicionarSelecao("B", selecao8);
		
		GrupoPrimeiraFase.adicionarSelecao("C", selecao9);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao10);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao11);
		GrupoPrimeiraFase.adicionarSelecao("C", selecao12);
		
		GrupoPrimeiraFase.adicionarSelecao("D", selecao13);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao14);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao15);
		GrupoPrimeiraFase.adicionarSelecao("D", selecao16);
		
		GrupoPrimeiraFase.adicionarSelecao("E", selecao17);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao18);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao19);
		GrupoPrimeiraFase.adicionarSelecao("E", selecao20);
		
		GrupoPrimeiraFase.adicionarSelecao("F", selecao21);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao22);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao23);
		GrupoPrimeiraFase.adicionarSelecao("F", selecao24);
		
		GrupoPrimeiraFase.adicionarSelecao("G", selecao25);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao26);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao27);
		GrupoPrimeiraFase.adicionarSelecao("G", selecao28);
		
		GrupoPrimeiraFase.adicionarSelecao("H", selecao29);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao30);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao31);
		GrupoPrimeiraFase.adicionarSelecao("H", selecao32);
		
		GrupoPrimeiraFase.organizadorTodasPartidas();
		GrupoPrimeiraFase.listarTodosGrupos();
		
	}

}
