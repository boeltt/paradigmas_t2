package entidades;

public class Partida {
	private final int numRodada;
	private final Time timeCasa;
	private final Time timeVisitante;
	private final int golsTimeCasa;
	private final int golsTimeVisitante;

	public Partida(int numRodada, Time timeCasa, Time timeVisitante, int golsTimeCasa, int golsTimeVisitante) {
		this.numRodada = numRodada;
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.golsTimeCasa = golsTimeCasa;
		this.golsTimeVisitante = golsTimeVisitante;
	}

	@Override
	public String toString() {
		return "Partida [numRodada=" + numRodada + ", timeCasa=" + timeCasa + ", timeVisitante=" + timeVisitante
				+ ", golsTimeCasa=" + golsTimeCasa + ", golsTimeVisitante=" + golsTimeVisitante + "]";
	}
	
	public int getNumRodada() {
		return numRodada;
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public int getGolsTimeCasa() {
		return golsTimeCasa;
	}

	public int getGolsTimeVisitante() {
		return golsTimeVisitante;
	}

}