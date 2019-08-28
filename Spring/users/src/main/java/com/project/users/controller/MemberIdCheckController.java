package com.project.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.users.service.MemberRegService;

@Controller
public class MemberIdCheckController {

	@Autowired
	private MemberRegService regService;
	
	@RequestMapping("/member/idCheck2")
	@ResponseBody
	public String idCheck2(
			@RequestParam("id") String id
			) {
		
		return regService.idCheck1(id) ;
	}
	
}
