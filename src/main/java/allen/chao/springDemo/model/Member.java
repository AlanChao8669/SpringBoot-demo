package allen.chao.springDemo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
	private final UUID id;
	private final String name;
	
	public Member(@JsonProperty("id") UUID id, 
				@JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
