package sharehobby.model.food;

public class FoodPost {
	
	private int bf_num; // 게시글번호
	private int u_num; // 회원번호
	private int hf_num; // 식당코드
	private String bf_time; // 시간
	private float bf_star; // 평점
	private String bf_cont; // 내용
	private String bf_photo; // 사진
	private String bf_title; // 글 제목
	
	public int getBf_num() {
		return bf_num;
	}
	public void setBf_num(int bf_num) {
		this.bf_num = bf_num;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public int getHf_num() {
		return hf_num;
	}
	public void setHf_num(int hf_num) {
		this.hf_num = hf_num;
	}
	public String getBf_time() {
		return bf_time;
	}
	public void setBf_time(String bf_time) {
		this.bf_time = bf_time;
	}
	public String getBf_cont() {
		return bf_cont;
	}
	public void setBf_cont(String bf_cont) {
		this.bf_cont = bf_cont;
	}
	public float getBf_star() {
		return bf_star;
	}
	public void setBf_star(float bf_star) {
		this.bf_star = bf_star;
	}

	public String getBf_photo() {
		return bf_photo;
	}
	public void setBf_photo(String bf_photo) {
		this.bf_photo = bf_photo;
	}
	public String getBf_title() {
		return bf_title;
	}
	public void setBf_title(String bf_title) {
		this.bf_title = bf_title;
	}
	

}
