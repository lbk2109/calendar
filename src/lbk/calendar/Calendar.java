package lbk.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAXDAY_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDayOfMonth(int month) {
		return (MAXDAY_OF_MONTH[month - 1]);
	}

	public void prtCalendar(int year, int month) {
		
		System.out.printf("<<%4d년%3d월>>\n",year,month);
		System.out.println(" SU MO TH WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDayOfMonth = getMaxDayOfMonth(month);
		for(int i=1; i <= maxDayOfMonth;i++)
		{
			System.out.printf("%3d",i);
			if(i%7 == 0 )
			{
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 월을 입력받아 해당월의 마지막일자를 구하기
		String PROMPT = "Cal> ";
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
			System.out.printf("%d월의 마지막일은 %d입니다\n", month, cal.getMaxDayOfMonth(month));
		}
		System.out.println("Bye~~");
		scanner.close();
	}

}
