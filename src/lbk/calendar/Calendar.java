package lbk.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAXDAY_OF_MONTH = {31,29,31,30,31,30,31,31,30,31,30,31};

	public int getMaxDayOfMonth(int month)
	{
		return(MAXDAY_OF_MONTH[month-1]);
	}
	public void prtSampleCalendar()
	{
		System.out.println(" 일  월  화  수  목  금  토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	
	}
	public static void main(String[] args) {
		
		//월을 입력받아 해당월의 마지막일자를 구하기
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("반복횠수를 입력하세요");
        int repeat = scanner.nextInt();
        for(int i=0; i < repeat;i++){
    		System.out.println("월을 입력하세요");
    		int month = scanner.nextInt();
    		Calendar cal = new Calendar();
    		System.out.printf("%d월의 마지막일은 %d입니다\n",month,cal.getMaxDayOfMonth(month));
        }
        System.out.println("Bye~~");
        
		scanner.close();

		//		샘플칼렌더 출력하기
//		cal.prtSampleCalendar();
	}

}
