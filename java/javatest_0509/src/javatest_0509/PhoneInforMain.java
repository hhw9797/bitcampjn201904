package javatest_0509;

public class PhoneInforMain {

	public static void main(String[] args) {
		
		  PhoneInfor user1 = new PhoneInfor("한혜원", "010-1111-2222","9월 07일");
		  PhoneInfor user2 = new PhoneInfor("김혜원", "010-3333-4444","3월 25일");
		  PhoneInfor user3 = new PhoneInfor("이혜원", "010-5555-6666");
		  
		  
		  System.out.println();
		  user1.showInfo();
		  System.out.println();
		  user2.showInfo();
		  System.out.println();
		  user3.showInfo();

	}

}
