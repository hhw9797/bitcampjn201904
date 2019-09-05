package com.project.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.users.service.MemberRegService;

@RestController
@RequestMapping("/member/idCheck")
public class MemberIdCheckController {

	@Autowired
	private MemberRegService regService;
	
	@GetMapping
	@ResponseBody
	@CrossOrigin
	public String idCheck2(
			@RequestParam("id") String id
			) {
	
		return regService.idCheck(id) ;
	}
	
}