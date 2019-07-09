package v05;

public abstract class PhoneInfo implements PhoneInfoBasic {
	
	//이 메서드에서만 변수를 볼 수 있음
	String name; // 친구의 이름 저장
	String phoneNumber; // 친구의 전화번호 저장
	
	public PhoneInfo(String name, String phoneNumber) { // shift+alt+s -> using Field
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showData() {
		System.out.println("이름       : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
	
	//변수의 값을 참조하는 메서드 : getter 메서드
	/*
	 * String getName() { return this.name; }
	 */
	
	// 변수의 값을 대입하는 메서드 : setter 메서드
	/*
	 * void setName(String name) { this.name = name; }
	 */
	
	
	
	
	
}
