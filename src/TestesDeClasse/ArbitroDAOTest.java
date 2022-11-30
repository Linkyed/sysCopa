package TestesDeClasse;

import static org.junit.Assert.*;

import org.junit.Test;
import app.model.Arbitro;
import app.model.ArbitroDAO;

public class ArbitroDAOTest {

	Arbitro arbitro0 = new Arbitro("Jose");
	Arbitro arbitro1 = new Arbitro("Jose");
	Arbitro arbitro2 = new Arbitro("Lucas");
	Arbitro arbitro3 = new Arbitro("Mateus");
	@Test
	public void inserirTest() {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(ArbitroDAO.getOneArbitro(2), arbitro3);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void editarTest() {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		String novoNome = "Pericles";
		ArbitroDAO.editar(arbitro0, novoNome);
		assertEquals(arbitro0.getNome(), novoNome);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertTrue(ArbitroDAO.excluir(0));
		ArbitroDAO.resetarLista();
	}
	@Test
	public void getOneArbitroTest() {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(ArbitroDAO.getOneArbitro(2), arbitro3);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void getArbitroNomeTest() {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(1, ArbitroDAO.getArbitroNome("Jose").size());
		ArbitroDAO.resetarLista();
	}
}
