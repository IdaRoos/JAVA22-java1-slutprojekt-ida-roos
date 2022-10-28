package Slutprojekt;

import java.time.DayOfWeek;
import java.time.LocalDate;

class Date {

	public static LocalDate getDate(int x) {

		LocalDate today = LocalDate.now();

		LocalDate monday = today;
		while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
			monday = monday.minusDays(1);
		}

		return monday.plusDays(x);

	}

	public static String getDayOfWeek(int x) {

		LocalDate today = LocalDate.now();

		LocalDate monday = today;
		while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
			monday = monday.minusDays(1);

		}

		return monday.plusDays(x).getDayOfWeek().toString();

	}

}
