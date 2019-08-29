package com.project.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.users.domain.MemberInfo;

public class MemberInfoRowMapper implements RowMapper<MemberInfo> {

	@Override
	public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberInfo memberInfo = new MemberInfo();
		return memberInfo;
	}

	
	
}
