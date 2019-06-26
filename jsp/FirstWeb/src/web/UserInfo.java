package web;

import java.util.Date;

//beans 클래스 구성

public class UserInfo {
	
	/* beans 클래스의 변수는 private 로 처리한다 */
	private String id; //${user.id} 는 이 변수를 호출하는것이 아니라 getId()를 호출하는것과 같다.
	private String password;
	private String name;
	private String address;
	private String email;
	private Date registerDate;//등록날짜

	
	/* default 생상자가 필수 !
	 * 필드를 이용하는 생성자가 필요하다면 default 생성자를 명시적으로 정의 */
	public UserInfo() {
		//registerDate는 등록한 시간을 가져오기위해 따로 받아오지않고 Date()메서드를 저장한다
		this.registerDate = new Date();
	}
	
	
	public UserInfo(String id, String password, String name, String address, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.registerDate = new Date();
	}
	
	
	/* setter / getter 메서드 정의
	 * setVariable() / getVariable() */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", email="
				+ email + ", registerDate=" + registerDate + "]";
	}

	
}