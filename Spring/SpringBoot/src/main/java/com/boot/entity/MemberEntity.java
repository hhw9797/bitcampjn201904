package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity {
	
	@Id
	@Column
	private long idx;
	
	@Column(length = 45, nullable = false) // name 속성을 따로 쓰지 않으면 uId가 컬럽의 이름이 됨
	private String uId;
	
	@Column(length = 45, nullable = false)
	private String uPw;
	
	@Column(length = 45, nullable = false)
	private String uName;
	
	@Column(length = 45, nullable = false)
	private String uPhoto;
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
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
	
	@Override
	public String toString() {
		return "MemberEntity [idx=" + idx + ", uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhoto=" + uPhoto
				+ "]";
	}

}
