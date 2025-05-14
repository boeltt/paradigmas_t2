package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.infra.DAO;
import entidades.Partida;
import entidades.Time;

public class PartidaDAO extends DAO<Partida>{
 
	public PartidaDAO() {
		setSqlInsercao("INSERT INTO partida (numRodada, timeCasa, timeVisitante, golsTimeCasa, golsTimeVisitante) VALUES");
		setSqlBusca("SELECT * FROM partida WHERE numRodada = ?");
		setSqlBuscaTodos("SELECT * FROM partida");
		setSqlExclusao("DELETE FROM partida WHERE numRodada = ?");
		setSqlExclusaoTodos("DELETE * FROM partida");
	}

	protected void doInserir(PreparedStatement ps, Partida p) throws SQLException {
		ps.setInt(1, p.getNumRodada());
		ps.setString(2, p.getTimeCasa().getNome());
		ps.setString(3, p.getTimeVisitante().getNome());
		ps.setInt(4, p.getGolsTimeCasa());
		ps.setInt(5, p.getGolsTimeVisitante());
	}

	protected void doAlterar(PreparedStatement ps, Partida p) throws SQLException {
		throw new UnsupportedOperationException("Partidas não podem ser alteradas!");
		
	}

	protected void doExcluir(PreparedStatement ps, Partida p) throws SQLException {
		ps.setInt(1, p.getNumRodada());	
	}

	protected Partida preencher(ResultSet rs) throws SQLException {
		int numRodada = rs.getInt("numRodada");
		int golsTimeCasa = rs.getInt("golsTimeCasa");
		int golsTimeVisitante = rs.getInt("golsTimeVisitante");
		
		Time timeC = new TimeDAO().buscarPorNome(rs.getString("timeCasa"));
		Time timeV = new TimeDAO().buscarPorNome(rs.getString("timeVisitante"));
		
		return new Partida(numRodada, timeC, timeV, golsTimeCasa, golsTimeVisitante);
	}
	
}
