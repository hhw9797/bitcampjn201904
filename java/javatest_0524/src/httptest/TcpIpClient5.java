package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpIpClient5 {

	static String str = "";
	static String str1;

	public static void main(String[] args) throws IOException, IOException {
	
		Socket socket = new Socket("10.10.10.28", 7777);
		
		System.out.println("서버 연결 성공!");
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				
		
		//sender.start();
		//receiver.start();

		Game game = new Game();
		game.gamePrint();
		
		
		int cnt = 1;
		while (true) {
			
			str = stdin.readLine();
			cnt = game.getCount();
				//System.out.println("다시 입력하세요\n가위, 바위, 보 중에서 선택해주세요.");
				//str = stdin.readLine();
			
			// 키보드로부터 데이타 입력 받음
			if(cnt<9){System.out.println("=================================");
			System.out.println("숫자를 입력해주세요 : ");
			}
			else if(cnt == 10) {
				System.out.println("게임이 끝났습니다.");
				
				break;
			}
		}
	}

}
