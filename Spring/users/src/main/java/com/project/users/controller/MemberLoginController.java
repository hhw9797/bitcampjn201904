package com.project.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.users.domain.MemberInfo;
import com.project.users.service.MemberLoginService;

@RestController
@RequestMapping("member/login")
public class MemberLoginController {

	@Autowired
	private MemberLoginService loginService;

	@CrossOrigin
	@GetMapping
	public String LoginForm(HttpServletRequest request) {

		String view = "member/loginForm";

		HttpSession session = request.getSession(false); // 현재 세션을 가지고 있다면 그대로 가져오고없다면 null값 반환
		if (session != null && session.getAttribute("loginInfo") != null) {
			view = "redirect:/main";
		}

		return view;
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> login(@RequestParam("uId") String id, @RequestParam("uPw") String pw,
			HttpServletRequest request) {

		System.out.println("id" + id + "pw" + pw);
		
		//int o = loginService.login(id, pw, request);
		
		  //String view = "member/loginfail";
		  
		  int cnt = loginService.login(id,pw, request);
		  
		  System.out.println("22 :: " + cnt);
		  
		
		  //switch (loginChk) { 
		  //	case 1: 
		  		// 새로운 view(jsp) 추가 
		//	  view = "member/notVerify";
		  //break; 
		  //case 2: 
			//  view = "main"; 
			//  break; 
			//  }
		  
		  return new ResponseEntity<String>(cnt == 2 ? "success" : "fail", HttpStatus.OK);
		 
	}

}
