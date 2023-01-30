package com.developer.roomreview.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.roomreview.RoomReviewService;
import com.developer.roomreview.RoomReviewVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddRoomReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json;charset=UTF-8");
	      response.addHeader("Access-Control-Allow-Origin", "*");
	      //시퀀스 nextVal인 상홤이라 값입력안됨.
	      String content = request.getParameter("content");
	      int star =Integer.parseInt(request.getParameter("star"));
	      int resSeq=Integer.parseInt(request.getParameter("resSeq"));
			
				 
	      RoomReviewService service = new RoomReviewService();
	      ObjectMapper mapper = new ObjectMapper();
	      try {
	    	  
	    	  service.insertRmRv(content, star, resSeq);
		

			} catch (FindException e) {
				e.printStackTrace();
				Map<String, String>map = new HashMap<>();
				map.put("msg2",  e.getMessage());
				String jsonStr = mapper.writeValueAsString(map);
				return jsonStr;
			}
	      return null;
		}
}

