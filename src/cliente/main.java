package cliente;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Collection;
//import java.util.List;

import dao.*;
import entidades.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		var times = new TimeDAO();
		var jogadores = new JogadorDAO();
		var treinadores = new TreinadorDAO();
		var partidas = new PartidaDAO();

		

		Time t1 = new Time("Grêmio", "Arena", "Porto Alegre", "1903-09-15");
		times.inserirERetornarId(t1);
		Time t2 = new Time("Internacional", "Beira-Rio", "Porto Alegre", "1909-04-04");
		times.inserirERetornarId(t2);

		Treinador tr1 = new Treinador("Renato", t1);
		Treinador tr2 = new Treinador("Coudet", t2);
		treinadores.inserir(tr1);
		treinadores.inserir(tr2);

		Jogador j1 = new Jogador("Suárez", "Atacante", 37, 10, t1);
		Jogador j2 = new Jogador("Alan Patrick", "Goleiro", 33, 1, t2);
		jogadores.inserir(j1);
		jogadores.inserir(j2);

		Partida p1 = new Partida(1, t1, t2, 2, 1);
		partidas.inserir(p1);

		times.buscarTodos().forEach(System.out::println);
		jogadores.buscarTodos().forEach(System.out::println);
		treinadores.buscarTodos().forEach(System.out::println);
		partidas.buscarTodos().forEach(System.out::println);
		System.out.println("\n".repeat(5));

		Collection<Jogador> jogadoresT1 = jogadores.listarPorTime(t1);
		jogadoresT1.forEach(System.out::println);

		jogadores.excluirTodos();
		times.excluirTodos();
		treinadores.excluirTodos();
		partidas.excluirTodos();
		System.out.println("\n".repeat(5));

		// Pedi pro ChatGPT popular pra testar tudo, demora mas funciona e testa o
		// limite dos 25.
		// Tem dois imports comentados também pra isso aqui funcionar tem que ativar as
		// linhas de novo
		/*
		 * String[] nomesTimes = {"Grêmio", "Internacional", "Palmeiras", "Flamengo",
		 * "Corinthians", "Cruzeiro"}; String[] estadios = {"Arena", "Beira-Rio",
		 * "Allianz Parque", "Maracanã", "Neo Química", "Mineirão"}; String[] cidades =
		 * {"Porto Alegre", "Porto Alegre", "São Paulo", "Rio de Janeiro", "São Paulo",
		 * "Belo Horizonte"}; String[] treinadoresNomes = {"Renato", "Coudet", "Abel",
		 * "Tite", "Luxemburgo", "Pepa"};
		 * 
		 * List<Time> listaTimes = new ArrayList<>();
		 * 
		 * for (int i = 0; i < nomesTimes.length; i++) { Time t = new
		 * Time(nomesTimes[i], estadios[i], cidades[i], "2000-01-01");
		 * times.inserirERetornarId(t); listaTimes.add(t);
		 * 
		 * Treinador treinador = new Treinador(treinadoresNomes[i], t);
		 * treinadores.inserir(treinador);
		 * 
		 * int jogadoresParaInserir = (i == nomesTimes.length - 1) ? 26 : 20;
		 * 
		 * for (int j = 1; j <= jogadoresParaInserir; j++) { Jogador jogador = new
		 * Jogador( "Jogador" + j + "_" + nomesTimes[i], "Posição" + (j % 5), 20 + (j %
		 * 10), j, t ); try { jogadores.inserir(jogador); } catch (IllegalStateException
		 * e) { System.out.println("ERRO ao inserir jogador " + jogador.getNome() + ": "
		 * + e.getMessage()); } } }
		 * 
		 * times.buscarTodos().forEach(System.out::println);
		 * jogadores.buscarTodos().forEach(System.out::println);
		 * treinadores.buscarTodos().forEach(System.out::println);
		 * partidas.buscarTodos().forEach(System.out::println);
		 * System.out.println("\n".repeat(5));
		 * 
		 * Collection<Jogador> jogadoresTime =
		 * jogadores.listarPorTime(listaTimes.get(3));
		 * jogadoresTime.forEach(System.out::println);
		 */

	}

}
