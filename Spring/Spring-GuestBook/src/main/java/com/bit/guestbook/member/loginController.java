package com.bit.guestbook.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.guestbook.domain.Login;

@Controller
public class loginController {

	@RequestMapping(value = "/member/login")
	public String getLoginForm() {

		return "member/loginForm";
	}

	public ModelAndView loginProcess(HttpServletRequest request) {

		String id = request.getParameter("uId");
		String pw = request.getParameter("uPw");

		System.out.println(id + " : " + pw);

		ModelAndView modelAndView = new ModelAndView();

		return modelAndView;
	}
	
	@RequestMapping("/member/loginProc")
	public String loginproc(@RequestParam(value="uId", required = false) String id,
							@RequestParam(value="uPw", required = false) String pw,
							Model model) {
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/login";
		
	}
	
	public String loginOk(@ModelAttribute("user") Login login) {
		
		System.out.println(login.getuId() + "님 로그인 되었습니다.");

		login.setuId(login.getuId());
		
		return "member/login";
	}

}
