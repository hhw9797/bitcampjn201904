package com.bit.guestbook.domain;

public class Login {
	
	private String uId;
	private String uPw;
	
	public String getuId() {
		return uId;
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
	
	@Override
	public String toString() {
		return "Login [uId=" + uId + ", uPw=" + uPw + "]";
	}
	
	

}
