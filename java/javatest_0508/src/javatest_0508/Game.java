package javatest_0508;

public class Game {

	int child1;
	int child2;
	
	void ch1win(int marble) {
		child1 += marble;
		child2 -= marble;
	}
	
	void ch2win(int marble) {
		child1 -= marble;
		child2 += marble;
		
	}
	
	void print() {
		System.out.println("어린이1의 구슬 개수:" + child1);
		System.out.println("어린이2의 구슬 개수:" + child2);
	}

}
