package entidades;

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
