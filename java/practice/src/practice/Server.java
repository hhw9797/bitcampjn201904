package practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public ServerSocket serverSocket;
	public Socket clientSocket;
	public DataInputStream dataInputStream;
	public DataOutputStream dataOutputStream;
	
	public void serverSetting() {
		try {
			serverSocket = new ServerSocket(1234);
			System.out.println("서버가 생성되었습니다.");
			clientSocket = serverSocket.accept();
			System.out.println("클라이언트에서 접속하였습니다.");
			System.out.println("==========================");
			System.out.println("원하는 메뉴를 입력해주세요. \n게임시작 : start \n채팅종료 : quit");
			System.out.println("==========================");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void servstreamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void servdataSend() {
		new Thread(new Runnable() {

			Scanner in = new Scanner(System.in);
			boolean dataThread = true;

			public void run() {
				while (dataThread) {
					try {
						String sendData = in.nextLine();
						if (sendData.equals("quit")) {
							System.out.println("채팅이 종료되었습니다.");
							dataThread = false;
						} else if(sendData.equals("start")) {
							game1();
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

	public void servdataRecv() {
		new Thread(new Runnable() {

			boolean dataThread = true;

			public void run() {
				while (dataThread) {
					try {
						String recvData = dataInputStream.readUTF();
						if (recvData.equals("quit")) {
							System.out.println("채팅이 종료되었습니다.");
							dataThread = false;
						}else if(recvData.equals("start")) {
							game1();
						} 
						else {
							System.out.println("상대방 : " + recvData);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void game1() {
		
			System.out.println("==========================");
			System.out.println("가위바위보를 시작합니다.");
			System.out.println("가위 : 1\n바위 : 2\n보  : 3");
			System.out.println("==========================");
			
		}	
	
	
	public Server() {
		serverSetting();
		servstreamSetting();
		servdataSend();
		servdataRecv();
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
