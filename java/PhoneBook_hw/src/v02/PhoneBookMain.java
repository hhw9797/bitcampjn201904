package v02;

import java.util.Scanner;

class PhoneBookMain {
	
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 1. 프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성
		// 2. 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
		// 3. 프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
		
		// java.util.Scanner keyboard;
		//Scanner keyboard = new Scanner(System.in);
		
		while(true) {	
			System.out.println("==================");
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 입력 , 2. 종료");
			System.out.println("==================");
			
			int choice = keyboard.nextInt();
			
			if(choice == 1) {
				//입력 처리
				insertMember();
			} else if(choice == 2) {
				System.out.println("프로그램 종료");
				return; // 메인메서드 종료 -> 프로그램의 종료
			} else {
				// 메뉴 선택으로 이동
				System.out.println("정상적인 메뉴번호를 입력해주세요.");
			}
			
		}

	}
	static void insertMember() {
		// 입력 받기 -> 인스턴스 생성 -> 출력
				// 현재 입력 스캐너의 버너를 삭제
		// 1
		keyboard.nextLine();
		
		// 사용자의 입력 데이터 임시 저장
		String name = null; // null은 지역변수의 경우 초기화를 해주고 가자는 의미.
		String pNumber = null;
		String birthday = null;
		
		System.out.println("데이터 입력");
		System.out.println("친구의 이름을 입력해 주세요.");
		name = keyboard.nextLine();
		
		System.out.println("친구의 전화번호를 입력해 주세요.");
		pNumber = keyboard.nextLine();
		
		System.out.println("친구의 생일을 입력해 주세요.");
		birthday = keyboard.nextLine();
		
		//사용자로부터 입력받은 데이터로 인스턴스 생성 ( 객체의 변수에 저장 )
		PhoneInfo pi = null;
		
		// 생일이 null이거나 문자의 길이가 1보다 작을 때(공백일 떄)
		if(birthday == null || birthday.trim().length()<1) { 
			//pi = new PhoneInfo(name, pNumber);
			pi = new PhoneInfo(name, pNumber);
		} else {
			pi = new PhoneInfo(name, pNumber, birthday);
		}
		
		pi.showInfo();
	}
}
