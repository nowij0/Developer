package com.developer.board.control;

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

import com.developer.board.service.BoardService;
import com.developer.board.vo.BoardVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListBoardByDateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8888/Developer/board/boardlistbydate

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		

		ObjectMapper mapper = new ObjectMapper();
		BoardService service = new BoardService();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		JSONArray arr = new JSONArray();
		try {
			List<BoardVO> list = service.listBoardByDate();
			for (BoardVO vo : list) {

				JSONObject obj = new JSONObject();
				obj.put("postSeq", vo.getPostSeq());
				UsersVO uvo = vo.getUsersVO();
				obj.put("nickname", uvo.getNickname());
				obj.put("category", vo.getCategory());
				obj.put("title", vo.getTitle());
				obj.put("content", vo.getContent());
				obj.put("imgPath", vo.getImgPath());
				String cDate = dateformat.format(vo.getCDate());
				obj.put("cDate", cDate);
				obj.put("recommend", vo.getRecommend());
				obj.put("cnt", vo.getCnt());
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
