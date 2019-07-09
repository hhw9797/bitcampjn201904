package v03;

import util.Util;

public class PhoneBookmanager {

	final PhoneInfo[] pb;
	int cnt;

	public PhoneBookmanager() {
		pb = new PhoneInfo[100];
		cnt = 0;
	}

	public PhoneBookmanager(int size) {
		pb = new PhoneInfo[size];
		cnt = 0;
	}
	
	public void insertMember() {
		System.out.println("친구정보입력");
		System.out.println("친구의 이름을 입력해주세요.");
		String name=Util.keyboard.nextLine();
		
		System.out.println("친구의 전화번호를 입력해주세요.");
		String phoneNumber=Util.keyboard.nextLine();
		
		System.out.println("친구의 생일을 입력해주세요.");
		String birthday=Util.keyboard.nextLine();

		PhoneInfo pi = null;

		if (birthday == null || birthday.trim().length() < 1) {
			// pi = new PhoneInfo(name, pNum);

			pb[cnt++] = new PhoneInfo(name, phoneNumber);

		} else {
			// pi = new PhoneInfo(name, pNum, birthday);

			pb[cnt++] = new PhoneInfo(name, phoneNumber, birthday);
		}

		// 배열에 저장 : PhoneInfo[] 저장 -> PhoneInfo 참조값을 저장
		pb[cnt] = pi;

		System.out.println("입력하신 정보가 저장되었습니다.");

		System.out.println("===================");
		for (int i = 0; i < cnt; i++) {
			pb[i].showInfo();
			System.out.println("---------------");
		}
		System.out.println("===================");
	}

	// 배열에 저장된 모든 정보를 출력
	public void showAllData() {

		System.out.println("===================");

		if (cnt > 0) {// 저장되어있을 때 출력이니까 배열이 아닌 cnt
			for (int i = 0; i < cnt; i++) {
				pb[i].showInfo();
				System.out.println("---------------");
			}
		} else {
			System.out.println("등록된 친구 정보가 없습니다.");
		}

		System.out.println("===================");

	}

	public void searchPrint() {

		System.out.println("검색할 친구의 이름을 입력해 주세요.");
		String name = Util.keyboard.nextLine();

		int index = searchIndex(name);

		// 검색된 index 값을 비교하고 정보 출력
		if (index < 0) { // 0보다 작을 때 = 칮지 못했을 때
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else { // 찾고자 하는 배열의 사이즈
			pb[index].showInfo();
		}
	}

	public void searchDelete() {

		System.out.println("삭제하고자 하는 친구의 이름을 입력해주세요.");
		String name = Util.keyboard.nextLine();

		int index = -1;// 찾고자 하는 인덱스 변수 만들기

		for (int i = 0; i < cnt; i++) {
			if (pb[i].name.equals(name)) {
				index = i;
			}
		}

		if (index < 0) {
			System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
		} else {

			// 삭제 : 검색한 index 부터 저장된 위치까지 왼쪽으로 시프트 처리
			for (int i = index; i < cnt - 1; i++) { // cnt로 해도 상관은 없지만 cnt-1이 맞음
				pb[i] = pb[i + 1];
			}

			// 저장된 친구 정보의 개수 감소
			cnt--;

			System.out.println("요청하신 이름의 정보를 삭제했습니다."); // 삭제가 된 후에 출력해야함 else 부붙에

		}

	}
	//키워드로 배열의 요소.name 문자열과 비교 후 매칭되는 요소의 index를 반환
	public int searchIndex(String keyword) {

		// 검색 결과의 index : -1 ( 검색의 결과가 없다 )
		int index = -1;

		// 배열에서 문자열 비교 후 같은 값을 가지는 객체의 index 값을 구하는 기능
		for (int i = 0; i < cnt; i++) {
			// 비교
			if (pb[i].name.equals(keyword)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int printMenu() {
		System.out.println("==================================");
		System.out.println("메뉴 번호를 선택해 주세요.");
		System.out.printf("%d. 입력\n%d. 검색\n%d. 삭제\n%d. 전체 정보 출력\n%d. 종료\n", Util.INSERT, Util.SEARCH, Util.DELETE,
				Util.ALLDATA, Util.QUIT);
		System.out.println("==================================");

		int choice = Util.keyboard.nextInt();

		Util.keyboard.nextLine();// printMenu에 선언해주면 메소드 하나하나 선언할 필요 없음

		return choice;

	}

}
