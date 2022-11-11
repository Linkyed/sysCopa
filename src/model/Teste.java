package model;

import java.util.HashMap;
import java.util.Map;
import application.*;
import application.MainArbitro;
import application.Menu;

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
		/*
		SelecaoDAO.listar();
		PartidaDAO.listar();
		//GrupoPrimeiraFase.listarTodosGrupos();
		PartidaDAO.listaPartidas.get(36).setGolSelecao1(2);
		PartidaDAO.listaPartidas.get(36).setGolSelecao2(0);
		PartidaDAO.alteracaoDeStatusPartida(true, PartidaDAO.listaPartidas.get(36));
		GrupoPrimeiraFase.definirPontos(PartidaDAO.listaPartidas.get(36),true);
		PartidaDAO.listaPartidas.get(37).setGolSelecao1(4);
		PartidaDAO.listaPartidas.get(37).setGolSelecao2(3);
		PartidaDAO.alteracaoDeStatusPartida(true, PartidaDAO.listaPartidas.get(37));
		GrupoPrimeiraFase.definirPontos(PartidaDAO.listaPartidas.get(37),true);
		PartidaDAO.listaPartidas.get(38).setGolSelecao1(8);
		PartidaDAO.listaPartidas.get(38).setGolSelecao2(1);
		PartidaDAO.alteracaoDeStatusPartida(true, PartidaDAO.listaPartidas.get(38));
		GrupoPrimeiraFase.definirPontos(PartidaDAO.listaPartidas.get(38),true);
		
		System.out.println(PartidaDAO.listaPartidas.get(36));
		
		SelecaoDAO.inserir(selecao25);
		SelecaoDAO.inserir(selecao26);
		Jogador jogador = new Jogador("Matias Raiten", selecao25,1);
		JogadorDAO.inserir(jogador, selecao25, false);
		Jogador jogador1 = new Jogador("Matias Binnotom", selecao25,1);
		JogadorDAO.inserir(jogador1, selecao25, false);
		Jogador jogador2 = new Jogador("Matias Binnotok", selecao25,1);
		JogadorDAO.inserir(jogador2, selecao25, false);
		Jogador jogador3 = new Jogador("Matias Binnotol", selecao25,1);
		JogadorDAO.inserir(jogador3, selecao25, false);
		Jogador jogador4 = new Jogador("Matias Binnotoo", selecao25,1);
		JogadorDAO.inserir(jogador4, selecao25, false);
		Jogador jogador5 = new Jogador("Matias Binnotoi", selecao25,1);
		JogadorDAO.inserir(jogador5, selecao25,false);
		Jogador jogador6 = new Jogador("Matias Binnotop", selecao25,1);
		JogadorDAO.inserir(jogador6, selecao25, false);
		Jogador jogador7 = new Jogador("Matias Binnotoy", selecao25,1);
		JogadorDAO.inserir(jogador7, selecao25, false);
		Jogador jogador8 = new Jogador("Matias Binnotou", selecao25,1);
		JogadorDAO.inserir(jogador8, selecao25, false);
		Jogador jogador9 = new Jogador("Matias Binnotoj", selecao25,1);
		JogadorDAO.inserir(jogador9, selecao25, false);
		Jogador jogador10 = new Jogador("Matias Binnotoz", selecao25,1);
		JogadorDAO.inserir(jogador10, selecao26, false);
		PartidaDAO.alteracaoDeStatusPartida(true, PartidaDAO.listaPartidas.get(36));
	
		GrupoPrimeiraFase.listaGrupoString("G");
		System.out.println("Gols"+ jogador.getGolmarcado());
		System.out.println(PartidaDAO.listaPartidas.get(36).getGolSelecao1());
		GrupoPrimeiraFase.listaGrupoString("G");
		
		System.out.println(PartidaDAO.listaPartidas.get(36).getGolSelecao1());
		
		Tecnico tecnico = new Tecnico("jose lucas", selecao1);
		TecnicoDAO.inserir(tecnico);
		Tecnico tecnico1 = new Tecnico("jose joão", selecao3);
		TecnicoDAO.inserir(tecnico1);
		Arbitro arbitro = new Arbitro("Josias Malafaia");
		ArbitroDAO.inserir(arbitro);
		
		
		
		

		Map<Jogador, Integer> jogasMap = new HashMap<Jogador, Integer>();
		jogasMap.put(jogador3, 2);
		jogasMap.put(jogador2, 2);
		Map<Jogador, Integer> jogasMap1 = new HashMap<Jogador, Integer>();
		jogasMap1.put(jogador10, 9);
		jogasMap1.put(jogador1, 2);
		PartidaDAO.editarGol(PartidaDAO.listaPartidas.get(36),jogasMap,1);
		SelecaoDAO.listarJogadors();
		PartidaDAO.editarGol(PartidaDAO.listaPartidas.get(36),jogasMap1,1);

		SelecaoDAO.listarJogadors();
		
		//MainArbitro.inserirArbitro();
		//MainArbitro.editarArbitro();
		//MainArbitro.excluirArbitro();
		//System.out.println(Pesquisa.buscarSelecao());
		

		
		
		//ArbitroDAO.listar();
		GrupoPrimeiraFase.listaGrupoString("G");
		GrupoPrimeiraFase.listaGrupoString("G");
		System.out.println("Gols "+ jogador.getGolmarcado());*/
		PartidaDAO.alteracaoDeStatusPartida(true, PartidaDAO.listaPartidas.get(0));
		System.out.println(Pesquisa.buscarPartida());
		
	}

}
