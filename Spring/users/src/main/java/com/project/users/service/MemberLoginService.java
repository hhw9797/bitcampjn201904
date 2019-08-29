package com.project.users.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.LoginInfo;

@Service("loginService")
public class MemberLoginService implements MemberService {

	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate template;
	
	public LoginInfo login(
			String id, 
			String pw, 
			HttpServletRequest request) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
	
		LoginInfo info = null;
		
		info = dao.loginInfo(id, pw);

		request.getSession(true).setAttribute("loginInfo", info.getIdx());

		System.out.println(info);
					
		return info;
		
	}

}