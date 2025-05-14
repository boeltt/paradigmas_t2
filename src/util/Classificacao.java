package util;

import java.util.*;
import java.util.stream.*;
import entidades.Partida;
import entidades.Time;

public class Classificacao {

	public static Map<Time, Integer> gerarClassificacao(List<Partida> partidas) {
		Map<Time, Integer> pontos = new HashMap<>();

		for (Partida p : partidas) {
			Time casa = p.getTimeCasa();
			Time visitante = p.getTimeVisitante();
			int golsCasa = p.getGolsTimeCasa();
			int golsVisitante = p.getGolsTimeVisitante();

			pontos.putIfAbsent(casa, 0);
			pontos.putIfAbsent(visitante, 0);

			if (golsCasa > golsVisitante) {
				pontos.put(casa, pontos.get(casa) + 3);
			} else if (golsCasa < golsVisitante) {
				pontos.put(visitante, pontos.get(visitante) + 3);
			} else {
				pontos.put(casa, pontos.get(casa) + 1);
				pontos.put(visitante, pontos.get(visitante) + 1);
			}
		}

		return pontos.entrySet().stream()
			.sorted(Map.Entry.<Time, Integer>comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(e1, e2) -> e1,
				LinkedHashMap::new
			));
	}
}
