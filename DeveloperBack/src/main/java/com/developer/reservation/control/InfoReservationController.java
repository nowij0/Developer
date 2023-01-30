package com.developer.reservation.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.reservation.service.ReservationService;
import com.developer.reservation.vo.ReservationVO;
import com.developer.roominfo.vo.RoomInfoVO;
import com.developer.studyroom.vo.StudyroomVO;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InfoReservationController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/reservation/inforeservation

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		int resSeq = Integer.parseInt(request.getParameter("resSeq"));
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		ReservationService service = new ReservationService();
		JSONObject obj = new JSONObject();
		try {

			ReservationVO vo = service.infoReservation(resSeq);
			obj.put("resSeq", vo.getResSeq());
			UsersVO uvo = vo.getUsersVO();
			obj.put("uName", uvo.getName());
			obj.put("tel", uvo.getTel());
			StudyroomVO svo = vo.getStudyroomVO();
			List<RoomInfoVO> rli = svo.getRoomInfoVO();
			for (RoomInfoVO rvo : rli) {
				obj.put("rifName", rvo.getName());

			}
			String usingDate = dateformat.format(vo.getUsingDate());
			obj.put("usingDate", usingDate);
			obj.put("startTime", vo.getStartTime());
			obj.put("endTime", vo.getEndTime());
			obj.put("hostId", vo.getHostId());
			String jsonStr = mapper.writeValueAsString(obj);
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