package challenge.support;

import java.time.LocalDate;

public class Player {

	private String name;
	private String club;
	private Integer age;
	private LocalDate birthDate;
	private String nationality;
	private Double wage;
	private Double releaseClause;

	public Player(String name, String club, Integer age, LocalDate birthDate, String nationality, Double wage,
			Double releaseClause) {
		setName(name);
		setClub(club);
		setAge(age);
		setBirthDate(birthDate);
		setNationality(nationality);
		setWage(wage);
		setReleaseClause(releaseClause);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public Double getReleaseClause() {
		return releaseClause;
	}

	public void setReleaseClause(Double releaseClause) {
		this.releaseClause = releaseClause;
	}

}
