package com.developer.reservation.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.developer.reservation.service.ReservationService;
import com.developer.reservation.vo.ReservationVO;
import com.developer.roominfo.vo.RoomInfoVO;
import com.developer.studyroom.vo.StudyroomVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListReservationController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/developer/reservation/listreservation?hostId=

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		String hostId = request.getParameter("hostId");

//				HttpSession session = request.getSession(false);
//				String hostId = (String) session.getAttribute("loginId");

		ObjectMapper mapper = new ObjectMapper();
		ReservationService service = new ReservationService();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		JSONArray arr = new JSONArray();
		try {
			List<ReservationVO> list = service.getAllReservation(hostId);
			for (ReservationVO vo : list) {
				
				JSONObject obj = new JSONObject();
				obj.put("resSeq", vo.getResSeq());
				StudyroomVO svo = vo.getStudyroomVO();
				List<RoomInfoVO> rli = svo.getRoomInfoVO();
				for (RoomInfoVO rvo : rli) {
					obj.put("rifName", rvo.getName());
				}
				obj.put("userId", vo.getUserId());
				UsersVO uvo = vo.getUsersVO();
				if(uvo != null) {
					obj.put("uName", uvo.getName());
				}
				String usingDate = dateformat.format(vo.getUsingDate());
				obj.put("usingDate", usingDate);
				obj.put("startTime", vo.getStartTime());
				obj.put("endTime", vo.getEndTime());
				obj.put("hostId", vo.getHostId());
				arr.add(obj);
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