package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelecaoDAOTest {

	Selecao selecao0 = new Selecao("Brasil");
	Selecao selecao1 = new Selecao("Russia");
	Selecao selecao2 = new Selecao("Japão");
	Selecao selecao3 = new Selecao("Romenia");
	
	@Test
	public void inserirTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertEquals(selecao0, SelecaoDAO.getOneSelecao(0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void inserirMaximoTest() {
		for (int i = 0; i< 32; i++) {
			SelecaoDAO.inserir(new Selecao("a" + i));
		}
		assertFalse(SelecaoDAO.inserir(new Selecao("Marco")));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void editarTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		SelecaoDAO.editar(selecao2, "Marrocos");
		assertEquals(selecao2.getNome(), "Marrocos");
		SelecaoDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertTrue(SelecaoDAO.excluir(0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void getOneSelecaoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertEquals(SelecaoDAO.getOneSelecao(0), selecao0);
		SelecaoDAO.resetarLista();
	}
	@Test
	public void existeSelecaoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertTrue(SelecaoDAO.existeSelecao(selecao0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void getSelecaoPorSelecaoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertEquals(SelecaoDAO.getSelecaoPorSelecao(selecao0), selecao0);
		SelecaoDAO.resetarLista();
	}
	@Test
	public void selecoesSemTecnicoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		SelecaoDAO.listar();
		assertEquals(4, SelecaoDAO.selecoesSemTecnico());
		SelecaoDAO.resetarLista();
	}
	@Test
	public void editarGolsSelecaoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		SelecaoDAO.editarGolsSelecao(selecao0, 3);
		assertEquals(3, SelecaoDAO.getQuantidadeGols(selecao0));
		SelecaoDAO.resetarLista();
	}
	@Test
	public void getSelecaoNomeTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		assertEquals(SelecaoDAO.getSelecaoNome("Brasil").size(), 1);
		SelecaoDAO.resetarLista();
	}
	


}
