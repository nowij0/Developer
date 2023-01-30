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
import com.developer.reservation.ReservationVO;
import com.developer.roominfo.RoomInfoVO;
import com.developer.roomreview.RoomReviewVO;
import com.developer.studyroom.StudyroomService;
import com.developer.studyroom.StudyroomVO;
import com.developer.users.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchByAddrAndNameController implements Controller {

	@Override //DAOOracle 해결안됨
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json;charset=UTF-8");
	      response.addHeader("Access-Control-Allow-Origin", "*");
	      
	      ObjectMapper mapper = new ObjectMapper();
	      StudyroomService service = new StudyroomService();
	      String name= request.getParameter("name");
	      int searchBy=Integer.parseInt(request.getParameter("searchBy"));
	      int orderBy=Integer.parseInt(request.getParameter("orderBy"));
	      
	      JSONArray arr = new JSONArray();
	      try {
			List<StudyroomVO> list = service.searchByAddrAndName(name, searchBy, orderBy);
			JSONObject obj = new JSONObject();
			for(StudyroomVO vo: list) {
				obj.put("name", vo.getName());
				obj.put("addr", vo.getAddr());
				obj.put("imgPath", vo.getImgPath());
				List<RoomInfoVO> rifList= vo.getRoomInfoVO();
				
				for(RoomInfoVO rifvo:rifList) {
					obj.put("person", rifvo.getPerson());
					obj.put("price", rifvo.getPrice());
					RoomReviewVO rrv=rifvo.getRoomReviewVO();
					ReservationVO rvo=rrv.getReservationVO();
					UsersVO uvo = rvo.getUsersVO();
					obj.put("userId", uvo.getUserId());
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
