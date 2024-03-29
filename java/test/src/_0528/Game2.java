package _0528;

/**
 * 야구 게임 class BaseballGame2 정답 값은 랜덤함수로 값이 정해지고 // randomInt(){ 사용자가 값을 4자리
 * 입력하면 // inputUserNumber() 스트라이크, 볼 출력 // countSB(int a[],int b[]) 4스트라이크면 게임
 * 종료함. // 검증 횟수가 20번 넘으면 종료함. // display(int cnt,boolean val)
 * 
 * 클래스, 객체, 생성자
 * 
 * <보완점> 입력 받는 수 중 같은 수가 있을 때 다시 입력 받도록 한다. 입력 받는 수가 4개가 넘을 때 다시 입력 받도록 한다. 입력
 * 받는 수가 4개 미만일 때 다시 입력 받도록 한다. 중간에 하기 싫을 때 포기하는 방법
 * 
 * *참고* 입력받는 메소드를 따로 만들지 말고 입력받는 코드는 메인에 둘것 -> 실무에서 잦은 오류 발생의 원인이 된다.
 */

class Game2 {
	public static int MAX_COUNT = 4; // 몇자리 숫자로 게임을 하겠는가?
	public static int MAX_INPUT = 20; // 최대 몇번까지 정답입력을 받을 것인가?
	int x = 0, y = 0; // x= 스트라이크 갯수, y=볼 갯수
	private boolean val = false;
	private int baseNumber[] = new int[MAX_COUNT]; // 정답배열
	private int userNumber[] = new int[MAX_COUNT]; // 사용자 입력 값 배열
	private int cnt = 0;


	void randomInt() { // 랜덤으로 정답 배열 만들기
		do {
			baseNumber[0] = (int) (Math.random() * 10);
		} while (baseNumber[0] == 0);

		for (int i = 1; i < baseNumber.length; i++) {
			baseNumber[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				while (baseNumber[i] == baseNumber[j] || baseNumber[i] == 0) {
					baseNumber[i] = (int) (Math.random() * 10);
					j = 0;
				}
			}
		}
	}

	void inputUserNumber1(String in1) { // 사용자값 입력 받아 처리

		String in = in1;
		for (int i = 0; i < userNumber.length; i++) {
			userNumber[i] = in.charAt(i) - 48;
		}
		countSB(baseNumber, userNumber);

	}

	synchronized void countSB(int a[], int b[]) { // 스타리이크 볼 카운트

		x = 0;
		y = 0; // 스트라이크, 볼 갯수 초기화
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[i] == a[j])
					if (i == j)
						x += 1;
					else
						y += 1;
			}
		}
		
		cnt++;
		if (x == MAX_COUNT) {
			val = true;
			return;
		} // 4스트라이크면 종료
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	int getCount() {
		return cnt;
	}

	boolean getValue() {
		return val;
	}

}