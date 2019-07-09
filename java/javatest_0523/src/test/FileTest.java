package test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		
		File f = new File("C:\\myjava\\pen.jpg");
		if (!f.exists()) { // = (f.exists() == false)
			System.out.println("지정하신 폴더에 파일이 존재하지 않습니다.");
			return;
		}
		System.out.println(f.getAbsolutePath());
		
		File reDir = new File("C:\\yourjava");
		reDir.mkdir();
		
		File newFile = new File(reDir, "myBin.jpg");
		
		f.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("이동 성공");
		}else {
			System.out.println("이동 실패");
		}
	}

}
