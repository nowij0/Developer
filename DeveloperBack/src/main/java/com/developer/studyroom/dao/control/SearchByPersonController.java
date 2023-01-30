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
import com.developer.favoritesstudyroom.FavoritesStudyroomVO;
import com.developer.roominfo.RoomInfoVO;
import com.developer.studyroom.StudyroomService;
import com.developer.studyroom.StudyroomVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchByPersonController implements Controller {

	@Override //성공
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json;charset=UTF-8");
	      response.addHeader("Access-Control-Allow-Origin", "*");
	      
	      ObjectMapper mapper = new ObjectMapper();
	      StudyroomService service = new StudyroomService();
	      int person=Integer.parseInt(request.getParameter("person"));
	      int orderBy=Integer.parseInt(request.getParameter("orderBy"));
	      JSONArray arr = new JSONArray();
	      
	      try {
			List<StudyroomVO>list = service.searchByPerson(person, orderBy);
			for(StudyroomVO vo: list) {
				JSONObject obj = new JSONObject();
				obj.put("name", vo.getName());
				obj.put("addr", vo.getAddr());
				obj.put("imgPath", vo.getImgPath());
				
				FavoritesStudyroomVO fsVO = vo.getFavoritesStudyroomVO();
				obj.put("userId", fsVO.getUserId());
				obj.put("cnt", fsVO.getCnt());
				
				List<RoomInfoVO> rifList= vo.getRoomInfoVO();
				for(RoomInfoVO rvo: rifList) {
					obj.put("person", rvo.getPerson());
					obj.put("price", rvo.getPrice());
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
