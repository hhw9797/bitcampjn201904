package util;

import java.util.Scanner;

public class Util {
	
	public static Scanner keyboard = new Scanner(System.in);//public static 내부에서 공용으로 사용 가능
	
	// v05 에서는 Menu가 없어서 필요없지만 v1234 때문에 지우지 않음
	public static final int INSERT = 1;
	public static final int SEARCH = 2;
	public static final int DELETE = 3;
	public static final int ALLDATA = 4;
	public static final int QUIT = 5;
	
}
