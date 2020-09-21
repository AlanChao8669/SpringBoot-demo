package allen.chao.springDemo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import allen.chao.springDemo.model.Member;
import allen.chao.springDemo.service.MemberService;

@RequestMapping("api/v1/member")
@RestController
public class MemberController {

	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping
	public int addMember(@RequestBody Member member) {
		return memberService.insertMember(member);
	}
	
	@GetMapping
	public List<Member> getAllMember(){
		return memberService.getAllMember();
	}
	
	@GetMapping(path = "{id}")
	public Member getMemberById(@PathVariable("id") UUID id) {
		return memberService.getMemberById(id)
				.orElse(null);
	}
	
}
