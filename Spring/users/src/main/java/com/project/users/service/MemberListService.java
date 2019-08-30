package com.project.users.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.MemberInfo;

@Service("listServcie")
public class MemberListService implements MemberService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public List<MemberInfo> getAllList(){
		
		dao = template.getMapper(MemberDaoInterface.class);
		
		List<MemberInfo> list = dao.selectAllList();
		
		return list;
		
	}
	
}