package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import member.BoardDao;
import member.ChangePasswordService2;
import member.MemberDao;
import member.MemberRegisterService2;

@Configuration
public class AppContext {
	
	@Bean(name = "memberDao1")
	@Qualifier("sys")
	//@Scope("prototype") // Scope 이라는 속성을 가지고 인스턴스를 생성 , prototype은 서로 다른 객체를 만들어서 반환함. main3 에서 dao1과 dao2의 값을 다르게 처리.
	public MemberDao getMemberDao() {
		return new MemberDao();
	}
	
	@Bean(name = "boardDao")
	public BoardDao getBoardDao() {
		return new BoardDao();
	}
	
	@Bean(name = "registService2")
	public MemberRegisterService2 getMemberRegisterService2() {
		
		MemberRegisterService2 service = new MemberRegisterService2();
		
		// 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		//return new MemberRegisterService2(getMemberDao());
	}
	
	@Bean(name = "changePwService2")
	public ChangePasswordService2 getChangePasswordService2() {
		
		ChangePasswordService2 service = new ChangePasswordService2();
		
		// 주입
		//service.setMemberDao(getMemberDao());
		
		return service;
		
		//return new ChangePasswordService2(getMemberDao());
	}
}
