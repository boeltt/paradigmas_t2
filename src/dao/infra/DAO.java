package dao.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {
	private String sqlInsercao;
	private String sqlAlteracao;
	private String sqlExclusao;
	private String sqlBusca;
	private String sqlExclusaoTodos;

	public String getSqlInsercao() {
		return sqlInsercao;
	}

	public void setSqlInsercao(String sqlInsercao) {
		this.sqlInsercao = sqlInsercao;
	}

	public String getSqlAlteracao() {
		return sqlAlteracao;
	}

	public void setSqlAlteracao(String sqlAlteracao) {
		this.sqlAlteracao = sqlAlteracao;
	}

	public String getSqlExclusao() {
		return sqlExclusao;
	}

	public void setSqlExclusao(String sqlExclusao) {
		this.sqlExclusao = sqlExclusao;
	}

	public String getSqlExclusaoTodos() {
		return sqlExclusaoTodos;
	}

	public void setSqlExclusaoTodos(String sqlExclusaoTodos) {
		this.sqlExclusaoTodos = sqlExclusaoTodos;
	}

	public String getSqlBusca() {
		return sqlBusca;
	}

	public void setSqlBusca(String sqlBusca) {
		this.sqlBusca = sqlBusca;
	}

	public Connection abrir() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(BD.URL_CONEXAO, BD.USUARIO, BD.SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	//TODO: Metodos de insercao, remocao, etc...
}
