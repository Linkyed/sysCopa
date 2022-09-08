package model;
public class Testes {
	
	public static void main(String[] args) {
		TecnicoDAO tecnicoDAO = new TecnicoDAO();
		Selecao a = new Selecao("brasil");
		Selecao b = new Selecao("Argentina");
		tecnicoDAO.inserir(new Tecnico("Jos", a));
		tecnicoDAO.inserir(new Tecnico("Vestapen", b));
		tecnicoDAO.listar();
		System.out.println("--------------");
		System.out.println("Exclusão: "+tecnicoDAO.excluir(new Tecnico("Jos", a)));
		System.out.println("--------------");
		tecnicoDAO.listar();
		System.out.println("--------------");
		System.out.println("Edição: "+tecnicoDAO.editar(tecnicoDAO.getOneTecnico(0), "João"));
		System.out.println("--------------");
		tecnicoDAO.listar();
		
		Jogador zezinho = new Jogador("joao", null, a);
		System.out.println(zezinho.setNome("Joao"));

	}
}
