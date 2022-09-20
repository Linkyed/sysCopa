package model;

import java.util.List;

public class JogadorDAO {

	private List<Jogador> todos_Jogadores = BancoDeDados.getTodos_Jogadores() ;
	private List<Selecao> todas_Selecao = BancoDeDados.getSelecoes();

	boolean inserir(Jogador jogador,Selecao selecao) {
		if(todas_Selecao.contains(selecao)==true) {
			int posicao_lista = todas_Selecao.indexOf(selecao);
			todas_Selecao.get(posicao_lista).addJogador(jogador);
			todos_Jogadores.add(jogador);
			return true;

		}
		return false;
	}
	
	boolean editar_nome(Jogador jogador, String nome) {
		if(todos_Jogadores.contains(jogador)) {
			jogador.setNome(nome);
			return true;
		}
		return false;
		
	}
	
	boolean editar_Cart_Amarelo(Jogador jogador, int cartao_amarelo) {
		if(todos_Jogadores.contains(jogador)) {
			jogador.setCartaoAmarelo(cartao_amarelo);
			return true;
		}
		return false;
	}
	
	boolean editar_Cart_Vermelho(Jogador jogador, int cartao_vermelho) {
		if(todos_Jogadores.contains(jogador)) {
			jogador.setCartaoVermelho(cartao_vermelho);
			return true;
		}
		return false;
		
	}
	
	boolean editar_Gol_Marcado(Jogador jogador, int gol_Marcado) {
		if(todos_Jogadores.contains(jogador)) {
			jogador.setGolmarcado(gol_Marcado);
			return true;
		}
		return false;
		}
	boolean excluir(Jogador jogador) {
		if(todos_Jogadores.contains(jogador)) {
			todos_Jogadores.remove(jogador);
			return true;
		}
		else {
			return false;
		}
	}
	boolean listar() {
		
		if(todos_Jogadores.isEmpty()) {
			System.out.println("N�o existe nenhum jogador cadastrado.");
			return false;
		}
		else {
			System.out.println("Lista de Todos os Jogadores");
			System.out.println("=================================");
			for(Jogador jogador: todos_Jogadores) {
				System.out.println(jogador);
			}
		return true;}
	}
}
