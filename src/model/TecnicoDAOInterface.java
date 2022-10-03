package model;

public interface TecnicoDAOInterface {
	static public boolean inserir(Tecnico tecnico) {
		return false;
	}

	static public boolean editar(Tecnico tecnico, String nome) {
		return false;
	}

	static public boolean excluir(int num) {
		return false;
	}

	static public void listar() {

	}

	static public Tecnico getOneTecnico(int num) {
		return null;

	}

	static public Tecnico getTecnicoIndes(Tecnico tecnico) {
		return null;
	}

	static public int contarTecnicos() {
		return 0;
	}
	

}
