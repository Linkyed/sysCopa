package TestesDeClasse;

import static org.junit.Assert.*;

import org.junit.Test;
import app.model.Arbitro;
import app.model.ArbitroDAO;
import app.model.exceptions.CaracterInvalidoException;
import app.model.exceptions.ObjetoJaExisteException;
import app.model.exceptions.ObjetoNaoExisteException;
import app.model.exceptions.StringVaziaException;

public class ArbitroDAOTest {

	Arbitro arbitro0 = new Arbitro("Jose");
	Arbitro arbitro1 = new Arbitro("Jose");
	Arbitro arbitro2 = new Arbitro("Lucas");
	Arbitro arbitro3 = new Arbitro("Mateus");
	@Test
	public void inserirTest() throws StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(ArbitroDAO.getOneArbitro(2), arbitro3);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void editarTest() throws StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException, ObjetoNaoExisteException {
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
	public void excluirTest() throws ObjetoNaoExisteException, StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		ArbitroDAO.excluir("Jose");
		assertEquals(ArbitroDAO.quantidadeArbitro(), 3);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void getOneArbitroTest() throws StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(ArbitroDAO.getOneArbitro(2), arbitro3);
		ArbitroDAO.resetarLista();
	}
	@Test
	public void getArbitroNomeTest() throws StringVaziaException, CaracterInvalidoException, ObjetoJaExisteException {
		ArbitroDAO.inserir(arbitro0);
		ArbitroDAO.inserir(arbitro1);
		ArbitroDAO.inserir(arbitro2);
		ArbitroDAO.inserir(arbitro3);
		assertEquals(1, ArbitroDAO.getArbitroNome("Jose").size());
		ArbitroDAO.resetarLista();
	}
}
