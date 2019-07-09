package test;

public class BusinessMan extends Man{//Man은 Object를 상속. BusinessMan은 Man을 상속. BusinessMan은 Object를 상속
	
	String company;
	String job;

	//하위 클래스의 생성자는 반드시 상위 클래스의 생성자를 호출해서 실행
	//상위 클래스에서 생성자를 통한 초기화 과정이 있다면,
	//하위 클래스에서 데이터를 받아서 상위 클래스의 생성자를 호출한다.
	public BusinessMan(String name, String comName, String job) {
		super(name);
		
		this.company = comName;
		this.job = job;
	
	}
	
	void tellYourInfo() {
		tellYourName();
		System.out.println("나의 직장은" + company + "입니다.");
		System.out.println("나의 직업은" + job + "입니다.");
	}
	
	//name, tellYourName()
	
	

}
