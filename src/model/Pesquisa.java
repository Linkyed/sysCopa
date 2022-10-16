package model;

public class Pesquisa {

	static public String buscarSelecao() {
		String nomeBusca = Funcoes.entradaString("Digite o nome da seleção que deseja procurar no banco de dados: ", true);
		Selecao selecaoBuscada = SelecaoDAO.getSelecaoNome(nomeBusca);
		if (selecaoBuscada == null) {
			return "\nSeleção não encontrada, tente outro nome!\n";
		}
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
			nome = Funcoes.entradaString("Digite o nome de um tecnico para ser buscado no banco de dados: ", true);
			return buscarTecnico(nome);
		} else if (escolha == 2) {
			nome = Funcoes.entradaString("Digite o nome de um arbitro para ser buscado no banco de dados: ", true);
			return buscarArbitro(nome);
		} else { return "";}
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
	
}
