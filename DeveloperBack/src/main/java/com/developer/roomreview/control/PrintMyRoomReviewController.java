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
import com.developer.reservation.vo.ReservationVO;
import com.developer.roominfo.vo.RoomInfoVO;
import com.developer.roomreview.service.RoomReviewService;
import com.developer.roomreview.vo.RoomReviewVO;
import com.developer.studyroom.vo.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintMyRoomReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json;charset=UTF-8");
	      response.addHeader("Access-Control-Allow-Origin", "*");
	      SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
	      
	      ObjectMapper mapper = new ObjectMapper();
	      RoomReviewService service = new RoomReviewService();
	      String userId = request.getParameter("userId");
	      JSONArray arr = new JSONArray();
	      try {
			List<RoomReviewVO> list = service.selectMyRmRv(userId);
			for(RoomReviewVO vo: list) {
				JSONObject obj = new JSONObject();
				String cDate = dateformat.format(vo.getCDate());
				obj.put("cdate", cDate);
				obj.put("star", vo.getStar());
				
				ReservationVO rv = vo.getReservationVO();
				
				StudyroomVO sv = rv.getStudyroomVO();
				
				obj.put("srName", sv.getName());
				
				List<RoomInfoVO> riv= sv.getRoomInfoVO();
				
				for(RoomInfoVO rif : riv ) {
					obj.put("riName", rif.getName());
				}
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
