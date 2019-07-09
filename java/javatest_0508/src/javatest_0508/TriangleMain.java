package javatest_0508;

public class TriangleMain {
	
	int num = 100;

	public static void main(String[] args) {
		
		TriangleMain ta = new TriangleMain();
		
		System.out.println(ta.num);
		
		Triangle triangle;//참조변수 선언
		
		triangle = new Triangle();//객체 생성
		
		/* 데이터 설정 */
		triangle.setData(7, 5);
		
		System.out.println("삼각형의 높이 데이터 : " + triangle.height);
		System.out.println("삼각형의 밑변 데이터 : " + triangle.width);
		
		System.out.println("삼각형의 넓이 : " + triangle.calArea());
	}

}
