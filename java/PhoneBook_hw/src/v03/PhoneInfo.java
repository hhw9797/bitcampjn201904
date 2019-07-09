package v03;

class PhoneInfo {
	
	

	String name; 
	String phoneNumber; 
	String birthday; 

	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	
	public PhoneInfo(String name, String phoneNumber) {
		this(name, phoneNumber, "저장된 데이터가 없습니다.");
	}
	
	void showInfo() {
		System.out.println("이름	: " + name );
		System.out.println("전화번호	: " + phoneNumber );
		System.out.println("생일	: " + birthday);

		
	}
	
}
