package dao;

import dao.infra.DAO;
import entidades.Partida;

public class PartidaDAO extends DAO<Partida>{
 
	public PartidaDAO() {
		setSqlInsercao("INSERT INTO partida (numRodada, timeCasa, timeVisitante, golsTimeCasa, golsTimeVisitante) VALUES");
		//TODO
	}
	//TODO:...
}
