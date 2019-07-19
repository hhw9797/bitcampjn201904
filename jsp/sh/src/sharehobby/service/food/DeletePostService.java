package sharehobby.service.food;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import sharehobby.dao.food.FoodPostDao;
import sharehobby.exception.food.MessageNotFoundException;
import sharehobby.model.food.FoodPost;

public class DeletePostService {
	
	private DeletePostService() {}
	
	private static DeletePostService service = new DeletePostService();
	
	public static DeletePostService getInstance() {
		return service;
	}
	
	public int deletePost(int bf_num) throws MessageNotFoundException, SQLException {
		
		int resultCnt = 0;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			FoodPostDao dao = FoodPostDao.getInstance();
			FoodPost foodpost = dao.select(conn, bf_num);
			
			if(foodpost == null) {
				//2-1. 게시물이 존재 하지않으면 예외 처리
				throw new MessageNotFoundException(bf_num + "번의 게시글이 존재하지 않습니다.");
			}

			resultCnt = dao.deletePost(conn, bf_num);
			
			//정상처리가 된다면 커밋을 통해 저장
			conn.commit();
			
			
			
		} catch (SQLException e) {
			//예외 발생시 rollback 처리를 해줌
			//트렌젝션의 롤백처리 : 만들어놓은 메서드를 사용
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} catch (MessageNotFoundException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		} 
		
		return resultCnt;
	}

}
