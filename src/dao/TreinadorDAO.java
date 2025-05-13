package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.infra.DAO;
import entidades.Treinador;

public class TreinadorDAO extends DAO<Treinador> {

	public TreinadorDAO() {
		setSqlInsercao("INSERT INTO treinador (nome, id_time) VALUES (?, ?)");
		setSqlAlteracao("UPDATE treinador SET id_time = ?");
		setSqlBusca("SELECT * FROM treinador WHERE nome = ?");
		setSqlBuscaTodos("SELECT * FROM treinador");
		setSqlExclusao("DELETE FROM treinador WHERE nome = ?");
		setSqlExclusaoTodos("DELETE * FROM treinador");
	}

	protected void inserir(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
		ps.setInt(2, t.getTime().getId());
	}

	protected void alterar(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setInt(1, t.getTime().getId());
	}

	protected void buscar(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
	}

	protected void exluir(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
	}


}
