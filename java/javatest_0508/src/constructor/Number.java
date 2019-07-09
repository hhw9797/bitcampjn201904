package constructor;

public class Number {
	
	int num;
	
	
	Number(){
		num = 10; 
		System.out.println("생성자 호출!!!");
	}
	
	int getNum() {
		return num;
	}
	
	public static void main(String[] args) {
		
		Number number = new Number(); //인스턴스 생성 -> 생성자 호출
		
		System.out.println(number.getNum());
		
		Number number1 = new Number(); // 인스턴스 생성 -> 생성자 호출
		
		System.out.println(number1.getNum());
	}

}
