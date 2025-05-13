package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Time;
import dao.infra.DAO;

public class TimeDAO extends DAO<Time> {

	public TimeDAO() {
		setSqlInsercao("INSERT INTO time (nome, estadio, cidade, dataFund) VALUES (?, ?, ?, ?)");
		setSqlAlteracao("UPDATE time SET estadio = ?, cidade = ?");
		setSqlExclusao("DELETE FROM time WHERE nome = ?");
		setSqlBusca("SELECT * FROM time WHERE nome = ?");
		setSqlExclusaoTodos("DELETE FROM time");
		setSqlBuscaTodos("SELECT * FROM time");
	}

	protected void inserir(Time t) {
		int idGerado = -1;

		try (Connection c = abrir();
				PreparedStatement ps = c.prepareStatement(getSqlInsercao(), Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, t.getNome());
			ps.setString(2, t.getEstadio());
			ps.setString(3, t.getCidade());
			ps.setDate(4, java.sql.Date.valueOf(t.getDataFund()));
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				idGerado = rs.getInt(1);
				t.setId(idGerado);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void alterar(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getEstadio());
		ps.setString(2, t.getCidade());
	}

	protected void excluir(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getNome());
	}

	protected void busca(PreparedStatement ps, Time t) throws SQLException {
		ps.setString(1, t.getNome());
	}
}
