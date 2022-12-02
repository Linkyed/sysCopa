package TestesDeClasse;

import static org.junit.Assert.*;

import org.junit.Test;

import app.model.Selecao;
import app.model.SelecaoDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

public class SelecaoDAOTest {

	Selecao selecao0 = new Selecao("Brasil");
	Selecao selecao1 = new Selecao("Russia");
	Selecao selecao2 = new Selecao("Japão");
	Selecao selecao3 = new Selecao("Romenia");
	
	@Test
	public void inserirTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertEquals(selecao0, SelecaoDAO.getOneSelecao(0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void inserirMaximoTest() {
		for (int i = 0; i< 32; i++) {
			SelecaoDAO.inserirConsole(new Selecao("a" + i));
		}
		assertFalse(SelecaoDAO.inserirConsole(new Selecao("Marco")));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void editarTest() throws ObjetoJaExisteException, ObjetoNaoExisteException, CaracterInvalidoException, StringVaziaException {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		SelecaoDAO.editar(selecao2, "Marrocos");
		assertEquals(selecao2.getNome(), "Marrocos");
		SelecaoDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertTrue(SelecaoDAO.excluir(0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void getOneSelecaoTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertEquals(SelecaoDAO.getOneSelecao(0), selecao0);
		SelecaoDAO.resetarLista();
	}
	@Test
	public void existeSelecaoTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertTrue(SelecaoDAO.existeSelecao(selecao0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void getSelecaoPorSelecaoTest() throws ObjetoNaoExisteException {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertEquals(SelecaoDAO.getSelecaoPorSelecao(selecao0), selecao0);
		SelecaoDAO.resetarLista();
	}
	@Test
	public void selecoesSemTecnicoTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		SelecaoDAO.listar();
		assertEquals(4, SelecaoDAO.selecoesSemTecnico());
		SelecaoDAO.resetarLista();
	}
	
	@Test
	public void getSelecaoNomeTest() {
		SelecaoDAO.inserirConsole(selecao0);
		SelecaoDAO.inserirConsole(selecao1);
		SelecaoDAO.inserirConsole(selecao2);
		SelecaoDAO.inserirConsole(selecao3);
		assertEquals(SelecaoDAO.getSelecaoNome("Brasil").size(), 1);
		SelecaoDAO.resetarLista();
	}
	


}
