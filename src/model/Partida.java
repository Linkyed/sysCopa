package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Partida {
	private boolean status = false;
	private String codigoPartida;
	private Integer dia;
	private Integer mes;
	private static Integer ano;
	private int horarioH;
	private int horarioM;
	private String local;
	private Selecao selecao1;
	private Selecao selecao2;
	private int golSelecao1 = 0;
	private int golSelecao2 = 0;
	private Selecao resultadoSelecao;
	private Map<Jogador, Integer> cartaoAmareloSelecao1 = new HashMap<>();
	private Map<Jogador, Integer> cartaoVermelhoSelecao1 = new HashMap<>();
	private Map<Jogador, Integer> GolsMarcadosSelecao1 = new HashMap<>();
	private Map<Jogador, Integer> cartaoAmareloSelecao2 = new HashMap<>();
	private Map<Jogador, Integer> cartaoVermelhoSelecao2 = new HashMap<>();
	private Map<Jogador, Integer> GolsMarcadosSelecao2 = new HashMap<>();
	private List<Arbitro> listaArbitro = new ArrayList<>();

	public Partida(Selecao selecao1, Selecao selecao2) {

		this.selecao1 = selecao1;
		this.selecao2 = selecao2;

	}

	public String getCodigoPartida() {
		return codigoPartida;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		if (dia > 0 && dia < 32) {
			this.dia = dia;
		}
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		if (mes > 0 && mes < 13) {
			this.mes = mes;
		}
	}

	public Integer getAno() {
		return ano;
	}

	public static void setAno(Integer anoCopa) {
		if (anoCopa > 0)
			ano = anoCopa;
	}

	public int getHorario() {
		return horarioH;
	}

	public void setHorario(int horario) {
		this.horarioH = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Selecao getSelecao1() {
		return selecao1;
	}

	public void setSelecao1(Selecao selecao1) {
		if (!selecao1.equals(null)) {
			this.selecao1 = selecao1;
		}
	}

	public Selecao getSelecao2() {
		return selecao2;
	}

	public void setSelecao2(Selecao selecao2) {
		if (!selecao2.equals(null)) {
			this.selecao2 = selecao2;
		}
	}

	public int getGolSelecao1() {
		return golSelecao1;
	}

	public void setGolSelecao1(int golSelecao1) {
		if (golSelecao1 >= 0) {
			this.golSelecao1 = golSelecao1;
		}
	}

	public int getGolSelecao2() {
		return golSelecao2;
	}

	public void setGolSelecao2(int golSelecao2) {
		if (golSelecao2 >= 0) {
			this.golSelecao2 = golSelecao2;
		}
	}

	public Map<Jogador, Integer> getCartaoAmareloSelecao1() {
		return cartaoAmareloSelecao1;
	}

	public Map<Jogador, Integer> getCartaoVermelhoSelecao1() {
		return cartaoVermelhoSelecao1;
	}

	public Map<Jogador, Integer> getGolsMarcadosSelecao1() {
		return GolsMarcadosSelecao1;
	}

	@Override
	public String toString() {
		return selecao1.getNome() + " x " + selecao2.getNome();
	}

	public Selecao getResultadoSelecao() {
		return resultadoSelecao;
	}

	public void setResultadoSelecao(Selecao resultadoSelecao) {
		this.resultadoSelecao = resultadoSelecao;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getHorarioM() {
		return horarioM;
	}

	public void setHorarioM(int horarioM) {
		this.horarioM = horarioM;
	}

	public List<Arbitro> getListaArbitro() {
		return listaArbitro;
	}
	
	public void setListaArbitro(List<Arbitro> arbitros) {
		this.listaArbitro = arbitros;
	}

	public void setCartaoAmareloSelecao1(Map<Jogador, Integer> cartaoAmareloPartida) {
		this.cartaoAmareloSelecao1 = cartaoAmareloPartida;
	}

	public void setCartaoVermelhoSelecao1(Map<Jogador, Integer> cartaoVermelhoPartida) {
		this.cartaoVermelhoSelecao1 = cartaoVermelhoPartida;
	}

	public void setGolsMarcadosSelecao1(Map<Jogador, Integer> golsMarcaosPartida) {
		GolsMarcadosSelecao1 = golsMarcaosPartida;
	}

	public Map<Jogador, Integer> getCartaoAmareloSelecao2() {
		return cartaoAmareloSelecao2;
	}

	public void setCartaoAmareloSelecao2(Map<Jogador, Integer> cartaoAmareloSelecao2) {
		this.cartaoAmareloSelecao2 = cartaoAmareloSelecao2;
	}

	public Map<Jogador, Integer> getCartaoVermelhoSelecao2() {
		return cartaoVermelhoSelecao2;
	}

	public void setCartaoVermelhoSelecao2(Map<Jogador, Integer> cartaoVermelhoSelecao2) {
		this.cartaoVermelhoSelecao2 = cartaoVermelhoSelecao2;
	}

	public Map<Jogador, Integer> getGolsMarcadosSelecao2() {
		return GolsMarcadosSelecao2;
	}

	public void setGolsMarcadosSelecao2(Map<Jogador, Integer> golsMarcadosSelecao2) {
		GolsMarcadosSelecao2 = golsMarcadosSelecao2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(selecao1, selecao2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return (Objects.equals(selecao1, other.selecao1) && Objects.equals(selecao2, other.selecao2))
				|| (Objects.equals(selecao1, other.selecao2) && Objects.equals(selecao2, other.selecao1));
	}

}
