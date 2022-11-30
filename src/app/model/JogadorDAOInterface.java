package app.model;

public interface JogadorDAOInterface {
	public static boolean inserir(Jogador jogador, Selecao selecao, boolean mensagem) {
		return false;
	}

	public static boolean editarNome(Jogador jogador_Antigo, Jogador jogador_Novo) {
		return false;
	}

	public static boolean editarNome(int numJogador, String nome) {
		return false;
	}

	public static boolean editarCartAmarelo(Jogador jogador, int cartao_amarelo) {
		return false;
	}

	public static boolean editarCartAmarelo(int numJogador, int cartao_amarelo) {
		return false;
	}

	public static boolean editarCartVermelho(Jogador jogador, int cartao_vermelho) {
		return false;
	}

	public static boolean editarCartVermelho(int numJogador, int cartao_vermelho) {
		return false;
	}

	public static boolean editarGolMarcado(Jogador jogador, int gol_Marcado) {
		return false;
	}

	public static boolean editarGolMarcado(int numJogador, int gol_Marcado) {
		return false;
	}

	public static boolean editarPosicao(int numJogador, int posicao) {
		return false;
	}

	public static boolean editarPosicao(Jogador jogador, int posicao) {
		return false;
	}

	public static boolean excluir(Jogador jogador) {
		return false;
	}

	public static boolean excluir(int posicao) {
		return false;
	}

	public static boolean excluirJogadorParcial(Jogador jogador) {
		return false;
	}

	public static boolean listar() {
		return false;
	}

	public static int getQuantidadeJogadores() {
		return 0;
	}

	public static boolean estaNaLista(Jogador jogador) {
		return false;
	}

	public static void imprimirJogador(Jogador jogador) {
	}
}
