package com.project.users.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.users.dao.MemberDaoInterface;
import com.project.users.domain.MemberInfo;

@Service("mailSenderService")
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private SqlSessionTemplate template;
	private MemberDaoInterface dao;

	// verify값 변경
	public int changeVerify(String id) {

		dao = template.getMapper(MemberDaoInterface.class);

		int cnt = 0;
		cnt = dao.verify(id);

		return cnt;
	}

	// verify값 확인
	public int verify(String id) {

		dao = template.getMapper(MemberDaoInterface.class);

		int cnt = 0;
		MemberInfo memberInfo = null;

		memberInfo = dao.selectMemberById(id);
		if (memberInfo != null && memberInfo.getVerify() == 'Y') {

		}

		return cnt;
	}

	public void send(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();
		int cnt = 0;

		try {

			message.setSubject("[안내] 회원가입을 축하합니다.", "UTF-8");
			String htmlMsg = "<h1>회원가입을 축하합니다.</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/users/member/verify?id=" + getuId + "&code=" + code
					+ "\" >인증하기</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("gksgpdnjs0907@nate.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님", "utf-8"));

			sender.send(message);
			cnt = 1;

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void reSend(String getuId, String code) {

		MimeMessage message = sender.createMimeMessage();

		try {

			message.setSubject("[인증안내] 이메일 인증을 해주세요.", "UTF-8");
			String htmlMsg = "<h1>이메일 인증을 해주세요.</h1>";

			htmlMsg += "<h3>인증을 위해 아래 링크를 클랙해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/users/member/verify?id=" + getuId + "&code=" + code
					+ "\" >인증하기</a></h3>";

			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("gksgpdnjs0907@nate.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(getuId, "고객님", "utf-8"));

			sender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}