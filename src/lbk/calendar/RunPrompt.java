package lbk.calendar;

import java.util.Scanner;

public class RunPrompt {

	private static String PROMPT = "Cal> ";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month < 1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			Calendar cal = new Calendar();
			cal.prtCalendar(2017, month);
		}
		System.out.println("Bye~~");
		scanner.close();

	}

}
