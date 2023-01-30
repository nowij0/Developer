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

public class DetailController implements Controller {

	private LessonService service;
	public DetailController() {
		service = new LessonService();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int lessonSeq = (Integer.parseInt(request.getParameter("lessonSeq")));
		
		String result;
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<LessonVO> list = service.selectDetail(lessonSeq);
			result = mapper.writeValueAsString(list);
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("status", -1);
			map.put("msg", e.getMessage());
			result = mapper.writeValueAsString(map);
		}
		return result;
	}

}
