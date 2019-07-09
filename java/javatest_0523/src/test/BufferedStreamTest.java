package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamTest {

	public static void main(String[] args) throws IOException {
		
		// 기본스트림 생성
		InputStream in = new FileInputStream("penguin.jpg");
		// 출력스트림 생성
		BufferedInputStream bIn = new BufferedInputStream(in);
		
		OutputStream out = new FileOutputStream("copy1.jpg");
		BufferedOutputStream bOut = new BufferedOutputStream(out);
		
		int copyByte = 0;
		int bData = 0;
		
		while(true) {
			bData = bIn.read();
			if(bData==-1) {
				break;
			}
			bOut.write(bData);
			copyByte++;
			}
		bIn.close();
		bOut.close();
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 사이즈는 : " + copyByte);
	}

}
