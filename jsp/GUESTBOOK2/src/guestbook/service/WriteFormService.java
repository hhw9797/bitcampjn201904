package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormService implements GuestBookService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse reponse) {

		String viewName = "WEB-INF/view/writeForm.jsp";
		
		return viewName;
	}

}
