package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class OtherService implements Service{

	public String getViewPage(HttpServletRequest request) {
		
		request.setAttribute("result", new Date());
		
		return "/datePage.jsp";
		
		
	}
	
}
