package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.infra.DAO;
import entidades.Partida;
import entidades.Time;

public class PartidaDAO extends DAO<Partida> {

	public PartidaDAO() {
		setSqlInsercao(
				"INSERT INTO partida (numrodada, timecasa_id, timevisitante_id, golstimecasa, golstimevisitante) VALUES (?, ?, ?, ?, ?)");
		;
		setSqlBusca("SELECT * FROM partida WHERE num_rodada = ?");
		setSqlBuscaTodos("SELECT * FROM partida");
		setSqlExclusao("DELETE FROM partida WHERE num_rodada = ?");
		setSqlExclusaoTodos("DELETE FROM partida");
	}

	protected void doInserir(PreparedStatement ps, Partida p) throws SQLException {
		ps.setInt(1, p.getNumRodada());
		ps.setInt(2, p.getTimeCasa().getId());
		ps.setInt(3, p.getTimeVisitante().getId());
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
		int numRodada = rs.getInt("numrodada");
		int golsTimeCasa = rs.getInt("golstimecasa");
		int golsTimeVisitante = rs.getInt("golstimevisitante");

		Time timeC = new TimeDAO().buscarPorId(rs.getInt("timecasa_id"));
		Time timeV = new TimeDAO().buscarPorId(rs.getInt("timevisitante_id"));

		return new Partida(numRodada, timeC, timeV, golsTimeCasa, golsTimeVisitante);
	}

}
