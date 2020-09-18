package allen.chao.springDemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import allen.chao.springDemo.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	//Static Data to fake as DB
	private static List<Member> DB = new ArrayList();

	@Override
	public int insertMember(UUID id, Member member) {
		//create a member and add it to fake Db
		DB.add(new Member(id, member.getName()));
		
		return 0;
	}
	
	
}
