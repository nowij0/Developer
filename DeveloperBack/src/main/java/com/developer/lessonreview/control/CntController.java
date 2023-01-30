package com.developer.lessonreview.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lessonreview.service.LessonReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CntController implements Controller {
	
	private LessonReviewService service;
	public CntController() {
		service = new LessonReviewService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
				
		String userId = request.getParameter("userId");
		
		Map<String, Object> map = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		String result;
		try {
			int cnt = service.cntReviewTutor(userId);
			result = mapper.writeValueAsString(cnt);
		} catch (FindException e) {
			e.printStackTrace();
			map.put("status", -1);
			map.put("msg", e.getMessage());
			result = mapper.writeValueAsString(map);
		}
		
		return result;
	}

}
