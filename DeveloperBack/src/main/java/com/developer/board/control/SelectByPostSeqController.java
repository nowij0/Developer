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
import com.developer.boardrep.vo.BoardRepVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.users.vo.UsersVO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelectByPostSeqController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");

		BoardService service = new BoardService();
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		// int postSeq = 2;
		JSONArray arr = new JSONArray();

		
		try {
			List<BoardVO> list = service.selectByPostSeq(postSeq);
			for (BoardVO vo : list) {
				JSONObject obj = new JSONObject();
				obj.put("category", vo.getCategory());
				obj.put("title", vo.getTitle());
				obj.put("bcontent", vo.getContent());
				obj.put("imgPath", vo.getImgPath());
				String cDate = dateFormat.format(vo.getCDate());
				obj.put("c_Date", cDate);
				obj.put("recommend", vo.getRecommend());
				obj.put("cnt", vo.getCnt());
				UsersVO uvo = vo.getUsersVO();
				obj.put("nickname", uvo.getNickname());
				List<BoardRepVO> blist = vo.getBoardRepVO();
				for (BoardRepVO bvo : blist) {
					obj.put("rcontent", bvo.getContent());
				//	System.out.println(bvo.getContent());
					String date = dateFormat.format(bvo.getDate());
					obj.put("cdate", date);
					arr.add(obj);
				}  
//				ㅗ^^ㅗ
				System.out.println(arr);
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
