package com.developer.studyroom.control;

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
import com.developer.roominfo.vo.RoomInfoVO;
import com.developer.studyroom.service.StudyroomService;
import com.developer.studyroom.vo.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListRoomController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/studyroom/listroom

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		String hostId = request.getParameter("hostId");

//		HttpSession session = request.getSession(false);
//		String hostId = (String) session.getAttribute("loginId");
		ObjectMapper mapper = new ObjectMapper();
		StudyroomService service = new StudyroomService();
		JSONArray arr = new JSONArray();
		try {
			List<StudyroomVO> list = service.listRoom(hostId);
			for (StudyroomVO vo : list) {
				JSONObject obj = new JSONObject();
				List<RoomInfoVO> rli = vo.getRoomInfoVO();
				for (RoomInfoVO rvo : rli) {
					obj.put("roomSeq", rvo.getRoomSeq());
					System.out.println(rvo.getRoomSeq());
					obj.put("name", rvo.getName());
					obj.put("info", rvo.getInfo());
					obj.put("imgPath", rvo.getImgPath());
					obj.put("person", rvo.getPerson());
					obj.put("price", rvo.getPrice());
					arr.add(obj);
				}
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
