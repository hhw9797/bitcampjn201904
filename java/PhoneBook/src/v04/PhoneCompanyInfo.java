package v04;

public class PhoneCompanyInfo extends PhoneInfo {
	
	String company;
	String email;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company, String email) {
	
		super(name, phoneNumber);
		
		this.company = company;
		this.email = email;
	}
	
	// annotation 따로 쓰지 않아도 오버라이딩됨
	public void showData() {
		super.showData();
		System.out.println("회사이름   : " + company);
		System.out.println("이메일      : " + email);
	}
	
	
}
