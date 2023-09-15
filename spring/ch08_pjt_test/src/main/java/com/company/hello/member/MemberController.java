package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/signUp")
	public String signUp() {

		return "sign_up";
	}

	// VO객체 이용
	@RequestMapping("/signUpConfirm")
	public String signUpConfirm(MemberVo memberVo) {
		System.out.println("[MemberController] signUpConfirm()");

		System.out.println("m_id: " + memberVo.getMemberId());
		System.out.println("m_pw: " + memberVo.getMemberPwd());
		System.out.println("m_mail: " + memberVo.getMemberName());
		System.out.println("m_phone: " + memberVo.getMemberEnrollDate());

		memberService.signUpConfirm(memberVo);

		return "sign_up_ok"; // 문자

	}

	@RequestMapping("/signIn")
	public String signIn() {

		return "sign_in";
	}

	@RequestMapping("/signInConfirm") // 매핑(mapping)
	public String signInConfirm(MemberVo memberVo) {
		System.out.println("[MemberController] signInConfirm()");

		MemberVo signInedMember = memberService.signInConfirm(memberVo); // 서비스 호출

		if (signInedMember != null) {// 로그인 성공
			return "sign_in_ok"; // 문자열
		} else { // 로그인 실패
			return "sign_in_ng"; // 문자열
		}
	}

}
