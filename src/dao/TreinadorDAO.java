package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.infra.DAO;
import entidades.Treinador;
import entidades.Time;

public class TreinadorDAO extends DAO<Treinador> {
	private static final String sqlBuscaPorTime = "SELECT * FROM treinador WHERE id_time = ?";

	public TreinadorDAO() {
		setSqlInsercao("INSERT INTO treinador (nome, id_time) VALUES (?, ?)");
		setSqlAlteracao("UPDATE treinador SET id_time = ?");
		setSqlBusca("SELECT * FROM treinador WHERE nome = ?");
		setSqlBuscaTodos("SELECT * FROM treinador");
		setSqlExclusao("DELETE FROM treinador WHERE nome = ?");
		setSqlExclusaoTodos("DELETE * FROM treinador");
	}

	protected void doInserir(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
		ps.setInt(2, t.getTime().getId());
	}

	protected void doAlterar(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setInt(1, t.getTime().getId());
	}

	protected void doBuscar(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
	}

	protected void doExcluir(PreparedStatement ps, Treinador t) throws SQLException {
		ps.setString(1, t.getNome());
	}
	
	protected Treinador preencher(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        Time time = new TimeDAO().buscarPorNome(nome);
        return new Treinador(nome, time);
    }
	
	protected String listarPorTime(Time t) {
	    
	    try (Connection c = abrir(); PreparedStatement ps = c.prepareStatement(sqlBuscaPorTime)) {
	        ps.setInt(1, t.getId());
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getString("nome");
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }

	    return null;
	}


}
