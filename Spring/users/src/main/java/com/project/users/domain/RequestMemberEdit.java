package com.project.users.domain;

import org.springframework.web.multipart.MultipartFile;

public class RequestMemberEdit {

	private int idx;
	private String uId;
	private String uPw;
	private String uName;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPW(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	@Override
	public String toString() {
		return "RequestMemberEdit [idx=" + idx + ", uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + "]";
	}

	public MemberInfo toMemberInfo() {

		MemberInfo info = new MemberInfo();
		info.setIdx(idx);
		info.setuId(uId);
		info.setuName(uName);
		info.setuPw(uPw);

		return info;

	}

}