package aula02;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		exercicio01();
		
	}
	
	public static void exercicio01() {
		//Exercicio 01
		Pessoa pessoa1 = new Pessoa();
				
		System.out.println("Digite o nome: ");
		Scanner teclado = new Scanner(System.in);
		pessoa1.setNome(teclado.nextLine());
				
		System.out.println("Digite a data de nascimento (dd/MM/yy): ");
		pessoa1.setDataNasc(teclado.nextLine());
				
		System.out.println("Digite a altura (metros):  ");
		pessoa1.setAltura(teclado.nextLine());
				
		System.out.println("***** INFORMAÇÕES PESSOA CADASTRADA *****");
		System.out.println("Nome: " + pessoa1.getNome());
		System.out.println("Data de nascimento: " + pessoa1.getDataNasc());
		System.out.println("Altura: " + pessoa1.getAltura() + " metros");
		System.out.println("Idade: " + pessoa1.calculaIdade(pessoa1.getDataNasc(), "dd/MM/yy") + " anos");
	}
}
