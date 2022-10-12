package model;

public class Partida {
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

	public Partida(int dia, int mes, String horario, String local, Selecao selecao1, Selecao selecao2, int golSele1,
			int golSele2) {
		this.dia = dia;
		this.mes = mes;
		this.horario = horario;
		this.local = local;
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.golSelecao1 = golSele1;
		this.golSelecao2 = golSele2;
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

	public void setAno(Integer ano) {
		if (ano > 0)
			this.ano = ano;
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

}
