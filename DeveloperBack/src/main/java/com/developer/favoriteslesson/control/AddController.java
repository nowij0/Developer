package com.developer.favoriteslesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.favoriteslesson.service.FavoritesLessonService;
import com.developer.favoriteslesson.vo.FavoritesLessonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
		String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		collect.replaceAll("\\uFEFF", "");
		
        try {
        	JSONParser jsonParser = new JSONParser();
			JSONObject object 
				= (JSONObject) jsonParser.parse(collect);
			
			FavoritesLessonVO vo = new FavoritesLessonVO();
			vo.setUserId(object.get("userId").toString());
			vo.setFavLesSeq(Integer.parseInt(object.get("favLesSeq").toString()));
			vo.setLessonSeq(Integer.parseInt(object.get("lessonSeq").toString()));
			
			FavoritesLessonService service = new FavoritesLessonService();
			service.addFavLesson(vo);
			
	        String jsonStr = mapper.writeValueAsString(object);
			return jsonStr;
		} catch (ParseException e) {
			e.printStackTrace();
			Map<String, String>map = new HashMap<>();
			map.put("msg1",  e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String>map = new HashMap<>();
			map.put("msg2",  e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		} 
	}

}
