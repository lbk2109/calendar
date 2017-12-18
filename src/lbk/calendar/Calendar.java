package lbk.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAXDAY_OF_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] MAXDAY_OF_LEAP_MONTH = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 
	private HashMap<Date, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, String>();
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		return false;
	}

	public int getMaxDayOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return (MAXDAY_OF_LEAP_MONTH[month-1]);
		}
		return (MAXDAY_OF_MONTH[month-1]);
	}

	public void prtCalendar(int year, int month) {

		System.out.printf("<<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int weekday = getWeekDay(year, month, 1);

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

	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970년 1월 1일 : 화요일

		int count = 0;
		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDayOfMonth(year, i);
			count += delta;
		}
		count += day - 1;

		int weekday = (count + STANDARD_WEEKDAY) % 7;

		return weekday;
	}
	
	public void registerPlan(String strdate, String plan) throws ParseException
	{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strdate);
		System.out.println(date);
		
		planMap.put(date, plan);
	}
	
	public String SearchPlan(String strdate) throws ParseException
	{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strdate);
		String plan = planMap.get(date);
		return (plan);
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		System.out.println(cal.getWeekDay(1970, 1, 1) == 4);
		System.out.println(cal.getWeekDay(1971, 1, 1) == 5);
		System.out.println(cal.getWeekDay(1972, 1, 1) == 6);
		System.out.println(cal.getWeekDay(1973, 1, 1) == 1);
		System.out.println(cal.getWeekDay(1974, 1, 1) == 2);

		cal.registerPlan("2017-12-20","월급날!!ㅎㅎ");		
		System.out.println(cal.SearchPlan("2017-12-20").equals("월급날!!ㅎㅎ"));
	}
}
