package membermanager.member.model;

public class RequestMemberInfor {
	
	private String uId;
	private String uPw;
	private String uName;
	private String uPhoto;
	
	public RequestMemberInfor() {}
	
	public RequestMemberInfor(String uId, String uPw, String uName, String uPhoto) {
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhoto = uPhoto;
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

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	@Override
	public String toString() {
		return "RequestMemberInfor [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhoto=" + uPhoto + "]";
	}
	
	public MemberInfo toMemberInfo() {
		return new MemberInfo(uId, uPw, uName, uPhoto);
	}

	
	
	

}
