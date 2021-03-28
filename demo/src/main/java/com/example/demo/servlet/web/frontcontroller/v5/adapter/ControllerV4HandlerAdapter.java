package com.example.demo.servlet.web.frontcontroller.v5.adapter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.servlet.web.frontcontroller.ModelView;
import com.example.demo.servlet.web.frontcontroller.v4.ControllerV4;
import com.example.demo.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
	
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV4);
	}

	@Override
	public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		ControllerV4 controller = (ControllerV4) handler;
		Map<String, String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();
		String viewName = controller.process(paramMap, model);
		ModelView mv = new ModelView(viewName);
		mv.setModel(model);
		return mv;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
	
}
