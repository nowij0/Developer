package com.developer.recommend.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.recommend.service.RecommendService;
import com.developer.recommend.vo.RecommendVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddRecommendController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		
		int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		String userId = request.getParameter("userId");
		ObjectMapper mapper = new ObjectMapper();
		
		RecommendService service = new RecommendService();
		try {
			service.addRecommend(new RecommendVO(0, postSeq, userId));
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
