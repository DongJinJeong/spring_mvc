package com.example.demo.servlet.web.frontcontroller.v3;

import java.util.Map;

import com.example.demo.servlet.web.frontcontroller.ModelView;

public interface ControllerV3 {

	 ModelView process(Map<String, String> paramMap);
	
}
