package com.project.users.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.MemberInfo;
import com.project.users.domain.RequestMemberEdit;

@Service("editService")
public class MemberEditService implements MemberService {

	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate template;

	public MemberInfo getEditFormData(int id) {
		
		System.out.println("수정  폼 서비스");
		
		dao = template.getMapper(MemberDaoInterface.class);

		MemberInfo memberInfo = dao.selectMemberByIdx(id);

		System.out.println(memberInfo);
		
		return memberInfo;
	}

	public int edit(RequestMemberEdit edit, HttpServletRequest request) {
		
		System.out.println("수정 서비스");
		
		dao = template.getMapper(MemberDaoInterface.class);

		int rCnt = 0;
		
		MemberInfo memberInfo = edit.toMemberInfo();

		rCnt = dao.memberUpdate(memberInfo);

		return rCnt;
	}

}