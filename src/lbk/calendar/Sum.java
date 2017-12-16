package lbk.calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// 두수를 입력받는다
		Scanner scanner = new Scanner(System.in);
        System.out.println("두수를 입력하세요");		
		String s1 = scanner.next();
		String s2 = scanner.next();
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		scanner.close();

		// 두수의 합을구해서 출력한다
		System.out.printf("두수 %d와 %d의 합은 %d입니다",a,b,a+b				);

	}

}
