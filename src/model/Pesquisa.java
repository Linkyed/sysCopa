package model;

import java.util.List;

public class Pesquisa {

	static public String buscarSelecao() {
		String nomeBusca = Funcoes.entradaString("Digite o nome da seleção que deseja procurar no banco de dados: ", true);
		List<Selecao> listaBuscada = SelecaoDAO.getSelecaoNome(nomeBusca);
		int selecaoEscolhida = 0;
		if (listaBuscada.size() == 0) {
			return "\nNenhuma seleção com este nome foi encontrada, tente outro nome!\n";
		} else if (listaBuscada.size() > 1) {
			System.out.println();
			for (Selecao selecao: listaBuscada) {
				System.out.println("[" + listaBuscada.indexOf(selecao) + "] " + selecao.getNome());
			}
			selecaoEscolhida = Funcoes.entradaIntRanger("Foram achadas essas seleções que possuem o nome " + nomeBusca + "nelas, digite o numero para escolher uma delas: ", 
					0, listaBuscada.size()-1);
		}
		Selecao selecaoBuscada = listaBuscada.get(selecaoEscolhida);
		String jogadores = "";
		String nomeTecnico = "";
		for(Jogador jogador: selecaoBuscada.getJogadores()) {
			jogadores += jogador.getNome() + "\n";
		}
	
		if (selecaoBuscada.getTecnico() == null) {
			 nomeTecnico = "Nenhum";
		} else {
			nomeTecnico = selecaoBuscada.getTecnico().getNome();
		}
		
		return "\nA seleção " + selecaoBuscada + " foi encontrada e essas são suas informações:" +
		"\nNome: " + selecaoBuscada.getNome() + 
		"\nTecnico: " + nomeTecnico +
		"\nJogadores: " + jogadores +
		"\nPartidas: ";
	}
	
	public static String buscarPessoa() {
		int escolha = Funcoes.entradaIntRanger("[1] Tecnico\n[2] Arbitro\n[3] Jogador\nDigite o numero relacionado uma opção acima para fazer sua busca: ", 1, 3);
		String nome = "";
		if (escolha == 1) {
			nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome de um tecnico para ser buscado no banco de dados: ", true));
			return buscarTecnico(nome);
		} else if (escolha == 2) {
			nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome de um arbitro para ser buscado no banco de dados: ", true));
			return buscarArbitro(nome);
		} else{ 
			nome = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome de um jogador para ser buscado no banco de dados: ", true));
			return buscarJogador(nome);
		}
	}
	
	private static String buscarTecnico(String nome) {
		Tecnico tecnico = TecnicoDAO.getTecnicoNome(nome);
		if (tecnico == null) {
			return "\nTecnico não encontrado, tente outro nome!\n";
		}
		return "\nO tecnico " + tecnico.getNome() + " foi encontrado e essas são suas informações: " + 
		"\nNome: " + tecnico.getNome() +
		"\nSelecao: " + tecnico.getSelecao().getNome();
	}	
	
	private static String buscarArbitro(String nome) {
		Arbitro arbitro = ArbitroDAO.getArbitroNome(nome);
		if (arbitro == null) {
			return "\nArbitro não encontrado, tente outro nome!\n";
		}
		return "\nO arbitro " + arbitro.getNome() + " foi encontrado e essas são suas informações: " +
		"\nNome: " + arbitro.getNome() +
		"\nPartidas que participou: ";
	}
	
	private static String buscarJogador(String nome) {
		Jogador jogador = JogadorDAO.getJogadorNome(nome);
		if (jogador == null) {
			return "\nJogador não encontrado, tente outro nome!\n";
		}
		return "\nO jogador " + jogador.getNome() + " foi encontrado e essas são suas informações: " +
		"\nNome: " + jogador.getNome() +
		"\nSeleção: " + jogador.getSelecao().getNome() +
		"\nGols Marcados: " + jogador.getGolmarcado() +
		"\nCartões Amarelos: " + jogador.getCartaoAmarelo() +
		"\nCartões Vermelhos: " + jogador.getCartaoVermelho() +
		"\nPosição: " + jogador.getPosicaoJogada() +
		"\nPartidas Jogadas: ";
	}
	
}
