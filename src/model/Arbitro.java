package model;

import java.util.Objects;

public class Arbitro{
	private String nome;
	
	public Arbitro(String nome){
		this.nome = Funcoes.captilizeString(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
