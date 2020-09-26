package allen.chao.springDemo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue()
	private UUID id;
	
	private String name;
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
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

