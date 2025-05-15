package entidades;

import java.util.Objects;

public class Time {
	private int id;
	private final String nome;
	private String estadio;
	private String cidade;
	private final String dataFund;

	public Time(String nome, String estadio, String cidade, String dataFund) {
		this.nome = nome;
		this.estadio = estadio;
		this.cidade = cidade;
		this.dataFund = dataFund;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", nome=" + nome + ", estadio=" + estadio + ", cidade=" + cidade + ", dataFund="
				+ dataFund + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return id == other.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDataFund() {
		return dataFund;
	}
}
