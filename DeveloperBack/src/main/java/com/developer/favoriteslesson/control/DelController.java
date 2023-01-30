package com.developer.favoriteslesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.favoriteslesson.service.FavoritesLessonService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DelController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		int favLesSeq = Integer.parseInt(request.getParameter("favLesSeq"));

		try {
			FavoritesLessonService service = new FavoritesLessonService();
			service.delFavLesson(favLesSeq);
			
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("message", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		return "삭제완료";

	}

}