package challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import challenge.support.FileLoader;
import challenge.support.Player;

/**
 * Desafio: Processe dados dos jogadores do FIFA(c) 2017 usando Java
 * (https://www.codenation.com.br/journey/backend/challenge/java-3.html)
 * 
 * Utilizando Java, você deverá descobrir quais são os melhores jogadores, quais
 * os mais valiosos e quais são suas nacionalidades.
 * 
 * Neste desafio você aprenderá: Java; Ler arquivo CSV; Processar grandes
 * quantidades de dados;
 */
public class Main {

	private final List<Player> playersList;

	public Main() {
		playersList = new ArrayList<>();
		FileLoader.loadTo(playersList);
	}

	/**
	 * @return Quantas nacionalidades (coluna 'nationality') diferentes existem no
	 *         arquivo
	 */
	public int q1() {
		return playersList.parallelStream()
				.map(Player::getNationality)
				.distinct()
				.collect(Collectors.toList())
				.size();
	}

	/**
	 * @return Quantos clubes (coluna 'club') diferentes existem no arquivo
	 * 
	 *         Obs: Existem jogadores sem clube.
	 */
	public int q2() {
		return playersList.parallelStream()
				.filter(players -> players.getClub() != null)
				.map(Player::getClub)
				.distinct()
				.collect(Collectors.toList())
				.size();
	}

	/**
	 * @return Lista com o primeiro nome (coluna 'full_name') dos 20 primeiros
	 *         jogadores.
	 */
	public List<String> q3() {
		return playersList.parallelStream()
				.map(Player::getName)
				.limit(20)
				.collect(Collectors.toList());
	}

	/**
	 * @return Lista com os top 10 jogadores que possuem as maiores clausulas de
	 *         rescisão
	 * 
	 *         (utilize as colunas 'full_name' e 'eur_release_clause')
	 */
	public List<String> q4() {
		return playersList.parallelStream()
				.sorted(Comparator.comparingDouble(Player::getReleaseClause).reversed())
				.limit(10)
				.map(Player::getName)
				.collect(Collectors.toList());
	}

	/**
	 * @return Lista com os 10 jogadores mais velhos (use como critério de desempate
	 *         o campo 'eur_wage')
	 * 
	 *         (utilize as colunas 'full_name' e 'birth_date')
	 */
	public List<String> q5() {
		return playersList.parallelStream()
				.sorted(Comparator.comparingDouble(Player::getWage))
				.sorted(Comparator.comparing(Player::getBirthDate))
				.limit(10)
				.map(Player::getName)
				.collect(Collectors.toList());
	}

	/**
	 * @return Mapa com contagem de jogadores existentes por idade (chave = idade,
	 *         valor = quantidade)
	 * 
	 *         (utilize a coluna 'age')
	 */
	public Map<Integer, Integer> q6() {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		playersList.parallelStream()
		.map(Player::getAge)
		.distinct()
		.forEach(keyAge -> map.put(keyAge, playersList.parallelStream()
				.map(Player::getAge)
				.filter(age -> age.equals(keyAge))
				.mapToInt(age -> 1)
				.sum()));
		
		return map;
	}

}
