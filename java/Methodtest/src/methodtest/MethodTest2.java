package methodtest;

public class MethodTest2 {

	public static void main(String[] args) {
		num(-5,10);
	}
	
	public static void num(int a, int b) {
		System.out.println(a + "의 절대값은" + (a>=0 ? a:-a));
		System.out.println(b + "의 절대값은" + (b>=0 ? b:-b));
	}

}
