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
import com.fasterxml.jackson.databind.ObjectMapper;

public class CheckReservePossibbleController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		 
		ObjectMapper mapper = new ObjectMapper();
		ReservationService service = new ReservationService();
		JSONArray arr = new JSONArray();
		int roomSeq = Integer.parseInt(request.getParameter("roomSeq"));
		java.sql.Date usingDate = java.sql.Date.valueOf(request.getParameter("usingDate"));

		try {
			List<ReservationVO> list = service.selectAllByUsingDate(roomSeq, usingDate);
			for(ReservationVO vo:list) {
				JSONObject obj = new JSONObject();
				obj.put("roomSeq", vo.getRoomSeq());
				obj.put("startTime", vo.getStartTime());
				obj.put("endTime", vo.getEndTime());
				String usingDate1 = format.format(vo.getUsingDate());
				obj.put("usingDate1", vo.getUsingDate());
				
				StudyroomVO sv=vo.getStudyroomVO();
				List<RoomInfoVO> riList=sv.getRoomInfoVO();
				for(RoomInfoVO riv:riList) {
					obj.put("price", riv.getPrice());
				}
				arr.add(obj);
				
			}
			String jsonStr =mapper.writeValueAsString(list);
			return jsonStr;
		} catch (FindException e) {
			
			e.printStackTrace();
			Map<String, Object> map = new HashMap<>();
			map.put("msg",e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
