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
import com.developer.studyroom.vo.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintMyReqRoomReviewController implements Controller {

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
			List<ReservationVO> list = service.selectMyReqRmRv(userId);
			
			for(ReservationVO vo:list) {
				JSONObject obj = new JSONObject();
				obj.put("resSeq",vo.getResSeq());
				String usingDate = dateformat.format(vo.getUsingDate());
				obj.put("usingDate", usingDate);
				obj.put("startTime", vo.getStartTime());
				obj.put("endTime", vo.getEndTime());
				
				StudyroomVO svo =vo.getStudyroomVO();
				obj.put("sName", svo.getName());
				List<RoomInfoVO> riList=svo.getRoomInfoVO();
				for(RoomInfoVO riv:riList) {
					obj.put("rifName", riv.getName());
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
