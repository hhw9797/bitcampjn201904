import java.util.Scanner; // 클래스를 사용하기 위해 import 선언

public class KeyboardTest {

	public static void main(String[] args) {
		
		Scanner sc;
		sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			System.out.println("첫번째 숫자를 입력해 주세요.");
			String name = sc.nextLine();//대기
			System.out.printf(name);
		}
		
		sc.close();

	}

}
