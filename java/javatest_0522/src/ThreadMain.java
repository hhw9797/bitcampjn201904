
public class ThreadMain {

	public static void main(String[] args) {
		
		//throw new Exception();
		
		// thread 클래스를 상속하는 Thread 객체 생성
		TreadEx1 t1 = new TreadEx1();
		
		// Runnable 인터페이스를 구현한 클래스 생성
		ThreadRunable r = new ThreadRunable();
		// Runnalbe 클래스 기반으로 Thread 인스턴스 생성
		Thread t2 = new Thread(r);
		
		//Thread 시작은 start()로 시작 -> 쓰래드 생성(길의 흐름) -> run() 호출
		
		t1.start();
		t2.start();
	}

}
