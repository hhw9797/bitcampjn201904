package com.project.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.users.domain.RequestMemberRegist;
import com.project.users.service.MemberRegService;


@Controller
public class MemberRegController {

	@Autowired
	private MemberRegService registService;
	
	@CrossOrigin
	@PostMapping("/member/regist")
	public ResponseEntity<String> memberRegist(RequestMemberRegist regist, HttpServletRequest request) {
		
		System.out.println(regist);
		
		int cnt = registService.memberInsert(request, regist);
		
		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}
	
}