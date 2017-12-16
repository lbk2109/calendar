package lbk.calendar;

import java.util.Scanner;

public class RunPrompt {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Year> ");
			int year = scanner.nextInt();

			System.out.print("Month> ");
			int month = scanner.nextInt();
			if (month < 1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			Calendar cal = new Calendar();
			cal.prtCalendar(year, month);
		}
		System.out.println("Bye~~");
		scanner.close();

	}

}
