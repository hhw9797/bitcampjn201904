package com.boot.domain;

import java.util.Date;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

// usebean Class
public class MemberInfo {

	// 각 변수의 저근 제어지시자는 private
	private int idx;
	private String uId;
	@JsonIgnore
	private String uPw;
	private String uName;
	private String uPhoto;
	private Date regDate;

	private char verify;
	@JsonIgnore
	private String code;

	// default 생성자 필수
	public MemberInfo() {
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(String uId, String uPw, String uName, String uPhoto) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhoto = uPhoto;
		this.regDate = new Date();
		getRandomSting();
	}

	public MemberInfo(int idx, String uId, String uPw, String uName, String uPhoto, Date regDate) {
		super();
		this.idx = idx;
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhoto = uPhoto;
		this.regDate = regDate;
		getRandomSting();
	}

	// 변수들의 Getter/Setter 시작

	public String getuId() {
		return uId;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	// 데이터 확인을 위한 toString 오버라이딩
	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhoto=" + uPhoto
				+ ", regDate=" + regDate + ", verify=" + verify + ", code=" + code + "]";
	}

	// 화면 결과 출력을 위한 HTML 코드 반환
	public String makeHtmlDiv() {
		String str = "";

		str += "<div class=\"mInfor\"> \n";
		str += "	<h3> \n";
		str += "		" + uId + "(" + uName + ")\n";
		str += "	</h3> \n";
		str += "	<p> \n";
		str += "		" + uPw;
		str += "	</p> \n";
		str += "</div> \n";

		return str;
	}

	// MemberInfo 객체 -> LoginInfo 객체 반환
	/*
	 * public LoginInfo toLoginInfo() {
	 * 
	 * return new LoginInfo(uId, uName, uPhoto, regDate);
	 * 
	 * }
	 */

	// 비밀번호 체크 확인
	public boolean pwChk(String pw) {
		return uPw != null && uPw.trim().length() > 0 && uPw.equals(pw);
	}
	
	// 영문 + 숫자 난수 발생
	private void getRandomSting() {
		
		Random r = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 20; i++) {
			if (r.nextBoolean()) {
				sb.append(r.nextInt(10));
			} else {
				sb.append((char) (r.nextInt(26) + 97));
			}
		}
		
		System.out.println("난수 코드 생성 : " + sb);

		setCode(sb.toString());

		// return sb.toString();
	}
	
}
