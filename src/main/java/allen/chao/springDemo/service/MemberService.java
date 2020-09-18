package allen.chao.springDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import allen.chao.springDemo.dao.MemberDao;
import allen.chao.springDemo.model.Member;

@Service
public class MemberService {

	private final MemberDao memberDao;
	
	@Autowired
	public MemberService(@Qualifier("memberDao") MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}
}
