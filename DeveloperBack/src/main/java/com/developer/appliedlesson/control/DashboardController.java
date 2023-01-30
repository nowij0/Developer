package com.developer.appliedlesson.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.appliedlesson.service.AppliedLessonService;
import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DashboardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		String userId = request.getParameter("userId");
		
		//TODO: [JW] 튜티대시보드 완성 
		ObjectMapper mapper = new ObjectMapper();
		try {
			AppliedLessonService service = new AppliedLessonService();
			List<AppliedLessonVO> vo = service.tuteeDashboard(userId);
			
			String jsonStr = mapper.writeValueAsString(vo);
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
