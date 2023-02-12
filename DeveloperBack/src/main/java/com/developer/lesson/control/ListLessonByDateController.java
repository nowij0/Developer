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

public class ListLessonByDateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/studyroom/infohostandcafe

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "http://192.168.0.13:5500");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		ObjectMapper mapper = new ObjectMapper();
		LessonService service = new LessonService();
		JSONArray arr = new JSONArray();
		try {
			List<LessonVO> list = service.listLessonByDate();
			for (LessonVO vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("lessonSeq", vo.getLessonSeq());
				obj.put("lessonName", vo.getLessonName());
				obj.put("imgPath", vo.getImgPath());
				obj.put("price", vo.getPrice());
				arr.add(obj);
			}
			String jsonStr = mapper.writeValueAsString(arr);
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
