package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;

import dao.infra.DAO;
import entidades.Jogador;
import entidades.Time;

public class JogadorDAO extends DAO<Jogador> {
	private static final String sqlBuscaPorTime = "SELECT * FROM jogador WHERE time_id = ?";

	public JogadorDAO() {
		setSqlInsercao("INSERT INTO jogador (nome, posicao, idade, numCamisa, time_id) VALUES (?, ?, ?, ?, ?)");
		setSqlAlteracao("UPDATE jogador SET posicao = ?, idade = ?, id_time = ?");
		setSqlBusca("SELECT * FROM jogador WHERE nome = ?");
		setSqlBuscaTodos("SELECT * FROM jogador");
		setSqlExclusao("DELETE FROM jogador WHERE nome = ?");
		setSqlExclusaoTodos("DELETE FROM jogador");
	}

	protected void doInserir(PreparedStatement ps, Jogador j) throws SQLException {
		int total = listarPorTime(j.getTime()).size();
		// Isso é pra testar o limite dos 25, sei que não é o ideal pq é muito request,
		// mas é o que eu consegui fazer
		if (total >= 25) {
			throw new IllegalStateException("O time '" + j.getTime().getNome() + "' já possui 25 jogadores.");
		}
		ps.setString(1, j.getNome());
		ps.setString(2, j.getPosicao());
		ps.setInt(3, j.getIdade());
		ps.setInt(4, j.getNumCamisa());
		ps.setInt(5, j.getTime().getId());
	}

	protected void doAlterar(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getPosicao());
		ps.setInt(2, j.getIdade());
		ps.setInt(3, j.getTime().getId());
	}

	protected void doExcluir(PreparedStatement ps, Jogador j) throws SQLException {
		ps.setString(1, j.getNome());
	}

	protected Jogador preencher(ResultSet rs) throws SQLException {
		String nome = rs.getString("nome");
		String posicao = rs.getString("posicao");
		int idade = rs.getInt("idade");
		int numCamisa = rs.getInt("numCamisa");

		Time time = new TimeDAO().buscarPorId(rs.getInt("time_id"));

		return new Jogador(nome, posicao, idade, numCamisa, time);
	}

	public Collection<Jogador> listarPorTime(Time t) {
		Collection<Jogador> jogadores = new ArrayList<>();

		try (Connection c = abrir(); PreparedStatement ps = c.prepareStatement(sqlBuscaPorTime)) {
			ps.setInt(1, t.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jogadores.add(preencher(rs));
			}
			c.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return jogadores;
	}
}
