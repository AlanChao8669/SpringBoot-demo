package allen.chao.springDemo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import allen.chao.springDemo.model.Member;


public interface MemberDao {

	int insertMember(UUID id, Member member);
	
	default int insertMember(Member member) {
		UUID id = UUID.randomUUID();
		return insertMember(id, member);
	}
	
	List<Member> selectAllmember();
	
	Optional<Member> selectMemberById(UUID id);
	
	int deleteMemberById(UUID id);
	
	int updateMemberById(UUID id, Member member);
}
