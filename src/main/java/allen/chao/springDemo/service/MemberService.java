package allen.chao.springDemo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public List<Member> getAllMember(){
		return memberDao.selectAllmember();
	}
	
	public Optional<Member> getMemberById(UUID id) {
		return memberDao.selectMemberById(id);
	}
}
