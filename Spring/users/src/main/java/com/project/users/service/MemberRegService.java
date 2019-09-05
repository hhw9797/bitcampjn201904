package com.project.users.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.MemberInfo;
import com.project.users.domain.RequestMemberRegist;

@Service("registService")
public class MemberRegService implements MemberService {


	private MemberDaoInterface dao;

	@Autowired
	private SqlSessionTemplate template;

	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {

		dao = template.getMapper(MemberDaoInterface.class);

		MemberInfo memberInfo = regist.toMemberInfo();

		System.out.println(memberInfo);
		
		int resultCnt = 0;
		
		resultCnt = dao.insertMember(memberInfo);

		return resultCnt;
	}

	public String idCheck(String id) {

		dao = template.getMapper(MemberDaoInterface.class);

		String chk = dao.selectMemberById2(id) == null ? "Y" : "N";

		return chk;
	}
}