package product;

public class Product {
	
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0f);
	}
}


class Tv extends Product {

	Tv() {
		super(100);
	}

	@Override // 이 메소드를 구성함에 있어서 추가적인 의미를 부여했다 라는 뜻
	public String toString() {

		//return super.toString();// 오브젝트가 가지고 있던 원래의 메소드 호출
		return "TV";
	}	
}



class Computer extends Product {
	
	Computer() {
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}



class Audio extends Product {
	
	Audio() {
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
}