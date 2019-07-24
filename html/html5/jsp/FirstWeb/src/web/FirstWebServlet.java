package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class FirstWebServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) //request는 사용자의 요청정보를 담고있다.
	 */
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); // 응답하는 타입에 대한 정의
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>first Web</title></head>");
		out.println("<body>시간 : " + new Date());
		out.println("</h1></body></html>");
	}
}