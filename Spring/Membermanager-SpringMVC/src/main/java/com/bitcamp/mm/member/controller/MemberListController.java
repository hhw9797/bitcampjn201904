package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.SearchParam;
import com.bitcamp.mm.member.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/memberList")
	public String memberList(Model model, 
							@RequestParam(value = "p", defaultValue = "1") int pageNumber,
							@RequestParam(value = "stype", required = false) String stype,
							@RequestParam(value = "keyword", required = false) String keyword) {
		
		SearchParam searchParam = null;
		
		if(stype != null && keyword != null && !stype.isEmpty() && !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
			
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		System.out.println("전체 회원의 수 : " + listdata.getTotalCount());
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		return "member/memberList";
	}
	
	

	   @RequestMapping("/member/memberListJson")
	   public @ResponseBody ListViewData memberListJson(
	         @RequestParam(value = "p", defaultValue = "1") int pageNumber,
	         @RequestParam(value = "stype", required = false) String stype,
	         @RequestParam(value = "keyword", required = false) String keyword,
	         HttpServletResponse response
	         ) {
	      
	      SearchParam searchParam = null; 
	      
	      if(   stype!=null 
	            && keyword!=null 
	            && !stype.isEmpty() 
	            && !keyword.isEmpty()) {
	         searchParam = new SearchParam();
	         searchParam.setStype(stype);
	         searchParam.setKeyword(keyword);
	      }
	      
	      
	      ListViewData listdata = listService.getListData(pageNumber, searchParam);
	      
	   
	      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	      
	      
	      return listdata;
	   }
	
	   
	   // 반환 타입이 ResponseEntity<T> : Spring 4.2 버전 이상일 때 사용가능
	   // 반환 하고자하는 Body, statusCode, HttpHeader
	   @RequestMapping("/member/memberListJson2")
	   @ResponseBody
	   public ResponseEntity<ListViewData> memberListJson2(
	         @RequestParam(value = "p", defaultValue = "1") int pageNumber,
	         @RequestParam(value = "stype", required = false) String stype,
	         @RequestParam(value = "keyword", required = false) String keyword
	         ) {
	      
	      
	      //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	      //response.setStatus(HttpServletResponse.SC_OK);
	      
	      
	      SearchParam searchParam = null; 
	      
	      if(   stype!=null 
	            && keyword!=null 
	            && !stype.isEmpty() 
	            && !keyword.isEmpty()) {
	         searchParam = new SearchParam();
	         searchParam.setStype(stype);
	         searchParam.setKeyword(keyword);
	      }
	      
	      ListViewData listdata = listService.getListData(pageNumber, searchParam);
	      
	   
	      //response.setStatus(HttpServletResponse.SC_OK);
	      //response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	      //response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	      
	      ResponseEntity<ListViewData> entity = new ResponseEntity<ListViewData>(listdata, HttpStatus.OK);
	      
	      return entity;
	   }
	
}
