package entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Time {
	private final String nome;
	private String estadio;
	private String cidade;
	private final String dataFund;
	private Collection<Jogador> jogadores = new ArrayList<>(25);
	private Treinador treinador;
	private int id;
	
	public Time(String nome, String estadio, String cidade, String dataFund, List<Jogador> jogadores,
			Treinador treinador) {
		this.nome = nome;
		this.estadio = estadio;
		this.cidade = cidade;
		this.dataFund = dataFund;
		if(jogadores != null && jogadores.size() <= 25) {
			this.jogadores.addAll(jogadores);
		} else {
			throw new IllegalArgumentException("Máximo de 25 jogadores permitidos");
		}
	}
	
	@Override
	public String toString() {
		return "Time [nome=" + nome + ", estadio=" + estadio + ", cidade=" + cidade + ", dataFund=" + dataFund
				+ ", jogadores=" + jogadores + ", treinador=" + treinador + "]";
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

	public Collection<Jogador> getJogadores() {
		return Collections.unmodifiableCollection(jogadores);
	}
	
	public boolean adicionarJogador(Jogador jogador) {
		if(jogadores.size() < 25) {
			return jogadores.add(jogador);
		}
		return false;
	}

	public void listarJogadores() {
		for (Jogador j : getJogadores()) {
			System.out.println(j.getNome());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
