package cliente;

import java.sql.SQLException;
import java.util.*;

import dao.*;
import entidades.*;
import util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		var times = new TimeDAO();
		var jogadores = new JogadorDAO();
		var treinadores = new TreinadorDAO();
		var partidas = new PartidaDAO();

		jogadores.excluirTodos();
		treinadores.excluirTodos();
		partidas.excluirTodos();
		times.excluirTodos();

		// Pedi pro chatGPT popular, demora uns segundos mas funciona
		Time[] ts = { new Time("Grêmio", "Arena", "Porto Alegre", "1903-09-15"),
				new Time("Internacional", "Beira-Rio", "Porto Alegre", "1909-04-04"),
				new Time("Palmeiras", "Allianz Parque", "São Paulo", "1914-08-26"),
				new Time("Flamengo", "Maracanã", "Rio de Janeiro", "1895-11-15"),
				new Time("Corinthians", "Neo Química Arena", "São Paulo", "1910-09-01"),
				new Time("Cruzeiro", "Mineirão", "Belo Horizonte", "1921-01-02") };

		for (int i = 0; i < ts.length; i++) {
			times.inserirERetornarId(ts[i]);
		}

		String[] tecnicos = { "Renato", "Coudet", "Abel", "Tite", "Luxemburgo", "Pepa" };
		for (int i = 0; i < ts.length; i++) {
			treinadores.inserir(new Treinador(tecnicos[i], ts[i]));
		}

		jogadores.inserir(new Jogador("Suárez", "Atacante", 37, 9, ts[0]));
		jogadores.inserir(new Jogador("Kannemann", "Zagueiro", 32, 4, ts[0]));

		jogadores.inserir(new Jogador("Alan Patrick", "Meia", 33, 10, ts[1]));
		jogadores.inserir(new Jogador("Rochet", "Goleiro", 31, 1, ts[1]));

		jogadores.inserir(new Jogador("Raphael Veiga", "Meia", 29, 23, ts[2]));
		jogadores.inserir(new Jogador("Gustavo Gómez", "Zagueiro", 30, 15, ts[2]));

		jogadores.inserir(new Jogador("Gabigol", "Atacante", 28, 10, ts[3]));
		jogadores.inserir(new Jogador("Arrascaeta", "Meia", 30, 14, ts[3]));

		jogadores.inserir(new Jogador("Cássio", "Goleiro", 36, 1, ts[4]));
		jogadores.inserir(new Jogador("Fagner", "Lateral", 33, 23, ts[4]));

		jogadores.inserir(new Jogador("Rafael Cabral", "Goleiro", 33, 1, ts[5]));
		jogadores.inserir(new Jogador("Bruno Rodrigues", "Atacante", 26, 9, ts[5]));

		Partida[] ps = { new Partida(1, ts[0], ts[1], 2, 1), new Partida(2, ts[2], ts[3], 1, 1),
				new Partida(3, ts[4], ts[5], 0, 2), new Partida(4, ts[0], ts[2], 3, 2),
				new Partida(5, ts[1], ts[3], 0, 0), new Partida(6, ts[4], ts[0], 1, 4),
				new Partida(7, ts[1], ts[5], 2, 2), new Partida(8, ts[3], ts[4], 2, 1),
				new Partida(9, ts[2], ts[5], 1, 0), new Partida(10, ts[3], ts[0], 1, 1),
				new Partida(11, ts[5], ts[0], 0, 2), new Partida(12, ts[1], ts[4], 1, 3),
				new Partida(13, ts[2], ts[4], 2, 2), new Partida(14, ts[3], ts[5], 3, 1),
				new Partida(15, ts[2], ts[1], 0, 1) };

		for (Partida p : ps) {
			partidas.inserir(p);
		}
		
		times.buscarTodos().forEach(System.out::println);
		jogadores.buscarTodos().forEach(System.out::println);
		treinadores.buscarTodos().forEach(System.out::println);
		partidas.buscarTodos().forEach(System.out::println);
		System.out.println("\n".repeat(5));

		List<Partida> partidasListadas = new ArrayList<>(partidas.buscarTodos());
		Map<Time, Integer> tabela = Classificacao.gerarClassificacao(partidasListadas);
		tabela.forEach((time, pontos) -> System.out.println(time.getNome() + ": " + pontos + " pontos"));

		jogadores.excluirTodos();
		treinadores.excluirTodos();
		partidas.excluirTodos();
		times.excluirTodos();
	}

}
