package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Time;
import dao.infra.DAO;
//import dao.JogadorDAO;

public class TimeDAO extends DAO<Time> {
	private static final String sqlBuscaPorId = "SELECT * FROM time WHERE id = ?";

	public TimeDAO() {
		setSqlInsercao("INSERT INTO time (nome, estadio, cidade, dataFund) VALUES (?, ?, ?, ?)");
		setSqlAlteracao("UPDATE time SET estadio = ?, cidade = ?");
		setSqlExclusao("DELETE FROM time WHERE nome = ?");
		setSqlBusca("SELECT * FROM time WHERE nome = ?");
		setSqlExclusaoTodos("DELETE FROM time");
		setSqlBuscaTodos("SELECT * FROM time");
	}

	public int inserirERetornarId(Time t) {
		int idGerado = -1;

		try (Connection c = abrir();
				PreparedStatement ps = c.prepareStatement(getSqlInsercao(), Statement.RETURN_GENERATED_KEYS)) {

			doInserir(ps, t);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				idGerado = rs.getInt(1);
				t.setId(idGerado);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return idGerado;
	}

	protected void doInserir(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getNome());
		ps.setString(2, t.getEstadio());
		ps.setString(3, t.getCidade());
		ps.setDate(4, java.sql.Date.valueOf(t.getDataFund()));
	}

	protected void doAlterar(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getEstadio());
		ps.setString(2, t.getCidade());
	}

	protected void doExcluir(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getNome());
	}

	protected void doBusca(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getNome());
	}

	protected Time preencher(ResultSet rs) throws SQLException {
		Time t = new Time(rs.getString("nome"), rs.getString("estadio"), rs.getString("cidade"),
				rs.getDate("dataFund").toString());
		t.setId(rs.getInt("id"));
		return t;
	}

	public Time buscarPorId(int id) {
		try (Connection c = abrir(); PreparedStatement ps = c.prepareStatement(sqlBuscaPorId)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return preencher(rs);
			}
			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
