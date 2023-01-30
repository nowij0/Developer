package com.developer.lesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lesson.service.LessonService;
import com.developer.lesson.vo.LessonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TutorInfoController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		String userId = request.getParameter("userId");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			LessonService service = new LessonService();
			List<LessonVO> list = service.selectTutor(userId);
			
			String jsonStr = mapper.writeValueAsString(list);
			return jsonStr;
		} catch (FindException e) {
			//실패 
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("message", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}

}
