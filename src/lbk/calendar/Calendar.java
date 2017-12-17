package lbk.calendar;

public class Calendar {

	private static final int[] MAXDAY_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] MAXDAY_OF_LEAP_MONTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}

	public int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return (MAXDAY_OF_LEAP_MONTH[month - 1]);
		}
		return (MAXDAY_OF_MONTH[month - 1]);
	}

	public void prtCalendar(int year, int month, int weekday) {

		System.out.printf("<<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		// 공백끼워넣기 " "
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDayOfMonth = getMaxDayOfMonth(year, month);

		int count = 7 - weekday;
		
		int dellim = (count < 7) ? count : 0;
		
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int i = count + 1; i <= maxDayOfMonth; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == dellim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("---------------------");
		System.out.println();

	}
}
