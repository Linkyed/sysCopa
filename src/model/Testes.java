package model;



public class Testes {
	
	public static void main(String[] args) {
		
		Selecao sele = new Selecao("Brasil");

		SelecaoDAO.inserir(sele);
		Selecao sele1 = new Selecao("França");
		SelecaoDAO.inserir(sele1);


		Jogador jogas = new Jogador("João ALmeida", sele , 10);
		Jogador jogas1 = new Jogador("Nalbert Santos", sele , 12);
		Jogador jogas2 = new Jogador("Araujo Leste", sele , 11);
		Jogador jogas3 = new Jogador("Araujo Leste ", sele , 10);
		Jogador jogador = new Jogador("Nalbert Santos", sele, 25);

		JogadorDAO.inserir(jogas,sele);
		JogadorDAO.inserir(jogas1,sele);
		JogadorDAO.inserir(jogas2,sele);
		System.out.print( JogadorDAO.inserir(jogas3,sele));
		JogadorDAO.editar_Cart_Amarelo(jogas,1000);
		JogadorDAO.editar_Gol_Marcado(jogas, 5);
		JogadorDAO.editar_nome(jogas, jogador);
		

		JogadorDAO.listar();
	


		JogadorDAO.listar();
		SelecaoDAO.listar();
		
		System.out.println("============================================================================");

		
	
		
		}

}