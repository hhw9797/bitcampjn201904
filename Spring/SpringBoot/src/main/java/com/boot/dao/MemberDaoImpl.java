package com.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.boot.entity.MemberEntity;

public class MemberDaoImpl implements MemberDao<MemberEntity> {

	private EntityManager entityManager;
	
	public MemberDaoImpl() {}
	
	@Override
	public List<MemberEntity> getAll() { // method 구현하지 않으면 추상 클래스가 됨

		Query query = entityManager.createQuery("from MemberEntity");
		
		List<MemberEntity> list = query.getResultList();
		
		entityManager.close();
		
		return null;
	}

	public MemberDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	} 

	
	
}
