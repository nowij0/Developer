package com.developer.tutor.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.tutor.service.TutorService;
import com.developer.tutor.vo.TutorVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setCharacterEncoding("UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
		String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		collect.replaceAll("\\uFEFF", "");
		
        try {
        JSONParser jsonParser = new JSONParser();
        JSONObject object 
        	= (JSONObject) jsonParser.parse(collect);

        TutorVO vo = new TutorVO();
        //TODO: [JW] 이미 튜터로 등록된 유저라면 추가 등록 못하도록 분기처리 
        vo.setUserId(object.get("userId").toString());
        vo.setInfo(object.get("info").toString());
        vo.setImgPath(object.get("imgPath").toString());
        vo.setStarAvg(Integer.parseInt(object.get("starAvg").toString()));
        vo.setApplyOk(Integer.parseInt(object.get("applyOk").toString()));
        
        TutorService service = new TutorService();
        service.addTutor(vo);
        
        String jsonStr = mapper.writeValueAsString(object);
		return jsonStr;
		} catch (ParseException e) {
			e.printStackTrace();
			Map<String, String>map = new HashMap<>();
			map.put("msg1",  e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String>map = new HashMap<>();
			map.put("msg2",  e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
	}

}
