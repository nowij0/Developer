package com.developer.userreview.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.userreview.service.UserReviewService;
import com.developer.userreview.vo.UserReviewVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddTuteeReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ObjectMapper mapper = new ObjectMapper();
		UserReviewService service = new UserReviewService();
		
//		JSONObject obj = new JSONObject();
		UserReviewVO vo = new UserReviewVO();
		int a = 0;
		try {

			int applySeq = Integer.parseInt(request.getParameter("applySeq"));
			int star = Integer.parseInt(request.getParameter("star"));
			String review = request.getParameter("review");
			vo = new UserReviewVO(applySeq,star,review);
			a = service.addTuteeReview(vo);
			System.out.println(a);
			return null ;
			
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}

	}

}
