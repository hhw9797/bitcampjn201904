package member;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("registerMemberService")
public class MemberRegisterService2 {
	
	@Autowired
	private MemberDao memberDao;

	
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao = memberDao; }
	 */

	/*
	 * public MemberRegisterService2(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	
	
	public void regist(RegisterRequest request) throws AleadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AleadyExistingMemberException();
		}
		
		Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		memberDao.insert(newMember);
		
	}
	
}
