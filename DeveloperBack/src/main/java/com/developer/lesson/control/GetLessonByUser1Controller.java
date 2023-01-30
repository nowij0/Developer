package com.developer.lesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lesson.service.LessonService;
import com.developer.lesson.vo.LessonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetLessonByUser1Controller implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		LessonService service = new LessonService();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		JSONArray array = new JSONArray();
		String userId = request.getParameter("userId");
		try {
			List<LessonVO> list = service.getLessonByUser1(userId);
			
			for(LessonVO vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("lessonName", vo.getLessonName());
//				String startCdate = dateformat.format(vo.getStartCdate());
//				String endCdate = dateformat.format(vo.getEndCdate());
//				obj.put("startCdate", startCdate);
//				obj.put("endCdate", endCdate);
				array.add(obj);
			}
			String jsonStr = mapper.writeValueAsString(array);
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
