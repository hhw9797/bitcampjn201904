package test;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Test test = new Test();
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("정수를 입력하세요 :");
				arr[i]=sc.nextInt();
			}
		
		System.out.println("최솟값은"+test.miniValue(arr)+"입니다.");
		System.out.println("최댓값은"+test.maxValue(arr)+"입니다.");
	}

}
