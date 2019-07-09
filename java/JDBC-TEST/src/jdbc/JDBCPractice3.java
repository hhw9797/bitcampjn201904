package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPractice3 {

	public static void main(String[] args) {
		// 3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			String sqlInsert = "update emp set sal='1000' where ename='SCOTT'";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			
			int resultCnt = pstmt.executeUpdate();
			if(resultCnt>0) {
				System.out.println("정상적으로 입력되었습니다.");
				System.out.println("-------------------------------");
			}
			
			Statement stmt = conn.createStatement();
			
			String sql1 = "select * from emp";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				System.out.println("사원번호" + rs.getInt("empno"));
				System.out.println("사원이름" + rs.getString("ename"));
				System.out.println("직급" + rs.getString("job"));
				System.out.println("관리자번호" + rs.getString("MGR"));
				System.out.println("입사일" + rs.getString("HIREDATE"));
				System.out.println("급여" + rs.getString("SAL"));
				System.out.println("부서번호" + rs.getString("DEPTNO"));
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
