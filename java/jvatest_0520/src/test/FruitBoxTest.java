package test;

public class FruitBoxTest {

	public static void main(String[] args) {
		
		FruitBox<Apple> fb1 = new FruitBox<Apple>(new Apple(100));
		// fb1.store(new Apple(100));
		Apple apple = fb1.pullOut();
		apple.showAppleWeight();
		
		FruitBox<Orange> fb2 = new FruitBox<Orange>(new Orange(10));
		fb2.store(new Orange(10)); // 자료형 타입의 안전한 형태로 
		Orange orange = fb2.pullOut();
		orange.showSugarContent();

	}

}
