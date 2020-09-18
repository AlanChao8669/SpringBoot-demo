package allen.chao.springDemo.dao;

import java.util.UUID;

import allen.chao.springDemo.model.Member;


public interface MemberDao {

	int insertMember(UUID id, Member member);
	
	default int insertMember(Member member) {
		UUID id = UUID.randomUUID();
		return insertMember(id, member);
	}
}
