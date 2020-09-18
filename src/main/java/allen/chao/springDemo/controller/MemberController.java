package allen.chao.springDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
