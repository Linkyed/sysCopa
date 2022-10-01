package model;

public class Testes {

	public static void main(String[] args) {

		Selecao sele = new Selecao("Brasil");

		SelecaoDAO.inserir(sele);
		Selecao sele1 = new Selecao("França");
		SelecaoDAO.inserir(sele1);
		
		int escolha = Funcoes.entradaInt("Escolha: ");
		System.out.println(escolha);
		System.out.println(escolha);
		escolha = Funcoes.entradaInt("Escolha: ");
	}
}