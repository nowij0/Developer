package com.developer.board.control;

import java.io.IOException;
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
import com.fasterxml.jackson.databind.ObjectMapper;

public class SelectAllCntController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		BoardService service = new BoardService();
		ObjectMapper mapper = new ObjectMapper();
		JSONArray arr = new JSONArray();
		
//		select b.cnt, b.recommend,
//		r.post_rep_seq from board b
//		full outer join board_rep r
//		on b.post_seq =
//		r.post_seq
//		where b.post_seq=#{postSeq}
		
		try {
			List<BoardVO> list = service.selectAllCnt(postSeq);
			for(BoardVO vo :list) {
				JSONObject obj = new JSONObject();
				obj.put("cnt", vo.getCnt());
				obj.put("recommend", vo.getRecommend());
				List<BoardRepVO> rlist = vo.getBoardRepVO();
				for(BoardRepVO rvo : rlist) {
					obj.put("post_rep_seq", rvo.getPostRepSeq());
				}
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
