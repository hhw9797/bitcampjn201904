package foodPost.service;

import java.sql.Connection;
import java.sql.SQLException;

import Food.dao.FoodPostDao;
import foodPost.model.FoodPost;
import jdbc.ConnectionProvider;

public class WritePostService {
	
	private static WritePostService service = new WritePostService();
	
	public static WritePostService getInstance() {
		return service;
	}
	
	private WritePostService() {}
	
	public int write(FoodPost foodpost) {
		int rCnt = 0;
		
		//1. Connection 생성
		//2. dao 생성
		//3. insert 메서드 시랭
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			FoodPostDao dao = FoodPostDao.getInstance();
			
			rCnt = dao.insert(conn, foodpost);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return rCnt;
		
	}
}
