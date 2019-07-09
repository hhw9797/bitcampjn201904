package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPractice1 {

	public static void main(String[] args) {
		// 1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			
			String sqlInsert = "insert into emp values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, 7000);
			pstmt.setString(2, "HYEWON");
			pstmt.setString(3, "STUDENT");
			pstmt.setInt(4, 7369);
			pstmt.setString(5, "80/09/10");
			pstmt.setInt(6, 3000);
			pstmt.setInt(7, 500);
			pstmt.setInt(8, 10);
			
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt > 0) {
				System.out.println("정상적으로 입력되었습니다.");
			}
			
			Statement stmt = conn.createStatement();
			
			String sql1="select * from emp order by empno";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			
			System.out.println("-------------------------------");
			while(rs.next()) {
				System.out.println("사원번호" + rs.getInt("empno"));
				System.out.println("사원이름" + rs.getString(2));
				System.out.println("직급" + rs.getString(3));
				System.out.println("관리자번호" + rs.getString(4));
				System.out.println("입사일" + rs.getString(5));
				System.out.println("급여" + rs.getString(6));
				System.out.println("부서번호" + rs.getString(7));
				System.out.println("-------------------------------");
			}
			
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
