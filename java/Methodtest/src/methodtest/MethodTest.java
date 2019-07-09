package methodtest;

public class MethodTest {

	public static void main(String[] args) {//main 메서드 안에서 모든 메서드나 객체를 호출하고 만듬
			//static은 프로그램 시작시에 메모리에 저장 반드시 필요함
			//public은 누구나 제약없음
		System.out.println("프로그램 시작합니다.");
		
		hiEveryone(12);
		hiEveryone(15);
		System.out.println("프로그램 종료");
		

	}
	
	static void hiEveryone(int age) {// age 나이 값을 받아서 출력하고자 하는 목적
		//static을 붙여줘야 실행이 됨
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 " + age + "세 입니다.");
	}
	

}
