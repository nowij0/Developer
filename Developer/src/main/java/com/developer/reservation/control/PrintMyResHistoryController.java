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
import com.developer.reservation.ReservationService;
import com.developer.reservation.ReservationVO;
import com.developer.roominfo.RoomInfoVO;
import com.developer.studyroom.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintMyResHistoryController implements Controller {

	@Override //성공
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		
		String userId = request.getParameter("userId");
		
		ObjectMapper mapper = new ObjectMapper();
		ReservationService service = new ReservationService();
		JSONArray arr = new JSONArray();
		try {
			List<ReservationVO> list= service.selectMyResHistory(userId);
			for(ReservationVO vo: list) {
				JSONObject obj = new JSONObject();
				obj.put("resSeq", vo.getResSeq());
				String usingDate = dateformat.format(vo.getUsingDate());
				obj.put("usingDate", usingDate  );
				obj.put("startTime", vo.getStartTime());
				obj.put("endTime", vo.getEndTime());
				
				StudyroomVO sv=vo.getStudyroomVO();
				obj.put("sName", sv.getName());
				
				List<RoomInfoVO> riList=sv.getRoomInfoVO();
				for(RoomInfoVO riv:riList) {
					obj.put("rifName", riv.getName());
				}				
				arr.add(obj);
			}

			String jsonStr = mapper.writeValueAsString(list);
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
