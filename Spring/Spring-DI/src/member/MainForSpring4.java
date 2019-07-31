package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring4 {

	//private static Assembler assembler = new Assembler();
	
	
	// 스프링 컨테이너 생성 : 조립기 설정파일 AppContext.class
	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx3.class);
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("명령어를 입력해주세요.");
			
			String command = reader.readLine();
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			 
			// new hhw9797@naver.com hhw 1111 1111
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" ")); // 띄어쓰기에 따라 문자열 반환
			}
			
			if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
			}
				
		}
		
	}
	
	// 등록
	private static void processNewCommand(String[] args) {
		
		if(args.length != 5) {
			printHelp();
			return;
		}
		
		//MemberRegisterService service = assembler.getRegistService();
		MemberRegisterService2 service = ctx.getBean("registerMemberService", MemberRegisterService2.class);
		
		RegisterRequest request = new RegisterRequest();
		request.setEmail(args[1]);
		request.setName(args[2]);
		request.setPassword(args[3]);
		request.setConfirmPassword(args[4]);
		if(!request.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호 확인이 일치하지 않습니다.");
			return;
		}
		
		try {
			service.regist(request);
			System.out.println("등록되었습니다.");
		} catch (AleadyExistingMemberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이미 존재하는 이메일입니다.");
		}
		
	}

	// 암호 변경
	private static void processChangeCommand(String[] args) {
		
		if(args.length != 4) {
			printHelp();
			return;
		}
		
		//ChangePasswordService service = assembler.getPwService();
		ChangePasswordService2 service = ctx.getBean("changePasswordService", ChangePasswordService2.class);
		
		try {
			service.changePassword(args[1], args[2], args[3]);
			System.out.println("암호가 변경되었습니다.");
		} catch (MemberNotfoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("존재하지 않는 이메일 입니다.");
		} catch (IdPasswordNotMatchingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
		
	}
	
	private static void printHelp() {
		System.out.println("");
		System.out.println("잘못된 명령 입니다. 아래 명령 사용법을 확인하세요.");
		System.out.println("new 이메일 사용자이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 암호확인");
		
	}
}
