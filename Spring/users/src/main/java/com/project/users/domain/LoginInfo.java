package com.project.users.domain;

import java.util.Date;

public class LoginInfo {
	
	private int idx;
	private String uId;
	private String uName;
	private Date regDate;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getuId() {
		return uId;
	}

	public String getuName() {
		return uName;
	}

	
	public Date getRegDate() {
		return regDate;
	}

	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", uId=" + uId + ", uName=" + uName + 
				", regDate=" + regDate + "]";
	}


	

}
