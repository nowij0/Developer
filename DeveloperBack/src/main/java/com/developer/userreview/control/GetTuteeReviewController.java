package com.developer.userreview.control;

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
import com.developer.userreview.service.UserReviewService;
import com.developer.userreview.vo.UserReviewVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetTuteeReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		UserReviewService service = new UserReviewService();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		JSONArray array = new JSONArray();
		String userId = request.getParameter("userId");
		try {
			List<AppliedLessonVO> list = service.getTuteeReview(userId);
			for(AppliedLessonVO vo : list) {
				JSONObject obj = new JSONObject();
				List<UsersVO> uli = vo.getUsersVO();
				for(UsersVO uvo : uli) {
					obj.put("name", uvo.getName());
				}
				List<UserReviewVO> urli = vo.getUserReviewVO();
				for(UserReviewVO urvo: urli) {
					obj.put("review", urvo.getReview());
					obj.put("star", urvo.getStar());
				}
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
