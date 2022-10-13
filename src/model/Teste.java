package model;

public class Teste {

	public static void main(String[] args) {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Alemanha");
		Selecao selecao3 = new Selecao("França");
		Partida partida = new Partida(0, 0, null, null, selecao1, selecao2);
		Partida partida2 = new Partida(0, 0, null, null, selecao1, selecao3);
		PartidaDAO.inserir(partida);
		PartidaDAO.inserir(partida2);
		PartidaDAO.listar();

	}

}
