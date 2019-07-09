package v03;

import util.Util;

class PhoneBookMain {

	static PhoneInfo[] pb = new PhoneInfo[100];

	static int cnt = 0;

	public static void main(String[] args) {

	}

	public static void InsertMember() {
		System.out.println("<데이터 입력>");
		System.out.println("친구의 이름을 입력해 주세요.");
		Util.keyboard.nextLine();

		System.out.println("친구의 전화번호를 입력해 주세요.");
		Util.keyboard.nextLine();

		System.out.println("친구의 생일을 입력해 주세요.");
		Util.keyboard.nextLine();
	}

	public static void showData() {

		if (cnt > 0) {
			for (int i = 0; i < cnt; i++) {
				pb[i].showInfo();
			}
		} else {
			System.out.println("등록된 정보가 없습니다.");
		}
	}

	public static void searchPrint() {
		System.out.println("검색할 친구의 이름을 입력하세요.");
		String name = Util.keyboard.nextLine();

		int index = -1;

		for (int i = 0; i < cnt; i++) {
		
			if (pb[i].name.equals(name)) {
				index = i;
				break;
			}
		}
		
		if (index < 0) {
			System.out.println("검색한 친구의 정보가 없습니다.");
		} else {
			pb[index].showInfo();
		}
	}

	
	public static void searchDelete() {
		System.out.println("삭제할 친구의 이름을 입력하세요.");
		String name = Util.keyboard.nextLine();
		
		int index = -1;
		
		for(int i=0; i<cnt; i++) {
			
			if(pb[i].name.equals(name)) {
				index = i;
			
				break;
			}
		}
		
		if (index < 0) {
			System.out.println("삭제할 친구의 정보가 없습니다.");
		} else {
			for(int i=index; i<cnt-1; i++) {
				pb[i]=pb[i+1];
			}
			cnt--;
			System.out.println("요청하신 친구의 정보가 삭제되었습니다.");
		}
	}
	
	public static int printMenu() {
		System.out.println("==================================");
		System.out.println("메뉴 번호를 선택해 주세요.");
		System.out.println("1. 입력\n2. 검색\n3. 삭제\n4. 전체 정보 출력\n5. 종료");
		System.out.println("==================================");

		int choice = Util.keyboard.nextInt();
		
		Util.keyboard.nextLine();

		return choice;

	}
	
	
}
