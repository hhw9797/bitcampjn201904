package test3;

public class Test3Main {

	public static void main(String[] args) {

		int[][] arr = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 },
				{ 10, 11, 12 },
				{ 13, 14, 15 }
		};

		System.out.println("----------------------------------");
		System.out.println("자리이동");
		System.out.println("------------------------------------");

		Test3.changeArr(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
