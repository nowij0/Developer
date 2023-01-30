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

public class UpdateLessonController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		ObjectMapper mapper = new ObjectMapper();
		LessonService service = new LessonService();
		
//set location=#{location}, category=#{category}, people=#{people}, 
//		content=#{content}, price=#{price}
//		,start_cdate=#{startCdate}, end_cdate=#{endCdate}
//		where lesson_seq=#{lessonSeq}
		
		String location = request.getParameter("location");
		String content = request.getParameter("content");
		int category = Integer.parseInt(request.getParameter("category"));
		int people = Integer.parseInt(request.getParameter("people"));
		int price = Integer.parseInt(request.getParameter("price"));
		int lessonSeq = Integer.parseInt(request.getParameter("lessonSeq"));
		//sql.Date양식은 입력받을때, yyyy-MM-dd로 입력해야됨.
		java.sql.Date startCdate = java.sql.Date.valueOf(request.getParameter("startCdate"));
		java.sql.Date endCdate = java.sql.Date.valueOf(request.getParameter("endCdate"));
		
		try {
			service.updateLesson(new LessonVO(lessonSeq, null, null, category, content, people,null, startCdate, endCdate, price, location));
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
