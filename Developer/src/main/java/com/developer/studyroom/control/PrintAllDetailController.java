package com.developer.studyroom.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.studyroom.StudyroomService;
import com.developer.studyroom.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintAllDetailController implements Controller {

	@Override//성공
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json;charset=UTF-8");
	      response.addHeader("Access-Control-Allow-Origin", "*");
	      
	      ObjectMapper mapper = new ObjectMapper();
	      StudyroomService service = new StudyroomService();
	      int srSeq=Integer.parseInt(request.getParameter("srSeq"));
	      JSONArray arr = new JSONArray();
	      try {
			StudyroomVO vo=service.printAllDetail(srSeq);
			JSONObject obj = new JSONObject();
			obj.put("name", vo.getName());
			obj.put("info", vo.getInfo());
			obj.put("addr", vo.getAddr());
			obj.put("openTime", vo.getOpenTime());
			obj.put("endTime", vo.getEndTime());
			obj.put("imgPath", vo.getImgPath());
			arr.add(obj);
			
			String jsonStr = mapper.writeValueAsString(arr);
			return jsonStr;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("msg",e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	      
	}

}
