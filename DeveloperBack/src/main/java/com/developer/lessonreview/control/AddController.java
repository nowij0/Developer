package com.developer.lessonreview.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.lessonreview.service.LessonReviewService;
import com.developer.lessonreview.vo.LessonReviewVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddController implements Controller{
	
	private LessonReviewService service;
	public AddController() {
		service = new LessonReviewService();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		//TODO: [JW] 후기 한번 작성하면 또 못하도록 막기 
		String leRevSeq = request.getParameter("leRevSeq");
		String applySeq = request.getParameter("applySeq");
		String review = request.getParameter("review");
		String star = request.getParameter("star");
		
		LessonReviewVO vo = new LessonReviewVO();
		vo.setLeRevSeq(Integer.parseInt(leRevSeq));
		vo.setApplySeq(Integer.parseInt(applySeq));
		vo.setReview(review);
		vo.setStar(Integer.parseInt(star));
		
		Map<String,Object> map = new HashMap<>(); //응답 상태를 저장하는 맵 
		try {
			service.addReview(vo);
			map.put("status", 1);
		} catch (FindException e) {
			e.printStackTrace();
			map.put("status", 2);
			map.put("msg", e.getMessage());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(map);
		
        return result;
	}

}
