package TestesDeClasse;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import model.*;
public class PartidaDAOTest {

	@Test
	public void testInserir() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.inserir(partida);
		assertEquals(partida, PartidaDAO.encontrar(0));
		PartidaDAO.resetarLista();
	}
	
	@Test
	public void testAno() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.editarAno(2018);
		assertEquals(partida.getAno(), 2018, 0);
	}
	
	@Test
	public void testMes() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.editarMes(12,partida);
		assertEquals(partida.getMes(), 12, 0);
		PartidaDAO.resetarLista();
	}
	
	@Test
	public void testDia() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.editarMes(12,partida);
		PartidaDAO.editarDia(31,partida);
		assertEquals(partida.getDia(), 31, 0);
		PartidaDAO.editarMes(2,partida);
		PartidaDAO.editarDia(30,partida);
		assertNotEquals(partida.getDia(), 30, 0);
		
	}
	
	@Test
	public void testHorario() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.editarHorario(12, 59, partida);
		assertEquals(partida.getHorario(), 12, 0);
		assertEquals(partida.getHorarioM(), 59, 0);
		PartidaDAO.editarHorario(30, 70, partida);
		assertNotEquals(partida.getHorario(), 30, 0);
		assertNotEquals(partida.getHorarioM(), 70, 0);
	}
	
	@Test
	public void testLocal() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		PartidaDAO.editarLocal("Feira de Santana", partida);
		assertEquals(partida.getLocal(),"Feira de Santana");
	}
	

	@Test
	public void testGol() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		Map<Jogador, Integer> jogasMap1 = new HashMap<>();
		Map<Jogador, Integer> jogasMap2 = new HashMap<>();
		Jogador jogador1 = new Jogador("Nasus");
		Jogador jogador3 = new Jogador("AaTrox"); 
		Jogador jogador2 = new Jogador("Galio"); 
		jogasMap1.put(jogador2, 1);
		jogasMap1.put(jogador1, 1);
		jogasMap2.put(jogador3, 3);
		PartidaDAO.editarGol(partida, jogasMap1, 1);
		PartidaDAO.editarGol(partida, jogasMap2, 2);
		assertEquals(partida.getGolSelecao1(),2);
		assertEquals(partida.getGolSelecao2(),3);
	}
	
	@Test
	public void testCartAmarelo() {
		Map<Jogador, Integer> jogasMap2 = new HashMap<>();
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		Partida partida = new Partida(selecao1, selecao2);
		Jogador jogador3 = new Jogador("AaTrox"); 
		jogasMap2.put(jogador3, 3);
		JogadorDAO.inserir(jogador3, selecao2, false);
		PartidaDAO.editarCartAmarelo(partida, jogasMap2, 2);
		assertEquals(jogador3.getCartaoAmarelo(),3,0);
		SelecaoDAO.resetarLista();
		JogadorDAO.resetarLista();
	}
	
	@Test
	public void testCartVermelho() {
		Map<Jogador, Integer> jogasMap2 = new HashMap<>();
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		SelecaoDAO.inserir(selecao1);
		SelecaoDAO.inserir(selecao2);
		Partida partida = new Partida(selecao1, selecao2);
		Jogador jogador3 = new Jogador("AaTrox"); 
		jogasMap2.put(jogador3, 6);
		JogadorDAO.inserir(jogador3, selecao2, false);
		PartidaDAO.editarCartVermelho(partida, jogasMap2, 2);
		assertEquals(jogador3.getCartaoVermelho(),6,0);
		SelecaoDAO.resetarLista();
		JogadorDAO.resetarLista();
	}
	
	@Test
	public void testExcuir() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		Map<Jogador, Integer> jogasMap1 = new HashMap<>();
		Map<Jogador, Integer> jogasMap2 = new HashMap<>();
		Jogador jogador1 = new Jogador("Nasus");
		Jogador jogador3 = new Jogador("AaTrox"); 
		Jogador jogador2 = new Jogador("Galio"); 
		jogasMap1.put(jogador2, 1);
		jogasMap1.put(jogador1, 1);
		jogasMap2.put(jogador3, 3);
		PartidaDAO.editarGol(partida, jogasMap1, 1);
		PartidaDAO.editarGol(partida, jogasMap2, 2);
		PartidaDAO.inserir(partida);
		PartidaDAO.excluir(partida);
		assertEquals(jogador1.getGolmarcado(),0);
		assertEquals(jogador2.getGolmarcado(),0);
		assertEquals(partida.getStatus(), false);
		PartidaDAO.resetarLista();
	}
	
	@Test
	public void testResultado() {
		Selecao selecao1 = new Selecao("Brasil");
		Selecao selecao2 = new Selecao("Argentina");
		Partida partida = new Partida(selecao1, selecao2);
		partida.setGolSelecao1(3);
		partida.setGolSelecao1(0);
		Selecao selecao = PartidaDAO.resultadoPartida(partida).get(0);
		assertEquals(selecao, selecao1);
	}
	
	
	

}
