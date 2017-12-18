package lbk.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class RunPrompt {

	public static void printMenu() {

		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록                ");
		System.out.println("| 2. 일정 검색                ");
		System.out.println("| 3. 달력 보기                ");
		System.out.println("| h. 도움말 q. 종료          ");
		System.out.println("+----------------------+");
	}

	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}

	public static void main(String[] args) throws ParseException {

		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명렬:(1,2,3,h,q)");
			String cmd = scanner.next();

			switch (cmd) {
			case "1":
				cmdResister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.printf("Bye~~\n\n\n");
		scanner.close();
	}

	private static void cmdCal(Scanner s, Calendar c) {
		int year = 2017;
		int month = -1;

		while (true) {
			System.out.println("년도를 입력하세요.(-1:종료)");
			System.out.print("Year> ");
			year = s.nextInt();

			System.out.println("월을 입력하세요.");
			System.out.print("Month> ");
			month = s.nextInt();
			if (month > 12 || month < 1) {
				System.out.printf("잘못된 월의 입력입니다.\n\n\n");
				return;
			}

			c.prtCalendar(year, month);
		}
	}

	private static void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd)");
		String date = s.next();
		PlanItem plan = c.SearchPlan(date);
		if (plan != null)
			System.out.println(plan.detail);
		else
			System.out.println("일정이 없습니다.");
	}

	private static void cmdResister(Scanner s, Calendar c) throws ParseException {
		System.out.println("[새해일정 등록]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd)");
		String date = s.next();

		System.out.println("입정을 입력해주세요.(문장의 끝에 ;을 입력해주세요!)");
		String text = "";
		
		String word;
		while(!(word=s.next()).endsWith(";"))
		{
			text += word + " ";
		}
		word = word.replace(";"	, "");
		text += word;

		c.registerPlan(date, text);

	}

}
