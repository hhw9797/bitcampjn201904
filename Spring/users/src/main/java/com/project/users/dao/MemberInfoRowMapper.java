package com.project.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.project.users.domain.MemberInfo;

public class MemberInfoRowMapper implements RowMapper<MemberInfo> {

	@Override
	public MemberInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberInfo memberInfo = new MemberInfo(
				rs.getInt("idx"), 
				rs.getString("uId"), 
				rs.getString("uPw"), 
				rs.getString("uName"), 
				rs.getString("uPhoto"), 
				new Date(rs.getTimestamp("regDate").getTime()));
		return memberInfo;
	}

	
	
}

