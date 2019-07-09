package javatest_0508;

public class GameMain {

	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.child1=15;
		game.child2=7;
		
		System.out.println("1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다");
		game.ch1win(2);
		game.print();
		System.out.println("2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.");
		game.ch2win(7);
		game.print();
			
		
	}

}
