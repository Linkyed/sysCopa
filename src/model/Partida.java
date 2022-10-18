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
	static private Integer ano;
	private String horario;
	private String local;
	private Selecao selecao1;
	private Selecao selecao2;
	private int golSelecao1 = 0;
	private int golSelecao2 = 0;
	private Selecao resultadoSelecao;
	private Map<Jogador, Integer> cartaoAmareloPartida = new HashMap<>();
	private Map<Jogador, Integer> cartaoVermelhoPartida = new HashMap<>();
	private Map<Jogador, Integer> GolsMarcaosPartida = new HashMap<>();
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

	public void setAno(Integer anoCopa) {
		if (anoCopa > 0)
			ano = anoCopa;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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
		if (golSelecao1 > 0) {
			this.golSelecao1 = golSelecao1;
		}
	}

	public int getGolSelecao2() {
		return golSelecao2;
	}

	public void setGolSelecao2(int golSelecao2) {
		if (golSelecao2 > 0) {
			this.golSelecao2 = golSelecao2;
		}
	}

	public Map<Jogador, Integer> getCartaoAmareloPartida() {
		return cartaoAmareloPartida;
	}

	public Map<Jogador, Integer> getCartaoVermelhoPartida() {
		return cartaoVermelhoPartida;
	}

	public Map<Jogador, Integer> getGolsMarcaosPartida() {
		return GolsMarcaosPartida;
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


	public List<Arbitro> getListaArbitro() {
		return listaArbitro;
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
