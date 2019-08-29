package com.project.users.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.users.domain.LoginInfo;
import com.project.users.domain.MemberInfo;
import com.project.users.domain.RequestMemberEdit;
import com.project.users.domain.RequestMemberRegist;
import com.project.users.service.MemberDeleteService;
import com.project.users.service.MemberEditService;
import com.project.users.service.MemberListService;
import com.project.users.service.MemberLoginService;
import com.project.users.service.MemberRegService;

@Controller // @ResponseBody 생략.
@RequestMapping("/members")
public class MemberRestFullController {

	@Autowired
	private MemberDeleteService deleteService;

	@Autowired
	private MemberEditService editService;

	@CrossOrigin
	@DeleteMapping("/{id}") // rest/members/12
	public ResponseEntity<String> deleteMember(@PathVariable("id") int idx) {

		int cnt = deleteService.memberDelete(idx);

		return new ResponseEntity<String>(cnt > 0 ? "success" : "fail", HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MemberInfo> getMemberInfo(@PathVariable("idx") int idx) {

		MemberInfo info = editService.getEditFormData(idx);

		return new ResponseEntity<MemberInfo>(info, HttpStatus.OK);
		
	}

	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<String>
	 * editMember(@PathVariable("id") int id, @RequestBody RequestMemberEdit
	 * editRequest, HttpServletRequest request) {
	 * 
	 * editRequest.setIdx(id);
	 * 
	 * System.out.println(editRequest);
	 * 
	 * int cnt = editService.edit(editRequest, null, request);
	 * 
	 * return new ResponseEntity<String>(cnt > 0 ? "success" : "fail",
	 * HttpStatus.OK); }
	 */

}