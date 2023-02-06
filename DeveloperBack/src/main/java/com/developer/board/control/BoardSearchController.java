package com.developer.board.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.board.service.BoardService;
import com.developer.board.vo.BoardVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoardSearchController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		BoardService service = new BoardService();
		String title = request.getParameter("title");
		String title2 = "%" + title + "%";
		ObjectMapper mapper = new ObjectMapper();
//		JSONArray arr = new JSONArray();
		try {
			List<BoardVO> list = service.boardSearch(title2);
//			for(BoardVO vo : list) {
//			JSONObject obj = new JSONObject();
//			obj.put("title",vo.getTitle());
//			arr.add(obj);
//			}
			String jsonStr = mapper.writeValueAsString(list);
			System.out.println(jsonStr);
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
