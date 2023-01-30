package com.developer.lesson.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.lesson.service.LessonService;

public class AddController implements Controller {

	private LessonService service;
	public AddController() {
		service = new LessonService();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		//TODO: [JW] 덩어리값 프론트에서 어떻게 받아옴?
		
	
		return null;
	}

}
