package com.developer.lessonreview.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lessonreview.service.LessonReviewService;
import com.developer.lessonreview.vo.LessonReviewVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelectLessonReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int lessonSeq = Integer.parseInt(request.getParameter("lessonSeq"));
		
		LessonReviewService service = new LessonReviewService();
		ObjectMapper mapper = new ObjectMapper();
		JSONArray arr= new JSONArray();
		
		try {
			List<AppliedLessonVO> list = service.selectLessonReview(lessonSeq);
			for(AppliedLessonVO vo : list) {
				JSONObject obj = new JSONObject();
				List<UsersVO> ulist = vo.getUsersVO();
				for(UsersVO uvo : ulist) {
					obj.put("name", uvo.getName());
				}
				LessonReviewVO lvo = vo.getLessonReviewVO();
				obj.put("review", lvo.getReview());
				obj.put("star", lvo.getStar());
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
