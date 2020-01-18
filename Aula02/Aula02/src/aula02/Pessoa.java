package aula02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {
	
	private String nome;
	private String dataNasc;
	private String altura;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public int calculaIdade(String dataNasc, String pattern){

		DateFormat sdf = new SimpleDateFormat(pattern);

		Date dataNascInput = null;

		try {
			dataNascInput= sdf.parse(dataNasc);
			} catch (Exception e) {
				
			}
		
		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascInput);

		// Cria um objeto calendar com a data atual

		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano

		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
			}

		return age;

	}
	
}
