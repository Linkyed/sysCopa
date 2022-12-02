package app.model;

import java.util.Objects;

public class Tecnico{
	private String nome;
	private Selecao selecao;
	
	/**Construtor que obriga a receber uma String nome e uma referencia de uma seleção para criar um tecnico**/
	public Tecnico (String nome, Selecao selecao){
		this.nome = Funcoes.captilizeString(nome);
		this.selecao = selecao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = Funcoes.captilizeString(nome);
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tecnico other = (Tecnico) obj;
		return Objects.equals(nome, other.nome);
	}

	/**Metodo para mostrar o Tecnico em String**/
	public String toString() {
		return "Nome: " + nome + " | Selecao: " + selecao.getNome();
	}

	
	
}
