package lbk.calendar;

import java.util.Scanner;

public class RunPrompt {

	/**
	 * 
	 * @param week:요일
	 *            
	 * @return : 0~6 :0 일요일,1월요일 .. 6토요일
	 */
	public static int parseDay(String week) {
		if (week.equals("su"))
			return 0;
		else if (week.equals("mo"))
			return 1;
		else if (week.equals("tu"))
			return 2;
		else if (week.equals("we"))
			return 3;
		else if (week.equals("th"))
			return 4;
		else if (week.equals("fr"))
			return 5;
		else if (week.equals("sa"))
			return 6;
		else
			return -1;
	}

	public static void main(String[] args) {

		int year = 2017;
		int month = -1;
		int weekday = 0;

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("년도를 입력하세요.(-1:종료)");
			System.out.print("Year> ");
			year = scanner.nextInt();
			if (year < 1)
			{
				System.out.printf("\n\n\n");
				break;
			}

			System.out.println("월을 입력하세요.");
			System.out.print("Month> ");
			month = scanner.nextInt();
			if (month > 12 || month < 1)
			{
				System.out.printf("잘못된 월의 입력입니다.\n\n\n");
				continue;
			}

			System.out.println("첫째낭의 요일을 입력하세요(su mo tu we th fr sa).");
			System.out.print("WEEK> ");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			if (weekday < 0)
			{
				System.out.print("잘못된 첫째낭의 요일을 입력입니다.\n\n\n");
				continue;
			}	

			Calendar cal = new Calendar();
			cal.prtCalendar(year, month, weekday);
		}
		System.out.printf("Bye~~\n\n\n");
		scanner.close();

	}

}
