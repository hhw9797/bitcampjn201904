package com.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.boot.domain.MemberInfo;

public interface MemberMapper {
	
	@Select("select * from member order by idx desc")
	public List<MemberInfo> selectAll();
	public MemberInfo selectMemberById(String uid);
	
}
