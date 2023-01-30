package com.developer.lesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lesson.service.LessonService;
import com.developer.lesson.vo.LessonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelectLessonDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		ObjectMapper mapper = new ObjectMapper();
		LessonService service = new LessonService();
		
		int lessonSeq = Integer.parseInt(request.getParameter("lessonSeq"));
		try {
			LessonVO vo = service.selectLessonDetail(lessonSeq);
			String jsonStr = mapper.writeValueAsString(vo);
			System.out.println(vo);
			return jsonStr;
			
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	
		
	}

}
