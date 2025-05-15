package entidades;

public class Treinador {
	private String nome;
	private Time time;

	public Treinador(String nome, Time time) {
		this.nome = nome;
		this.time = time;
	}

	public String toString() {
		return "Treinador [nome=" + nome + ", time=" + (time != null ? time.getNome() : "sem time") + "]";

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
