package com.example.demo.domain.member;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.demo.servlet.domain.Member;
import com.example.demo.servlet.domain.MemberRepository;

class MemberRepositoryTest {
	
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	// 하나의 테스트가 끝날때마다 실행되서 저장소 지움
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void save() {
		// given
		Member member = new Member("hello", 20);
		
		// when
		Member savedMember = memberRepository.save(member);
		
		// then
		Member findMember = memberRepository.findById(savedMember.getId());
		Assertions.assertThat(findMember).isEqualTo(savedMember);
	}
	
	@Test
	void findAll() {
		// given
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		// when
		List<Member> result = memberRepository.findAll();
		
		// then
		Assertions.assertThat(result.size()).isEqualTo(2);
		Assertions.assertThat(result).contains(member1, member2);
	}
	
}