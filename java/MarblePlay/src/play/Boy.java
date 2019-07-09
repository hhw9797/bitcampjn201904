package play;

public class Boy {
	
	//구슬의 개수
	int mNum; // 구슬의 개수를 저장
	
	//플레이어 이름
	String pName;
	
	// 생성자 : 초기화 메서드, 인스턴스 생성시에 반드시 한번 실행
	Boy(String name, int num){
		pName = name;
		mNum = num;
	}
	
	
	//게임 승리 
	void gameWin(int mNum,Boy boy) {//int mNum 게임을 이겼을 때 획득한 구슬의 수, 지역변수 nMun
		//this.mNum += mNum;//지역 변수에 지역변수 더해줌
		win(mNum);
		boy.lose(mNum);
	}
	
	//구슬의 증가
	void win(int num) {
		mNum = mNum + num;
	}
	
	//구슬의 감소
	void lose(int num) {
		mNum = mNum - num;
	}
	
	//출력용
	void showNumber() {
		System.out.println(pName+ "의 구슬의 개수는 " + mNum + "개 입니다.");
	}
}
