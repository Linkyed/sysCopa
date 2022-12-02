package TestesDeClasse;

import static org.junit.Assert.*;

import org.junit.Test;

import app.model.Selecao;
import app.model.Tecnico;
import app.model.TecnicoDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

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
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		TecnicoDAO.listar();
		assertEquals(tecnico0, TecnicoDAO.getOneTecnico(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void inserirMaximoTest() {
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		for (int i = 0; i< 32; i++) {
			TecnicoDAO.inserirConsole(new Tecnico("a" + i, new Selecao("a" + i)));
		}
		assertFalse(TecnicoDAO.inserirConsole(new Tecnico("ab", new Selecao("ab"))));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void editarNomeTest() throws StringVaziaException, CaracterInvalidoException, ObjetoNaoExisteException, ObjetoJaExisteException {
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		TecnicoDAO.editar(tecnico0, "Jose");
		assertEquals("Jose", TecnicoDAO.getOneTecnico(0).getNome());
		TecnicoDAO.resetarLista();
	}
	@Test
	public void editarSelecaoTest() {
		Selecao selecao = new Selecao("A");
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		TecnicoDAO.editar(tecnico0, selecao);
		assertEquals(tecnico0, selecao.getTecnico());
		TecnicoDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		assertTrue(TecnicoDAO.excluir(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void getOneTecnicoTest() {
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		assertEquals(tecnico0, TecnicoDAO.getOneTecnico(0));
		TecnicoDAO.resetarLista();
	}
	@Test
	public void getTecnicoNomeTest() {
		TecnicoDAO.inserirConsole(tecnico0);
		TecnicoDAO.inserirConsole(tecnico1);
		TecnicoDAO.inserirConsole(tecnico2);
		TecnicoDAO.inserirConsole(tecnico3);
		assertEquals(TecnicoDAO.getTecnicoNome("Ma").size(), 2);
		TecnicoDAO.resetarLista();
	}
	

}
