package app.model;


public interface SelecaoDAOInterface {
	static public boolean inserir(Selecao selecao) {

		return false;
	}

	static public boolean editar(Selecao selecao, String nome) {

		return false;

	}

	static public boolean excluir(int num) {

		return false;
	}

	static public void listar() {

	}

	static public void listarJogadors() {

	}

	static public Selecao getOneSelecao(int num) {

		return null;

	}

	static public boolean existeSelecao(Selecao selecao) {
		return false;
	}

	static public Selecao indexSelecao(Selecao selecao) {
		return null;
	}

	static public int quantidadeSelecoes() {
		return 0;
	}

	static public void imprimirSelecaoSemTecnico() {

	}

	static public void imprimirSelecao() {

	}

	static public int selecoesSemTecnico() {
		return 0;

	}
}
