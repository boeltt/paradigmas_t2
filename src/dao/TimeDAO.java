package dao;

import java.sql.PreparedStatement;
import java.sql.Time;
import dao.infra.DAO;

public class TimeDAO extends DAO<Time>{
	public TimeDAO() {
		setSqlInsercao("INSERT INTO time (nome, estadio, cidade, dataFund) VALUES (?, ?, ?, ?)");
		setSqlAlteracao("UPDATE time SET estadio = ?, cidade = ?, treinador = ?");
		setSqlExclusao("DELETE FROM time WHERE nome = ?");
		setSqlBusca("SELECT * FROM time WHERE nome = ?");
		setSqlExclusaoTodos("DELETE FROM time");
		
		//TODO: Metodos da classe filha...
	}
}
