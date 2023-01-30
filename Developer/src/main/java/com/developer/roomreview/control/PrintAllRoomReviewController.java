package com.developer.roomreview.control;

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
import com.developer.reservation.ReservationVO;
import com.developer.roominfo.RoomInfoVO;
import com.developer.roomreview.RoomReviewService;
import com.developer.roomreview.RoomReviewVO;
import com.developer.studyroom.StudyroomVO;
import com.developer.users.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintAllRoomReviewController implements Controller {

	@Override //성공
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		ObjectMapper mapper = new ObjectMapper();
		RoomReviewService service = new RoomReviewService();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");

		int srSeq = Integer.parseInt(request.getParameter("srSeq"));
		JSONArray arr = new JSONArray();

		try {
			List<RoomReviewVO> list = service.selectAll(srSeq);
			for (RoomReviewVO vo : list) {
				JSONObject obj = new JSONObject();
				String cDate = dateformat.format(vo.getCDate());
				obj.put("cDate", cDate);
				obj.put("star", vo.getStar());
				obj.put("content", vo.getContent());
				
				ReservationVO rvo = vo.getReservationVO();
				
				UsersVO uvo = rvo.getUsersVO();
				obj.put("nickname", uvo.getNickname());
				
				StudyroomVO svo = rvo.getStudyroomVO();
				obj.put("sName", svo.getName());
				
				List<RoomInfoVO> rifList= svo.getRoomInfoVO();
				
				for(RoomInfoVO rifvo :rifList) {
				  obj.put("rifName", rifvo.getName());
				  }
				arr.add(obj);

			}
			String jsonStr = mapper.writeValueAsString(arr);
			return jsonStr;

		} catch (FindException e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}

	}

}
