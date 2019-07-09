package methodtest;

public class MethodTest4 {

	public static void main(String[] args) {
		for (int num1=1; num1<=100; num1++) {
			if(checkNum(num1)) {
				System.out.println(num1);
		}
	}
}
	static boolean checkNum(int num2) {
		boolean check = true;
		
		if (num2 > 2) {
			for (int num1 = 2; num1 < num2 ; num1++) {
				if (num2 % num1 == 0 ) {
					check = false;
				}
			}
		}

		return check;
		
	}

	}
