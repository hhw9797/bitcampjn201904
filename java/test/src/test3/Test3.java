package test3;

public class Test3 {


	public static void changeArr(int[][] arr) {

		int[] temp = new int[arr[0].length];
		temp = arr[arr.length - 1];
		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}

		arr[0] = temp;

	}

}
