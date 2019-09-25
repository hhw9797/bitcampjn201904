package com.boot.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	public MemberEntity findByIdx(Long idx);
	public List<MemberEntity> findbyUnameLike(String name);
	
}
