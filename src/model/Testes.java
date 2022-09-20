package model;
public class Testes {
	
	public static void main(String[] args) {

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

	}
}
