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
import com.developer.tutor.vo.TutorVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		String search = request.getParameter("search");
		
		ObjectMapper mapper = new ObjectMapper();
		JSONArray array = new JSONArray();
		try {
			LessonService service = new LessonService();
			List<LessonVO> lvo = service.selectSearch(search);
			JSONObject object = new JSONObject();
			for(LessonVO vo : lvo) {
				object.put("lessonSeq", vo.getLessonName());
				object.put("lessonName", vo.getLessonName());
				object.put("category", vo.getCategory());
				object.put("people", vo.getPeople());
				object.put("imgPath", vo.getImgPath());
				object.put("startCdate", vo.getStartCdate());
				object.put("endCdate", vo.getEndCdate());
				object.put("imgPath", vo.getImgPath());
				object.put("price", vo.getPrice());
				object.put("startDate", vo.getStartDate());				
				object.put("endDate", vo.getEndDate());				
				object.put("location", vo.getLocation());
				
				TutorVO tvo = vo.getTutorVO();
				object.put("info", tvo.getInfo());
				object.put("imgPath", tvo.getImgPath());
				object.put("starAvg", tvo.getStarAvg());
				
				UsersVO uvo = tvo.getUsersVO();
				object.put("userId", uvo.getUserId());
				object.put("name", uvo.getName());
				object.put("nickname", uvo.getNickname());
				
				array.add(object);
			}
			
			String jsonStr = mapper.writeValueAsString(lvo);
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
