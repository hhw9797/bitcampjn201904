package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public DataInputStream dataInputStream;
	public DataOutputStream dataOutputStream;
	public ServerSocket serverSocket;
	public Socket clientSocket;

	public void serverSetting() {
		try {
			serverSocket = new ServerSocket(1234);
			System.out.println("서버 생성");
			clientSocket = serverSocket.accept();
			System.out.println("서버 연결");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dataSend() {
		new Thread(new Runnable() {

			Scanner in = new Scanner(System.in);
			boolean dataThread = true;

			public void run() {
				while (dataThread) {
					try {
						String sendData = in.nextLine();
						if (sendData.equals("종료")) {
							dataThread = false;
						} else {
							dataOutputStream.writeUTF(sendData);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void dataRecv() {
		new Thread(new Runnable() {

			boolean dataThread = true;

			public void run() {
				while (dataThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if (recvData.equals("종료")) {
							dataThread = false;
						} else {
							System.out.println("클라이언트 : " + recvData);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public Server() {
		serverSetting();
		streamSetting();
		dataSend();
		dataRecv();
	}

	public static void main(String[] args) {
		new Server();
	}
}
