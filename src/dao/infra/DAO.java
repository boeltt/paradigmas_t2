package dao.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;

public abstract class DAO<T> {
	private String sqlInsercao;
	private String sqlAlteracao;
	private String sqlExclusao;
	private String sqlBusca;
	private String sqlExclusaoTodos;
	private String sqlBuscaTodos;

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

	public String getSqlBuscaTodos() {
		return sqlBuscaTodos;
	}

	public void setSqlBuscaTodos(String sqlBuscaTodos) {
		this.sqlBuscaTodos = sqlBuscaTodos;
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

	public void inserir(T t) {
		try (var con = abrir(); var ps = con.prepareStatement(getSqlInsercao())) {
			doInserir(ps, t);
			ps.execute();
			System.out.println("Inserido.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(T t) {
		try (var con = abrir(); var ps = con.prepareStatement(getSqlAlteracao())) {
			doAlterar(ps, t);
			ps.execute();
			System.out.println("Alterado.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(T t) {
		try (var con = abrir(); var ps = con.prepareStatement(getSqlAlteracao())) {
			doExcluir(ps, t);
			ps.execute();
			System.out.println("Excluído.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTodos() {
		try (var con = abrir(); var s = con.createStatement();) {
			s.execute(getSqlExclusaoTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T buscar(T t) {
		T temp = null;
		try (var con = abrir(); var ps = con.prepareStatement(getSqlBusca())) {
			doExcluir(ps, t);
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
				return null;
			temp = preencher(rs);
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Collection<T> buscar(String sql) throws SQLException{
		var retorno = new ArrayList<T>();
		try (var con = abrir(); var s = con.createStatement(); var rs = s.executeQuery(sql)) {
			while(rs.next()) {
				retorno.add(preencher(rs));
			}
			return retorno;
		}
	}
	
	public Collection<T> buscarTodos() throws SQLException {
		return buscar(getSqlBuscaTodos());
	}

	protected abstract void doInserir(PreparedStatement ps, T t) throws SQLException;

	protected abstract void doAlterar(PreparedStatement ps, T t) throws SQLException;

	protected abstract void doExcluir(PreparedStatement ps, T t) throws SQLException;
	
	protected abstract T preencher(ResultSet rs) throws SQLException;
}
