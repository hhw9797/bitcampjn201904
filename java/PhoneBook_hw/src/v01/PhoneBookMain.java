package v01;

class PhoneBookMain {

	public static void main(String[] args) {
		
		// 친구의 데이터를 저장하고 출력하는 프로그램
		
		PhoneInfo pi1 = new PhoneInfo("한혜원", "01011112222", "19970907");
		PhoneInfo pi2 = new PhoneInfo("강다희", "01022223333", "19970325");
		
		pi1.showInfo();
		System.out.println("======================");
		pi2.showInfo();
		
	}

}
