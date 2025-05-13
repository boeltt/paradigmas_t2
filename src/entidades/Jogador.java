package entidades;

public class Jogador {
	private final String nome;
	private String posicao;
	private int idade;
	private final int numCamisa;
	private Time time;

	public Jogador(String nome, String posicao, int idade, int numCamisa, Time time) {
		this.nome = nome;
		this.posicao = posicao;
		this.idade = idade;
		this.numCamisa = numCamisa;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", posicao=" + posicao + ", idade=" + idade + ", numCamisa=" + numCamisa
				+ ", time=" + time + "]";
	}



	public String getNome() {
		return nome;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNumCamisa() {
		return numCamisa;
	}

}
