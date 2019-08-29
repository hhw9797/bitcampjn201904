package com.project.users.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.MemberInfo;
import com.project.users.domain.RequestMemberEdit;


@Service("editService")
public class MemberEditService implements MemberService {

	//@Autowired
	//private MemberDao dao;	
	
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public MemberInfo getEditFormData(int id) {
		dao = template.getMapper(MemberDaoInterface.class);
		
		
		MemberInfo memberInfo = dao.selectMemberByIdx(id);		

		return memberInfo;
	}

	
	
	

}