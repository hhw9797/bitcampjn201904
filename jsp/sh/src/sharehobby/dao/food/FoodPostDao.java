package sharehobby.dao.food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import sharehobby.model.food.FoodPost;

public class FoodPostDao {

	private static FoodPostDao dao = new FoodPostDao();

	public static FoodPostDao getInstance() {
		return dao;
	}

	private FoodPostDao() {
	}

	public int insert(Connection conn, FoodPost food) {
		int rCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into board_food (bf_num, bf_title, bf_star, bf_cont, bf_photo, bf_time, u_num, hf_num) values(b_food_num_seq.nextval,?,?,?,?,sysdate, 30, 1)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, food.getBf_title());
			pstmt.setFloat(2, food.getBf_star());
			pstmt.setString(3, food.getBf_cont());
			pstmt.setString(4, food.getBf_photo());

			rCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rCnt;
	}

	public FoodPost select(Connection conn, int bf_num) {

		FoodPost food = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from board_food where bf_num=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bf_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 값이 들어있다면 객체생성
				food = new FoodPost();
				food.setBf_num(rs.getInt(1));
				food.setU_num(rs.getInt(2));
				food.setHf_num(rs.getInt(3));
				food.setBf_time(rs.getString(4));
				food.setBf_star(rs.getFloat(5));
				food.setBf_cont(rs.getString(6));
				food.setBf_photo(rs.getString(7));
				food.setBf_title(rs.getString(8));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return food;

	}

	public int selectCount(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;

		// 결과가져오는 변수
		int totalCnt = 0;

		String sql = "select count(*) from board_food";

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				totalCnt = rs.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalCnt;
	}

	public List<FoodPost> selectList(Connection conn, int firstRow, int endRow) {

		List<FoodPost> list = new ArrayList<FoodPost>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select bf_title, hf_num, bf_star, bf_cont, bf_photo from ("
				+ " select rownum rnum, bf_title, hf_num, bf_star, bf_cont, bf_photo from ("
				+ " select * from board_food bf" + " ) where rownum <= ? " + " ) where rnum >= ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				FoodPost foodpost = new FoodPost();
				foodpost.setBf_title(rs.getString(1));
				foodpost.setHf_num(rs.getInt(2));
				foodpost.setBf_star(rs.getInt(3));
				foodpost.setBf_cont(rs.getString(4));
				foodpost.setBf_photo(rs.getString(5));

				list.add(foodpost);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int deletePost(Connection conn, int bf_num) throws SQLException {

		int resultCnt = 0;
		// PreparedStatement 객체 생성
		PreparedStatement pstmt = null;

		String sql = "delete from board_food where bf_num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bf_num);

			resultCnt = pstmt.executeUpdate();
		} finally {
			// 어떤 처리(오류가 나던 안나던)가 되어도 실행됨
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	public int update(Connection conn, int bf_num, FoodPost foodpost) {

		int rCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE BOARD_FOOD SET BF_TITLE=?, BF_CONT=?, BF_PHOTO=?, BF_STAR=? WHERE BF_NUM=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(5, bf_num);

			pstmt.setString(1, foodpost.getBf_title());
			pstmt.setString(2, foodpost.getBf_cont());
			pstmt.setString(3, foodpost.getBf_photo());
			pstmt.setFloat(4, foodpost.getBf_star());

			rCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rCnt;

	}

	public int find_uNum(Connection conn, String u_id) {

		int u_num = 0; // 회원번호
		ResultSet rs = null;

		PreparedStatement pstmt = null;
		String sql = "select u_num from member where u_id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				u_num = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u_num;
	}

}
