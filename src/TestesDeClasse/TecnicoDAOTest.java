package TestesDeClasse;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Selecao;
import model.Tecnico;
import model.TecnicoDAO;

public class TecnicoDAOTest {
	Selecao selecao0 = new Selecao("Brasil");
	Selecao selecao1 = new Selecao("Russia");
	Selecao selecao2 = new Selecao("Japão");
	Selecao selecao3 = new Selecao("Romenia");
	
	Tecnico tecnico0 = new Tecnico("Josue", selecao0);
	Tecnico tecnico1 = new Tecnico("Matias", selecao1);
	Tecnico tecnico2 = new Tecnico("Camilo", selecao2);
	Tecnico tecnico3 = new Tecnico("Marco", selecao3);
	
	@Test
	public void inserirTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		TecnicoDAO.listar();
		assertEquals(tecnico0, TecnicoDAO.getOneTecnico(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void inserirMaximoTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		for (int i = 0; i< 32; i++) {
			TecnicoDAO.inserir(new Tecnico("a" + i, new Selecao("a" + i)));
		}
		assertFalse(TecnicoDAO.inserir(new Tecnico("ab", new Selecao("ab"))));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void editarNomeTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		TecnicoDAO.editar(tecnico0, "Jose");
		assertEquals("Jose", TecnicoDAO.getOneTecnico(0).getNome());
		TecnicoDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		assertTrue(TecnicoDAO.excluir(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void getOneTecnicoTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		assertEquals(tecnico0, TecnicoDAO.getOneTecnico(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void getTecnicoNomeTest() {
		TecnicoDAO.inserir(tecnico0);
		TecnicoDAO.inserir(tecnico1);
		TecnicoDAO.inserir(tecnico2);
		TecnicoDAO.inserir(tecnico3);
		assertEquals(TecnicoDAO.getTecnicoNome("Ma").size(), 2);
		TecnicoDAO.resetarLista();
	}
	

}
