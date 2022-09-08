package model;


public class Jogador{
	private String nome;
	private String codJog;
	
	private int cartaoVermelho = 0;
	private int cartaoAmarelo = 0;
	private int golMarcado = 0;
	private Selecao selecao;
	
	public Jogador(String nome, String codigo, Selecao selecao) {
		this.nome = nome;
		this.codJog = codigo;
		this.selecao = selecao;
	}
	
	
	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}
	
	public void setCartaoAmarelo() {
		this.cartaoAmarelo +=1;
	}
	
	public void setCartaoAmarelo(int numero_Cartao_amarelo) {
		if(numero_Cartao_amarelo > 0) {
			this.cartaoAmarelo += numero_Cartao_amarelo;
				}
	}
	
	
	public int getCartaoVermelho() {
		return cartaoVermelho;
	}
	public void setCartaoVermelho() {
		this.cartaoVermelho +=1;
	}
	
	public void setCartaoVermelho(int numero_Cartao_Vermelho) {
		if(numero_Cartao_Vermelho > 0) {
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
		if(golsmarcados > 0) {
			this.golMarcado += gols_Marcados;
			return true;
			}
		return false;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean setNome(String nome) {
		for(int i = 0; i < nome.length()i;i++) {
			char c = nome.charAt(i);
			if(c.isLetter() == false) {
				return false;
			}
		}
		this.nome = nome;
		return true;
	}

}
