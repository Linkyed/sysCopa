package model;

import java.util.Iterator;

public class Testes {
	
	public static void main(String[] args) {
		/*
		//TESTE DE SELEÇÃO
		SelecaoDAO selecaoDAO = new SelecaoDAO();
		System.out.println("--------------");
		System.out.println("Inserção: "+selecaoDAO.inserir(new Selecao("BRASIL")));
		System.out.println("Inserção: "+selecaoDAO.inserir(new Selecao("ARGENTINA")));
		System.out.println("Inserção: "+selecaoDAO.inserir(new Selecao("PARAGUAI")));
		System.out.println("--------------");
		selecaoDAO.listar();
		System.out.println("--------------");
		System.out.println("Edição: "+selecaoDAO.editar(selecaoDAO.getOneSelecao(0), "COLOMBIA"));
		//TESTAR A ALTERAÇÃO DE JOGADORES QUANDO TIVER O CODJOG
		System.out.println("--------------");
		selecaoDAO.listar();
		System.out.println("--------------");
		System.out.println("Exclusão: "+selecaoDAO.excluir(1));
		System.out.println("--------------");
		selecaoDAO.listar();
		
		//TESTE DO TECNICO
		TecnicoDAO tecnicoDAO = new TecnicoDAO();
		tecnicoDAO.inserir(new Tecnico("Jos", selecaoDAO.getOneSelecao(0)));
		tecnicoDAO.inserir(new Tecnico("Vestapen", selecaoDAO.getOneSelecao(1)));
		tecnicoDAO.listar();
		System.out.println("--------------");
		System.out.println("Exclusão: "+tecnicoDAO.excluir(1));
		System.out.println("--------------");
		tecnicoDAO.listar();
		System.out.println("--------------");
		System.out.println("Edição: "+tecnicoDAO.editar(tecnicoDAO.getOneTecnico(0), "João"));
		System.out.println("--------------");
		tecnicoDAO.listar();
		
		//TESTE DO ARBITRO
		ArbitroDAO arbitroDAO = new ArbitroDAO();
		System.out.println("--------------");
		System.out.println("Inserção: "+arbitroDAO.inserir(new Arbitro("Josias")));
		System.out.println("Inserção: "+arbitroDAO.inserir(new Arbitro("Rafael")));
		System.out.println("--------------");
		arbitroDAO.listar();
		System.out.println("--------------");
		System.out.println("Edição: "+arbitroDAO.editar(arbitroDAO.getOneArbitro(0), "João"));
		System.out.println("--------------");
		arbitroDAO.listar();
		System.out.println("--------------");
		System.out.println("Exclusão: "+arbitroDAO.excluir(0));
		System.out.println("--------------");
		arbitroDAO.listar();
		
		Jogador jogador = new Jogador("JOSE RIBEIRO DA SILVA", selecaoDAO.getOneSelecao(0), 27);
		Jogador jogador2 = new Jogador("JOÂO RIBEIRO DE JESUS", selecaoDAO.getOneSelecao(0), 18);
		System.out.println(jogador.getCodJog());
		System.out.println(jogador2.getCodJog());

		JogadorDAO jogadorDAO = new JogadorDAO();
		System.out.println("--------------");*/
		
		SelecaoDAO selecaoDAO = new SelecaoDAO();
		JogadorDAO jogadorDAO = new JogadorDAO();
		Selecao sele = new Selecao("Brasil");

		selecaoDAO.inserir(sele);
		Selecao sele1 = new Selecao("Brasil");

		
		Jogador jogas = new Jogador("Jo�o ALmeida", sele , 10);
		Jogador jogas1 = new Jogador("Nalbert Santos", sele , 12);
		Jogador jogas6 = new Jogador("Nalbert Santos", sele , 12);
		Jogador jogas2 = new Jogador("Araujo Leste", sele , 11);
		Jogador jogas3 = new Jogador("Araujo Leste ", sele1 , 10);
		
		
		

		jogadorDAO.inserir(jogas,sele1);
		jogadorDAO.inserir(jogas6,sele1);
		jogadorDAO.inserir(jogas1,sele1);
		jogadorDAO.inserir(jogas2,sele1);
		jogadorDAO.inserir(jogas3,sele1);
		
		jogadorDAO.listar();
		jogadorDAO.excluir(jogas3);
	
		jogadorDAO.listar();
		selecaoDAO.listar();

		System.out.println("============================================================================");
		for(Selecao s: BancoDeDados.getSelecoes() ) {
			for(Jogador j: s.getJogadores()) {
				System.out.println(j);
			}
		}
	}
}
