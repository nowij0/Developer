package com.developer.studyroom.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.studyroom.service.StudyroomService;
import com.developer.studyroom.vo.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InfoCafeController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/studyroom/infocafe

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
        String hostId = request.getParameter("hostId"); 

//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");

		StudyroomService service = new StudyroomService();
		ObjectMapper mapper = new ObjectMapper();
		JSONObject obj = new JSONObject();
		try {
			StudyroomVO vo = service.infoCafe(hostId);
			obj.put("srSeq", vo.getSrSeq());
			obj.put("name", vo.getName());
			obj.put("addr", vo.getAddr());
			obj.put("info", vo.getInfo());
			obj.put("openTime", vo.getOpenTime());
			obj.put("endTime", vo.getEndTime());
			obj.put("imgPath", vo.getImgPath());
			obj.put("oc",vo.getOc());
			obj.put("hostId", vo.getHostId());
			String jsonStr = mapper.writeValueAsString(vo);
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

