package com.ncs.test.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	

	@RequestMapping("/")
	public String signIn() {
		return "sign_in";
	}

	@RequestMapping("loginConfirm")
	public String memberLogin(Member member, Model model, HttpServletRequest request) { //로그인
		
		Member signInedMember = memberService.loginMember(member);
		HttpSession session = request.getSession();
		if(signInedMember == null) {
			model.addAttribute("msg","아이디나 비밀번호가 틀렸습니다");
			return "sign_in_ng";
		}else {
			session.setAttribute("member", signInedMember);
			return "redirect:/";
	}
 }
}

