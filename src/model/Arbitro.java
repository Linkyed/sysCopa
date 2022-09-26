package model;

import java.util.Objects;

public class Arbitro {
	private String nome;

	Arbitro(String nome) {
		this.nome = nome;
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
