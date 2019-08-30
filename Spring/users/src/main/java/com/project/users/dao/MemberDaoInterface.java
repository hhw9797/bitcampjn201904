package com.project.users.dao;

import java.util.List;
import java.util.Map;

import com.project.users.domain.LoginInfo;
import com.project.users.domain.MemberInfo;

public interface MemberDaoInterface {
	
	// 회원 로그인처리시
	public MemberInfo selectMemberById(String userId);
	// 아이디 중복 체크
	public MemberInfo selectMemberById2(String userId);
	// 회원가입
	public int insertMember(MemberInfo memberInfo);
	// 회원 정보 수정을 위한 정보 획득
	public MemberInfo selectMemberByIdx(int id);
	
	// 회원 정보 수정
	public int memberUpdate(MemberInfo memberInfo);
	// 회원 정보 삭제
	public int memberDelete(int id);
	// 게시물의 LIST :  동적 쿼리로 검색의 결과 까지 처리
	//public List<MemberInfo> selectList(int index, int count);
	public List<MemberInfo> selectList(Map<String, Object> params);
	// 회원의 전체 리스트
	public List<MemberInfo> selectAllList();
	
	public LoginInfo loginInfo(String id, String pw);
}