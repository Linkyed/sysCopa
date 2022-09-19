package model;

import java.util.Objects;

public class Selecao{
	private String[] jogadores = new String[11];
	private Tecnico tecnico;
	private String nome;
	
	Selecao(String nome) {
		this.nome = nome;
	}
	Selecao(String nome, Tecnico tecnico) {
		this.nome = nome;
		this.tecnico = tecnico;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		
		if(tecnico != null) {
			this.tecnico = tecnico;
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
		Selecao other = (Selecao) obj;
		return Objects.equals(nome, other.nome);
	}
	
	

	
	
}
