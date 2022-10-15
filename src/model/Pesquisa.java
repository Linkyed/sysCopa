package model;

public class Pesquisa {

	static public String buscarSelecao() {
		String nomeBusca = Funcoes.entradaString("Digite o nome da seleção que deseja procurar no banco de dados: ", true);
		Selecao selecaoBuscada = SelecaoDAO.getSelecaoNome(nomeBusca);
		if (selecaoBuscada == null) {
			return "\nSeleção não encontrada, tente outro nome!\n";
		}
		String jogadores = "";
		for(Jogador jogador: selecaoBuscada.getJogadores()) {
			jogadores += jogador.getNome() + "\n";
		}
		return "\nA seleção " + selecaoBuscada + " foi encontrada e essas são suas informações:" +
		"\nNome: " + selecaoBuscada.getNome() + 
		"\nTecnico: " + selecaoBuscada.getTecnico() +
		"\nJogadores: " + jogadores +
		"\nPartidas: ";
	}
	
}
