package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPractice5 {

	public static void main(String[] args) {
		// 5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
		
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			System.out.println("오라클 데이터베이스에 접속했습니다.");
			
			Statement stmt = conn.createStatement();
			String sql1 = "select * from emp e, dept d where e.deptno = d.deptno";
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			System.out.println("-------------------------------");
			while(rs.next()) {
				System.out.println("사원번호 : " + rs.getInt("empno"));
				System.out.println("사원이름 : " + rs.getString("ename"));
				System.out.println("직급 : " + rs.getString("job"));
				System.out.println("관리자 번호 : " + rs.getInt("MGR"));
				System.out.println("입사일 : " + rs.getString("HIREDATE"));
				System.out.println("급여 : " + rs.getInt("SAL"));
				System.out.println("부서번호 : " + rs.getInt("DEPTNO"));
				System.out.println("==");
				//System.out.println("부서번호 : " + rs.getInt("DEPTNO_1"));
				System.out.println("부서이름 : " + rs.getString("DNAME"));
				System.out.println("지역 : " + rs.getString("LOC"));
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
