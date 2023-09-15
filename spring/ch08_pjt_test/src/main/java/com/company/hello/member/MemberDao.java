package com.company.hello.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MemberDao {

	private Map<String, MemberVo> memberDB = new HashMap<String, MemberVo>(); // HashMap -> 저장할 수 있는 공간을 만든 것임

	public void insertMember(MemberVo memberVo) {
		System.out.println("[MemberDao] insertMember()");

		System.out.println("m_id: " + memberVo.getMemberId());
		System.out.println("m_pw: " + memberVo.getMemberPwd());
		System.out.println("m_name: " + memberVo.getMemberName());
		System.out.println("m_date: " + memberVo.getMemberEnrollDate());

		memberDB.put(memberVo.getMemberId(), memberVo); // 새로운 회원 정보 추가

		printAllMember(); // 모든 회원 정보 출력

	}

	public MemberVo selectMember(MemberVo memberVo) {
		System.out.println("[MemberDao] selectMember()");

		MemberVo signInedMember = memberDB.get(memberVo.getMemberId());

		if (signInedMember != null && memberVo.getMemberPwd().equals(signInedMember.getMemberPwd())) {
			return signInedMember;
		} else {
			return null;
		}
	}

	private void printAllMember() {
		System.out.println("[MemberDao] printAllMember()");

		Set<String> keys = memberDB.keySet();
		Iterator<String> iterator = keys.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			MemberVo memberVo = memberDB.get(key);

			System.out.println("m_id: " + memberVo.getMemberId());
			System.out.println("m_pw: " + memberVo.getMemberPwd());
			System.out.println("m_name: " + memberVo.getMemberName());
			System.out.println("m_date: " + memberVo.getMemberEnrollDate());
		}

	}

}
