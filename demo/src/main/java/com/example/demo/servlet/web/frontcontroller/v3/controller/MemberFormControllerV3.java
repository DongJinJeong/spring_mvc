package com.example.demo.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import com.example.demo.servlet.web.frontcontroller.ModelView;
import com.example.demo.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {
	
	@Override
	public ModelView process(Map<String, String> paramMap) {
		return new ModelView("new-form");
	}
	
}
