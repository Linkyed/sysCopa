package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogadorDAOTest {
	Selecao selecao0 = new Selecao("Brasil");
	Selecao selecao1 = new Selecao("Russia");
	Selecao selecao2 = new Selecao("Jap�o");
	Selecao selecao3 = new Selecao("Romenia");
	
	Jogador jogador0 = new Jogador("Josue", selecao0, 1);
	Jogador jogador1 = new Jogador("Pedro", selecao1, 1);
	Jogador jogador2 = new Jogador("Lucas", selecao2, 1);
	Jogador jogador3 = new Jogador("Mateus", selecao3, 1);
	
	
	@Test
	public void inserirTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		assertEquals(jogador0, JogadorDAO.getOneJogador(0));
		JogadorDAO.resetarLista();
	}
	@Test
	public void inserirMaximoTest() {
		SelecaoDAO.inserir(selecao0);
		for (int i = 0; i < 11; i++) {
			JogadorDAO.inserir(new Jogador("a" + i, selecao0, 1), selecao0, false);
		}
		JogadorDAO.listar();
		assertFalse(JogadorDAO.inserir(new Jogador("ab", selecao0, 1), selecao0, false));
		JogadorDAO.resetarLista();
	}
	@Test
	public void editarNomeTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.editarNome(0, "Novonome");
		JogadorDAO.listar();
		assertEquals("Novonome", JogadorDAO.getOneJogador(0).getNome());
		JogadorDAO.resetarLista();
	}
	@Test
	public void editarCartATest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.editarCartAmarelo(0, 3);
		assertEquals(JogadorDAO.getOneJogador(0).getCartaoAmarelo(), 3);
		JogadorDAO.resetarLista();
	}
	@Test
	public void editarCartVTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.editarCartVermelho(0, 3);
		assertEquals(JogadorDAO.getOneJogador(0).getCartaoVermelho(), 3);
		JogadorDAO.resetarLista();
	}
	@Test
	public void editarGolMarcadoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.editarGolMarcado(0, 3);
		assertEquals(JogadorDAO.getOneJogador(0).getGolmarcado(), 3);
		JogadorDAO.resetarLista();
	}
	@Test
	public void editarPosicaoTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.editarPosicao(0, 2);
		assertEquals(JogadorDAO.getOneJogador(0).getPosicaoJogada(), "Lateral esquerdo");
		JogadorDAO.resetarLista();
	}
	@Test
	public void excluirTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		assertTrue(JogadorDAO.excluir(0));
		JogadorDAO.resetarLista();
	}
	@Test
	public void excluirJogadorParcialTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.getOneJogador(0).getSelecao().getJogadores().clear();
		assertTrue(JogadorDAO.excluirJogadorParcial(jogador0));
		JogadorDAO.resetarLista();
	}
	@Test
	public void estaNaListaTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.listar();
		assertTrue(JogadorDAO.estaNaLista(jogador0));
		JogadorDAO.resetarLista();
	}
	@Test
	public void getNomeJogadorTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.listar();
		assertEquals(JogadorDAO.getJogadorNome("Josue").size(), 1);
		JogadorDAO.resetarLista();
	}
	@Test
	public void getOneJogadorTest() {
		SelecaoDAO.inserir(selecao0);
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		SelecaoDAO.inserir(selecao3);
		JogadorDAO.inserir(jogador0, selecao0, false);
		JogadorDAO.inserir(jogador1, selecao1, false);
		JogadorDAO.inserir(jogador2, selecao2, false);
		JogadorDAO.inserir(jogador3, selecao3, false);
		JogadorDAO.listar();
		assertEquals(JogadorDAO.getOneJogador(0), jogador0);
		JogadorDAO.resetarLista();
	}
}
