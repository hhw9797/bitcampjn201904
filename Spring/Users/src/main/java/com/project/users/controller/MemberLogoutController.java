package com.project.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {

		@CrossOrigin
		@GetMapping("/member/logout")
		public ResponseEntity<String> logoutMember(HttpSession session){
			session.invalidate();
			return new ResponseEntity<String>("OK",HttpStatus.OK);
		}
}
