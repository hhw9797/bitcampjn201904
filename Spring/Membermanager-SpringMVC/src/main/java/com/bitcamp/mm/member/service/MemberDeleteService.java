package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;

@Service("deleteService")
public class MemberDeleteService implements MemberService {

	@Autowired
	private MemberJdbcTemplateDao dao;

	public int memberDelete(int id) { // idx 값

		int rCnt = 0;

		rCnt = dao.memberDelete(id);

		return rCnt;
	}

}
