
public class RunnableThreadMain {

	public static void main(String[] args) {
		
		// Runnble 객체를 이용한 쓰레드 생성
		// 1. Runnable interface를 구현하는 클래스 기반의 객체 생성
		AdderThread aT1 = new AdderThread(0, 50);
		AdderThread aT2= new AdderThread(51, 100);

		// 2. Thread 생성 : 해야 할 일을 정의.
		Thread t1 = new Thread(aT1);
		Thread t2 = new Thread(aT2);
		
		// 3. 쓰레드의 실행
		t1.start();
		t2.start();
		
		try {
			t1.join();// 첫번째 쓰레드가 다 처리될 때까지 메서드를 멈춰놓고 있음. 0부터 50까지의 합을 구할때까지 시간을 벌 수 있음
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("aT1 num : " +aT1.getNum());
		System.out.println("aT2 num : " +aT2.getNum());
		System.out.println("0~100 까지의 합은 : " + (aT1.getNum() + aT2.getNum()));
	}

}
