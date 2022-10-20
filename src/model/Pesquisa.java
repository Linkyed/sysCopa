package model;

import java.util.List;

public class Pesquisa {

	static public String buscarSelecao() {
		String nomeBusca = Funcoes.captilizeString(Funcoes.entradaString("Digite o nome da seleção que deseja procurar no banco de dados: ", true).strip());
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
		"\nPartidas: "+
		"\n";
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
		List<Tecnico> listaBuscada = TecnicoDAO.getTecnicoNome(nome);
		int tecnicoEscolhido = 0;
		if (listaBuscada.size() == 0) {
			return "\nNenhum ecnico com o nome " + nome + " foi encontrado, tente outro nome!\n";
		} else if (listaBuscada.size() > 1) {
			System.out.println();
			for (Tecnico tecnico: listaBuscada) {
				System.out.println("[" + listaBuscada.indexOf(tecnico) + "] " + tecnico.getNome());
			}
			tecnicoEscolhido = Funcoes.entradaIntRanger("Foram achados esses arbitros que possuem o nome " + nome + "neles, digite o numero para escolher um deles: ", 
					0, listaBuscada.size()-1);
		}
		return "\nO tecnico " + listaBuscada.get(tecnicoEscolhido).getNome() + " foi encontrado e essas são suas informações: " + 
		"\nNome: " + listaBuscada.get(tecnicoEscolhido).getNome() +
		"\nSelecao: " + listaBuscada.get(tecnicoEscolhido).getSelecao().getNome() +
		"\n";
	}	
	
	private static String buscarArbitro(String nome) {
		List<Arbitro> listaBuscada = ArbitroDAO.getArbitroNome(nome);
		int arbitroEscolhido = 0;
		if (listaBuscada.size() == 0) {
			return "\nNenhum arbitro com o nome " + nome + " foi encontrado, tente outro nome!\n";
		} else if (listaBuscada.size() > 1) {
			System.out.println();
			for (Arbitro arbitro: listaBuscada) {
				System.out.println("[" + listaBuscada.indexOf(arbitro) + "] " + arbitro.getNome());
			}
			arbitroEscolhido = Funcoes.entradaIntRanger("Foram achados esses arbitros que possuem o nome " + nome + "neles, digite o numero para escolher um deles: ", 
					0, listaBuscada.size()-1);
		}
		return "\nO arbitro " + listaBuscada.get(arbitroEscolhido).getNome() + " foi encontrado e essas são suas informações: " +
		"\nNome: " + listaBuscada.get(arbitroEscolhido).getNome() +
		"\nPartidas que participou: " +
		"\n";
	}
	
	private static String buscarJogador(String nome) {
		List<Jogador> listaBuscada = JogadorDAO.getJogadorNome(nome);
		int jogadorEscolhido = 0;
		if (listaBuscada.size() == 0) {
			return "\nNenhum jogador com o nome " + nome + " foi encontrado, tente outro nome!\n";
		} else if (listaBuscada.size() > 1) {
			System.out.println();
			for (Jogador jogador: listaBuscada) {
				System.out.println("[" + listaBuscada.indexOf(jogador) + "] " + jogador.getNome());
			}
			jogadorEscolhido = Funcoes.entradaIntRanger("Foram achados esses jogadores que possuem o nome " + nome + "neles, digite o numero para escolher um deles: ", 
					0, listaBuscada.size()-1);
		}
		
		return "\nO jogador " + listaBuscada.get(jogadorEscolhido).getNome() + " foi encontrado e essas são suas informações: " +
		"\nNome: " + listaBuscada.get(jogadorEscolhido).getNome() +
		"\nSeleção: " + listaBuscada.get(jogadorEscolhido).getSelecao().getNome() +
		"\nGols Marcados: " + listaBuscada.get(jogadorEscolhido).getGolmarcado() +
		"\nCartões Amarelos: " + listaBuscada.get(jogadorEscolhido).getCartaoAmarelo() +
		"\nCartões Vermelhos: " + listaBuscada.get(jogadorEscolhido).getCartaoVermelho() +
		"\nPosição: " + listaBuscada.get(jogadorEscolhido).getPosicaoJogada() +
		"\nPartidas Jogadas: " +
		"\n";
	}
	
}
