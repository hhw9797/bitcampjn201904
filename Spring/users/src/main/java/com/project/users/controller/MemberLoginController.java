package com.project.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.users.domain.LoginInfo;
import com.project.users.service.MemberLoginService;

@RestController
public class MemberLoginController {

	@Autowired
	private MemberLoginService loginService;

	@CrossOrigin
	@PostMapping("member/login")
	public ResponseEntity<LoginInfo> login(@RequestParam("uId") String id, 
											@RequestParam("uPw") String pw,
											HttpServletRequest request) {

		System.out.println(id+"+"+pw);
		
		LoginInfo info = loginService.login(id, pw, request);
		
		
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("loginInfo"));
		
		return new ResponseEntity<LoginInfo>(info, HttpStatus.OK);
		
	}
	
}

