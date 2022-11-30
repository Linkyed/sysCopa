package app.model;

import java.util.Objects;
/**Classe Arbitror**/
public class Arbitro{
	private String nome;
	
	/**Construtor que obriga a receber um String nome para criar um arbitro**/
	public Arbitro(String nome){
		this.nome = Funcoes.captilizeString(nome);
	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {

		if (nome.matches("[a-zA-Z\s]+")) {
			this.nome = Funcoes.captilizeString(nome);
			return true;
		}
		return false;
	}
	
	/**Metodo para mostrar o Arbitro em String**/
	public String toString() {
		return "Nome: " + nome;
	}

	public int hashCode() {
		return Objects.hash(nome);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arbitro other = (Arbitro) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
}
