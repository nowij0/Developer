package com.developer.appliedlesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.appliedlesson.service.AppliedLessonService;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class UpdateNotApplyLessonController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int applySeq = Integer.parseInt(request.getParameter("applySeq"));
		ObjectMapper mapper = new ObjectMapper();
		AppliedLessonService service = new AppliedLessonService();

		try {
			service.updateNotApplyLesson(applySeq);
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		
		return null;
	}

}
