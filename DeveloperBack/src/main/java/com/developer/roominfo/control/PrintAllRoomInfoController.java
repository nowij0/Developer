package com.developer.roominfo.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.roominfo.service.RoomInfoService;
import com.developer.roominfo.vo.RoomInfoVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintAllRoomInfoController implements Controller {

	@Override //성공
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		      response.setCharacterEncoding("UTF-8");
		      response.setContentType("application/json;charset=UTF-8");
		      response.addHeader("Access-Control-Allow-Origin", "*");
		      
		      ObjectMapper mapper = new ObjectMapper();
		      RoomInfoService service = new RoomInfoService();
		     int srSeq = Integer.parseInt(request.getParameter("srSeq"));
		     JSONArray arr = new JSONArray();
		      try {
				List<RoomInfoVO> list= service.selectAll(srSeq);
				for(RoomInfoVO vo:list) {
					JSONObject obj = new JSONObject();
					obj.put("roomSeq", vo.getRoomSeq());
					obj.put("srSeq", vo.getSrSeq());
					obj.put("name", vo.getName());
					obj.put("info", vo.getInfo());
					obj.put("imgPath",vo.getImgPath());
					obj.put("person", vo.getPerson());
					obj.put("price", vo.getPrice());
					arr.add(obj);
				}
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
