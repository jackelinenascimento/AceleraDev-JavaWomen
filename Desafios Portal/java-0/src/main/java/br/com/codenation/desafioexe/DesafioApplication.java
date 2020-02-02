package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		
		List<Integer> sequencia = new ArrayList<Integer>();
		
		sequencia.add(0);
		sequencia.add(1);
		
		for (int i=2; i<15; i++) {
			sequencia.add(sequencia.get(i-1)+sequencia.get(i-2));
		}
		
		return sequencia;
	}

	public static Boolean isFibonacci(Integer a) {
		
		List<Integer> sequencia = new ArrayList<Integer>();
		sequencia = fibonacci();
		
		return sequencia.contains(a);
	}

}