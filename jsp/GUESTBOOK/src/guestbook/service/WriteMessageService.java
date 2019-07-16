package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;

public class WriteMessageService {

	private static WriteMessageService service = new WriteMessageService();
	
	//static이없으면 외부에서 못가져옴
	public static WriteMessageService getInstance() {
		return service;
	}
	
	private WriteMessageService() {}
	
	public int  write(Message message) {
		int rCnt = 0;
		
		//1. Connection 생성
		//2. dao 생성
		//3. insert 메서드 시랭
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MessageDao dao = MessageDao.getInstance();
			
			rCnt = dao.insert(conn, message);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		return rCnt;
	}
}
