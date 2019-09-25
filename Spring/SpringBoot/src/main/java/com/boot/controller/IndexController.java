package com.boot.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.dao.MemberDaoImpl;
import com.boot.domain.MemberInfo;
import com.boot.entity.MemberEntity;
import com.boot.mapper.MemberMapper;
import com.boot.respository.MemberRepository;

@Controller
public class IndexController {
	
	private MemberRepository repository;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private MemberMapper mapper;
	
	@RequestMapping("/")
	@ResponseBody
	public String index() { 
		
		return "Spring Boot Start";
	}
	
	@RequestMapping("/hello")
	public void hello1() { //void는 method 파일명 찾음
		
	}
	
	@Transactional
	@RequestMapping("/memberInfo")
	public void selectById() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		MemberInfo info = mapper.selectMemberById("hyewoni97@naver.com");
		
		System.out.println(info);
	}

	@RequestMapping("/members")
	@ResponseBody
	public List<MemberInfo> selectMembers() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		List<MemberInfo> info =  mapper.selectAll();
		
		for (MemberInfo memberInfo : info) {
			System.out.println(memberInfo);
		}
		
		return info;
	}
	
	@RequestMapping("/member/list")
	@ResponseBody
	public List<MemberEntity> getMemberList(){
		
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		System.out.println(list);
		
		return list;
		
	}
	
	@RequestMapping("/member/insert")
	@ResponseBody
	public String insetMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setuId("cool@hot");
		entity.setuName("COOLin");
		entity.setuPw("12345");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/edit/{idx}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		entity.setuId("cool@hot.com");
		entity.setuName("COOLinHOT");
		entity.setuPw("editPW");
		
		return repository.saveAndFlush(entity).toString();
		
	}


	@RequestMapping("/member/delete/{idx}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		
		repository.delete(entity);
		
		return "delete success";
		
	}
	
	@RequestMapping("/member/member/{idx}")
	@ResponseBody
	public MemberEntity getMemberInfo(@PathVariable("idx") long idx) {
		
		MemberEntity entity = null;
		
		entity = repository.findByIdx(idx);
		
		System.out.println(entity);
		
		return entity;
		
	}
	
	@RequestMapping("/member/memberbyname/{name}")
	@ResponseBody
	public List<MemberEntity> getMemberInfo(@PathVariable("name") String name) { // getMemberInfo 오버로딩 됨
		
		List<MemberEntity> entitys = null;
		
		entitys = repository.findbyUnameLike("%" + name + "%");
		
		for (MemberEntity memberEntity : entitys) {
			System.out.println(memberEntity);
		}
		
		return entitys;
		
	}

	@PersistenceContext
	EntityManager entityManager;
	
	private MemberDaoImpl dao;
	
	public IndexController() {
		this.dao = new MemberDaoImpl(entityManager);
	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public List<MemberEntity> memberListAll(){
		
		List<MemberEntity> list = dao.getAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
		
	}
	
}
