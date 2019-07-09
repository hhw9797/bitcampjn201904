package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPractice4 {

	public static void main(String[] args) {
		// 4.EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			Statement stmt = conn.createStatement();
			String sql1 = "select * from emp where ename='SCOTT'";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				System.out.println("사원번호 : " + rs.getInt("empno"));
				System.out.println("사원이름 : " + rs.getString("ename"));
				System.out.println("직급 : " + rs.getString("job"));
				System.out.println("관리자 번호 : " + rs.getString("MGR"));
				System.out.println("입사일 : " + rs.getString("HIREDATE"));
				System.out.println("급여 : " + rs.getString("SAL"));
				System.out.println("부서번호 : " + rs.getString("DEPTNO"));
				System.out.println("-------------------------------");
			}
			rs.close();
			stmt.close();
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
