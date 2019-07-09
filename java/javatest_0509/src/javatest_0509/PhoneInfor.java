package javatest_0509;

public class PhoneInfor {

	String name, phoneNumber, birthday;

	public PhoneInfor(String name, String phoneNumber, String birthday) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	public PhoneInfor(String name, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;

	}

	void showInfo() {

		if (birthday == null) {
			System.out.println("이름 : " + name);
			System.out.println("전화번호 : " + phoneNumber);
		} else {
			System.out.println("이름 : " + name);
			System.out.println("전화번호 : " + phoneNumber);
			System.out.println("생년월일 : " + birthday);
		}

	}

}
