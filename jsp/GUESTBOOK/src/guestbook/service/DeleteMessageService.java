package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.exception.InvalidMessagePasswordException;
import guestbook.exception.MessageNotFoundException;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageService {
	
	private DeleteMessageService() {}
	
	private static DeleteMessageService service = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return service;
	}

	
	public int deleteMessage(int messageId, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
		//성공적으로 실행이되면 성공된열에 대한 값을 리턴
		int resultCnt = 0;
		
		Connection conn = null;
		
		
		try {
			//메서드를 통해 connection 생성
			conn = ConnectionProvider.getConnection();
			
			//트렌젝션 처리
			conn.setAutoCommit(false);
			
			//1. 전달받은 게시물 아이디로 게시물 확인 (게시물이 존재하는지 아닌지)
			//Message Dao 필요 : 싱글톤으로 인해 메서드로 객체 생성해줌
			MessageDao dao = MessageDao.getInstance();
			
			Message message = dao.select(conn, messageId);
			
			if(message == null) {
				//2-1. 게시물이 존재 하지않으면 예외 처리
				throw new MessageNotFoundException(messageId+"번의 메세지가 존재하지 않습니다.");
			}
			
			//2-2. 게시물이 존재 한다면 비밀번호 확인(사용자가 입력한 비밀번호와 비교)
			//존재할때 결과값이 true가 나오기 때문에 논리 부정해줌
			if(!message.hasPassword()) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}
			
			//3-1. 비밀번호가 존재하지 않거나 사용자 비밀번호가 틀린 경우 예외처리
			//matchPassword : 패스워드가 맞는지 틀리는지 확인해주는 메서드
			//비밀번호 비교
			if(!message.matchPassword(password)) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지않습니다.");
			}
			
			//3-2. 비밀번호가 일치하면 정상처리(삭제) 후 commit
			resultCnt = dao.deleteMessage(conn, messageId);
			
			
			
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
		} catch (InvalidMessagePasswordException e) {
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		}
		
		return resultCnt;
		
	} 
}
