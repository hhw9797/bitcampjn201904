package methodtest;

public class MethodTest1 {

	public static void main(String[] args) {

		num(3,5);
	}

	static void num(int i, int j) {
		System.out.println("i + j =" + (i + j));
		System.out.println("i - j =" + (i - j));
		System.out.println("i * j =" + (i * j));
		System.out.println("i / j =" + (i / j));
		System.out.println("i % j =" + (i % j));
		
		
	}
}
