package com.project.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.users.domain.MemberInfo;
import com.project.users.service.MemberListService;

@RestController
@RequestMapping("/member/list")
public class MemberListController {

	@Autowired
	private MemberListService listService;
	
	@GetMapping
	@CrossOrigin
	public ResponseEntity<List<MemberInfo>> getAllList() {
		
		List<MemberInfo> list = listService.getAllList();

		ResponseEntity<List<MemberInfo>> entity = 
							new ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);

		return entity;
	}
	
}
