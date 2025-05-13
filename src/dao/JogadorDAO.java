package dao;

//import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import dao.infra.DAO;
import entidades.Jogador;
//import entidades.Time;

public class JogadorDAO extends DAO<Jogador> {
	//private static final String SqlBuscaPorTime = "SELECT nome, posicao, idade, numCamisa, id_time FROM jogador WHERE id_time = ?";

	public JogadorDAO() {
		setSqlInsercao("INSERT INTO jogador (nome, posicao, idade, numCamisa, id_time VALUES (?, ?, ?, ?, ?");
		setSqlAlteracao("UPDATE jogador SET posicao = ?, idade = ?, id_time = ?");
		setSqlBusca("SELECT * FROM jogador WHERE nome = ?");
		setSqlBuscaTodos("SELECT * FROM jogador");
		setSqlExclusao("DELETE FROM jogador WHERE nome = ?");
		setSqlExclusaoTodos("DELETE * FROM jogador");
	}

	protected void inserir(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getNome());
		ps.setString(2, j.getPosicao());
		ps.setInt(3, j.getIdade());
		ps.setInt(4, j.getNumCamisa());
		ps.setInt(5, j.getTime().getId());
	}

	protected void alterar(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getPosicao());
		ps.setInt(2, j.getIdade());
		ps.setInt(3, j.getTime().getId());
	}

	protected void buscar(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getNome());
	}

	protected void excluir(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getNome());
	}

	/*protected List<Jogador> listarJogadoresTime(Time t) {
		List<Jogador> l = new ArrayList<>();
		try (Connection c = abrir(); PreparedStatement ps = c.prepareStatement(SqlBuscaPorTime)) {
			ps.setInt(1, t.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Jogador j = new Jogador(rs.getString("nome"), rs.getString("posicao"), rs.getInt("idade"),
						rs.getInt("numCamisa"), t);
				l.add(j);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return l;
	}ESSA PORRA FUNCIONA PELO MENOS CARALHO*/
}
