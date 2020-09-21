package allen.chao.springDemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		
		return 1;
	}

	@Override
	public List<Member> selectAllmember() {	
		return DB;
	}

	@Override
	public Optional<Member> selectMemberById(UUID id) {
		return DB.stream()
				.filter(member -> member.getId().equals(id))
				.findFirst();
	}	
	
	@Override
	public int deleteMemberById(UUID id) {
		Optional<Member> Member = selectMemberById(id);
		if(Member.equals(null)) {
			return 0;
		}
		DB.remove(Member.get());
		return 1;
	}

	@Override
	public int updateMemberById(UUID id, Member memberUpdate) {
		return selectMemberById(id)
				.map(member ->{
					int indexOfMemberToUpdate = DB.indexOf(member);
					if(indexOfMemberToUpdate >= 0) {
						DB.set(indexOfMemberToUpdate, new Member(id, memberUpdate.getName()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
	}

	
	
}
