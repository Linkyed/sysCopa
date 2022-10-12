package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**Classe Jogador**/
public class Jogador {
	private String nome;
	private String codJog;

	private int cartaoVermelho = 0;
	private int cartaoAmarelo = 0;
	private int golMarcado = 0;
	private Selecao selecao;
	private String posicaoJogada; 
	private static String posicaoJogadorString[] = {"Goleiro", "Lateral direito", "Lateral esquerdo", "Zagueiro", "Volante", "Meia Atacante"};
	private List<Partida> listaPartdasList = new ArrayList<>();
	
	/**Construtor do jogador pelo codÌgo do Jogador**/
	public Jogador(String codigo) {
		this.codJog = codigo;
	}
	
	/**Construtor do jogador pelo Nome/ SeleÁ„o / Num. Cart. Amarelo / Num. Cart. Vermelho / Num. Gols Marcados/ PosiÁ„o **/
	public Jogador(String nome, Selecao selecao,int cart_Vermelho, int cart_Amarelo,int gol_Marcado, int posicao) {
	
		this.nome = nome;
		this.selecao = selecao;
		this.cartaoAmarelo = cart_Amarelo;
		this.cartaoVermelho = cart_Vermelho;
		this.golMarcado = gol_Marcado;
		this.posicaoJogada = posicaoJogadorString[posicao];
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss") ;
		this.codJog =  dtf.format(LocalDateTime.now());

	}

	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}

	

	public void setCartaoAmarelo(int numero_Cartao_amarelo) {
		if (numero_Cartao_amarelo > 0) {
			this.cartaoAmarelo += numero_Cartao_amarelo;
		}
	}

	public int getCartaoVermelho() {
		return cartaoVermelho;
	}


	public void setCartaoVermelho(int numero_Cartao_Vermelho) {
		if (numero_Cartao_Vermelho > 0) {
			this.cartaoAmarelo += numero_Cartao_Vermelho;
		}
	}

	public int getGolmarcado() {
		return this.golMarcado;
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

		if (nome.matches("[a-zA-Z·‡‚„ÈËÍÌÔÛÙıˆ˙ÁÒ¡¿¬√…»Õœ”‘’÷⁄«—\\s]+")) {
			this.nome = Funcoes.captilizeString(nome).strip();
			return true;
		}
		return false;
	}

	public String getCodJog() {
		return codJog;
	}


	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	public String getPosicaoJogada() {
		return posicaoJogada;
	}

	public String[] getListaPosicao() {
		return posicaoJogadorString;
	}
	public void setPosicaoJogada(int posicao) {
		if(0 <= posicao && posicao <6) {
			this.posicaoJogada = posicaoJogadorString[posicao];
		}
	}


	public List<Partida> getListaPartdasList() {
		return listaPartdasList;
	}

	@Override
	/**Mostra todos os atributos do jogador**/
	public String toString() {
		return "Nome: " + nome + " || SeleÁ„o: " + selecao + "|| Cart. Vermelho: " + cartaoVermelho + "|| Cart. Amarelo: "
				+ cartaoAmarelo + "|| Gol Marcado: " + golMarcado +"|| PosiÁ„o: " + posicaoJogada + "|| Cod. do Jogador: " + codJog;
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
		return Objects.equals(codJog, other.codJog) ||
				Objects.equals(nome, other.nome);
	}

	
}