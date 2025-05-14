package cliente;

import java.sql.SQLException;

import dao.*;
import entidades.*;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		var times = new TimeDAO();
		var jogadores = new JogadorDAO();
		var treinadores = new TreinadorDAO();
		var partidas = new PartidaDAO();
		
		times.buscarTodos().forEach(System.out::println);
		jogadores.buscarTodos().forEach(System.out::println);
		treinadores.buscarTodos().forEach(System.out::println);
		partidas.buscarTodos().forEach(System.out::println);
		
		times.excluirTodos();
		jogadores.excluirTodos();
		treinadores.excluirTodos();
		partidas.excluirTodos();
		
		times.buscarTodos().forEach(System.out::println);
		jogadores.buscarTodos().forEach(System.out::println);
		treinadores.buscarTodos().forEach(System.out::println);
		partidas.buscarTodos().forEach(System.out::println);
	}

}
