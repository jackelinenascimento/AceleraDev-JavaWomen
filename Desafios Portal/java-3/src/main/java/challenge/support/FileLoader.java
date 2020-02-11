package challenge.support;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FileLoader {

	private static final String PATH = System.getProperty("user.dir") + "/src/main/resources/data.csv";
	private static final int INDEX_FULL_NAME = 2;
	private static final int INDEX_CLUB = 3;
	private static final int INDEX_AGE = 6;
	private static final int INDEX_BIRTH_DATE = 8;
	private static final int INDEX_NATIONALITY = 14;
	private static final int INDEX_WAGE = 17;
	private static final int INDEX_RELEASE_CLAUSE = 18;

	public static final void loadTo(List<Player> list) {
		try (BufferedReader in = new BufferedReader(new FileReader(PATH))) {
			in.readLine();

			String wholeLine = in.readLine();
			while (wholeLine != null) {

				String name;
				String club;
				Integer age;
				LocalDate birthDate;
				String nationality;
				Double wage;
				Double releaseClause = 0d;

				String[] line = wholeLine.split(",");

				name = line[INDEX_FULL_NAME];

				club = line[INDEX_CLUB].toLowerCase();
				if (club.length() == 0) {
					club = null;
				}

				age = Integer.parseInt(line[INDEX_AGE]);

				String[] date = line[INDEX_BIRTH_DATE].split("-");
				int year = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);
				int day = Integer.parseInt(date[2]);
				birthDate = LocalDate.of(year, month, day);

				nationality = line[INDEX_NATIONALITY].toLowerCase();

				wage = Double.parseDouble(line[INDEX_WAGE]);

				if (line[INDEX_RELEASE_CLAUSE].length() != 0) {
					releaseClause = Double.parseDouble(line[INDEX_RELEASE_CLAUSE]);
				}

				list.add(new Player(name, club, age, birthDate, nationality, wage, releaseClause));

				wholeLine = in.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
