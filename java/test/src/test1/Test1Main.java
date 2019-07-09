package test1;

import java.util.Scanner;

public class Test1Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Test1 test1 = new Test1(); 

		int[][] arr = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9},
		};
		
		System.out.print("정수를 입력하세요 :");
		int add=sc.nextInt();
		
		test1.addOneDArr(arr, add);
		test1.addPrint(arr);
		
	}

}
