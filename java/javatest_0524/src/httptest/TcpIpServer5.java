package httptest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer5 {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		Socket socket = null;

		serverSocket = new ServerSocket(7777);

		System.out.println("서버가 열렸습니다.");
		socket = serverSocket.accept();
		System.out.println("클라이언트가 접속했습니다.");

		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);

		sender.start();
		receiver.start();

	}
}

class Sender extends Thread {
	Socket socket;

	OutputStream out;
	PrintWriter pw;

	public Sender(Socket socket) {
		this.socket = socket;

		try {
			out = socket.getOutputStream();
			pw = new PrintWriter(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

		String send;
		BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter sendWriter = null;

		Game game = new Game();
		
		while (true) {
			try {
				send = tmpbuf.readLine();
				if (send.equals("가위")) {

				} else if (send.equals("바위")) {

				} else if (send.equals("보")) {

				} else {
					sendWriter.println(send);
					sendWriter.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

			
		}

	}
}

class Receiver extends Thread {

	Socket socket;

	DataInputStream in;
	BufferedReader br;

	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			br = new BufferedReader(new InputStreamReader(in));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

	}

}
