package com.example.demo.servlet.web.frontcontroller.v3.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.servlet.domain.Member;
import com.example.demo.servlet.domain.MemberRepository;
import com.example.demo.servlet.web.frontcontroller.ModelView;
import com.example.demo.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberListControllerV3 implements ControllerV3 {
	
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ModelView process(Map<String, String> paramMap) {
		List<Member> members = memberRepository.findAll();
		ModelView mv = new ModelView("members");
		mv.getModel().put("members", members);
		return mv;
	}
	
}
