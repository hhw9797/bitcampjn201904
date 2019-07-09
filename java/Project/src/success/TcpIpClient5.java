package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient5 {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("10.10.10.28", 7777);
		System.out.println("서버 연결 성공!");

		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;
		int score = 0;
		String str = "";
		String str1 = "";
		System.out.println("==========================");
		System.out.println("가위바위보!!");
		System.out.println("==========================");
		System.out.println("가위바위보 게임에 오신 것을 환영합니다.");
		System.out.println("가위는 1, 바위는 2, 보는 3입니다.");
		while (true) {
			System.out.println("숫자를 입력해주세요."+count);
			System.out.println(score);
				str = stdin.readLine();
				str1 = Integer.toString((int)((Math.random() * 3) + 1));
				count++;
				if (str.equals("1")) {
					if (str1.equals("1")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("서로 비겼습니다.");
					} else if (str1.equals("2")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 졌습니다.");
					} else {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 이겼습니다.");
						score = score+30;
					}
				} else if (str.equals("2")) {
					if (str1.equals("1")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 이겼습니다.");
						score = score+30;
					} else if (str1.equals("2")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("서로 비겼습니다.");
					} else {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 졌습니다.");
					}
				} else if (str.equals("3")) {
					if (str1.equals("1")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 졌습니다.");
					} else if (str1.equals("2")) {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("클라이언트가 이겼습니다.");
						score = score+30;
					} else {
						System.out.println("서버 : " + str1);
						System.out.println("클라이언트 : " + str);
						System.out.println("서로 비겼습니다.");
					
				}
					
			}
				
				
			pw.println();
			pw.flush();
			
		//str1 = br.readLine();
		//System.out.println("서버 : " + str1);
		}
		/*
		 * Sender sender = new Sender(socket); Receiver receiver = new Receiver(socket);
		 * 
		 * sender.start(); receiver.start();
		 */
	}

}
