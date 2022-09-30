package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Jogador {
	private String nome;
	private String codJog;

	private int cartaoVermelho = 0;
	private int cartaoAmarelo = 0;
	private int golMarcado = 0;
	private Selecao selecao;

	public Jogador(String nome) {
		this.nome = nome;
	}

	public Jogador(String nome, Selecao selecao,int cart_Vermelho, int cart_Amarelo,int gol_Marcado) {
		
		this.nome = nome;
		this.selecao = selecao;
		this.cartaoAmarelo = cart_Amarelo;
		this.cartaoVermelho = cart_Vermelho;
		this.golMarcado = gol_Marcado;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss") ;
		this.codJog =  dtf.format(LocalDateTime.now());

	}

	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}

	public void setCartaoAmarelo() {
		this.cartaoAmarelo += 1;
	}

	public void setCartaoAmarelo(int numero_Cartao_amarelo) {
		if (numero_Cartao_amarelo > 0) {
			this.cartaoAmarelo += numero_Cartao_amarelo;
		}
	}

	public int getCartaoVermelho() {
		return cartaoVermelho;
	}

	public void setCartaoVermelho() {
		this.cartaoVermelho += 1;
	}

	public void setCartaoVermelho(int numero_Cartao_Vermelho) {
		if (numero_Cartao_Vermelho > 0) {
			this.cartaoAmarelo += numero_Cartao_Vermelho;
		}
	}

	public int getGolmarcado() {
		return this.golMarcado;
	}

	public void setGolmarcado() {
		this.golMarcado += 1;
	}

	public boolean setGolmarcado(int gols_Marcados) {
		if (gols_Marcados > 0) {
			this.golMarcado += gols_Marcados;
			return true;
		}
		return false;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean setNome(String nome) {

		if (nome.matches("[a-zA-Z\s]+")) {
			this.nome = Funcoes.captilizeString(nome);
			return true;
		}
		return false;
	}

	public String getCodJog() {
		return codJog;
	}


	public int getCamisa() {
		return camisa;
	}

	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " || Seleção: " + selecao + "|| Cart. Vermelho " + cartaoVermelho + "|| Cart. Amarelo "
				+ cartaoAmarelo + "|| Gol Marcado " + golMarcado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codJog, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return //Objects.equals(codJog, other.codJog) ||
				Objects.equals(nome, other.nome);
	}

}