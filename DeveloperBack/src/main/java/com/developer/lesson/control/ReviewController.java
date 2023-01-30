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

import com.developer.appliedlesson.vo.AppliedLessonVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lesson.service.LessonService;
import com.developer.lesson.vo.LessonVO;
import com.developer.userreview.vo.UserReviewVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int lessonSeq = Integer.parseInt(request.getParameter("lessonSeq"));
		ObjectMapper mapper = new ObjectMapper();
		JSONArray array = new JSONArray();
		
		LessonService service = new LessonService();
		try {
			List<LessonVO> lList = service.selectAllReview(lessonSeq);
			JSONObject object = new JSONObject();
			for(LessonVO lvo : lList) {
				object.put("lessonSeq", lvo.getLessonName());
				List<AppliedLessonVO> alList = lvo.getAppliedLessonVO();
				for(AppliedLessonVO alvo : alList) {
					object.put("applySeq", alvo.getApplySeq());
					List<UsersVO> uList = alvo.getUsersVO();
					for(UsersVO uvo : uList) {
						object.put("userId", uvo.getUserId());
						object.put("nickname", uvo.getNickname());
					}
					List<UserReviewVO> urList = alvo.getUserReviewVO();
					for(UserReviewVO urvo : urList) {
						object.put("applySeq", urvo.getApplySeq());
						object.put("star", urvo.getStar());
						object.put("review", urvo.getReview());
					}
					}
				array.add(object);
			}
			
			String jsonStr = mapper.writeValueAsString(array);
			System.out.println(jsonStr);
			return jsonStr;
			
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("message", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}

}
