package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.infra.DAO;
import entidades.Jogador;

public class JogadorDAO extends DAO<Jogador> {
	
	public JogadorDAO() {
		setSqlInsercao("INSERT INTO jogador (nome, posicao, idade, numCamisa, id_time VALUES (?, ?, ?, ?, ?");
		setSqlAlteracao("UPDATE jogador SET posicao = ?, idade = ?, id_time = ?");
		setSqlBusca("SELECT * FROM jogador WHERE nome = ?");
		setSqlBuscaTodos("SELECT * FROM jogador");
		setSqlExclusao("DELETE FROM jogador WHERE nome = ?");
		setSqlExclusaoTodos("DELETE * FROM jogador");
	}
	
	protected void inserir(PreparedStatement ps, Jogador j) throws SQLException{
		ps.setString(1, j.getNome());
		ps.setString(2, j.getPosicao());
		ps.setInt(3, j.getIdade());
		ps.setInt(4, j.getNumCamisa());
		ps.setInt(5, j.getTime().getId());
	}
	
	protected void alterar(PreparedStatement ps, Jogador j) throws SQLException{
		ps.setString(1, j.getPosicao());
		ps.setInt(2, j.getIdade());
		ps.setInt(3, j.getTime().getId());
	}
	
	protected void buscar(PreparedStatement ps, Jogador j) throws SQLException{
		ps.setString(1, j.getNome());
	}
	
	protected void excluir(PreparedStatement ps, Jogador j) throws SQLException{
		ps.setString(1, j.getNome());
	}
}
