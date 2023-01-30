package com.developer.board.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.board.service.BoardService;
import com.developer.board.vo.BoardVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddBoardController implements Controller {
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		//int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		int category = Integer.parseInt(request.getParameter("category"));
		//int category =2;
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("userId");
		String imgPath = request.getParameter("imgPath");
		
		BoardService service = new BoardService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			service.addBoard(new BoardVO(0, userId, category, title, content, imgPath, null, 0, 0));
			System.out.println("ㅁㅇㄹㅁㄹㅇ");
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		
		return null;
		
	}

}




	
//		ObjectMapper mapper = new ObjectMapper();
//		String collect = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//		collect.replaceAll("\\uFEFF", "");
//		
//        try {
//        JSONParser jsonParser = new JSONParser();
//        JSONObject object 
//        	= (JSONObject) jsonParser.parse(collect);
//
//        TutorVO vo = new TutorVO();
//        vo.setUserId(object.get("userId").toString());
//        vo.setInfo(object.get("info").toString());
//        vo.setImgPath(object.get("imgPath").toString());
//        vo.setStarAvg(Integer.parseInt(object.get("starAvg").toString()));
//        vo.setApplyOk(Integer.parseInt(object.get("applyOk").toString()));
//        
//        System.out.println(vo);
//        
//        TutorService service = new TutorService();
//        service.addTutor(vo);
//        
//        String jsonStr = mapper.writeValueAsString(object);
//		return jsonStr;
//		} catch (ParseException e) {
//			e.printStackTrace();
//			Map<String, String>map = new HashMap<>();
//			map.put("msg1",  e.getMessage());
//			String jsonStr = mapper.writeValueAsString(map);
//			return jsonStr;
//		} catch (FindException e) {
//			e.printStackTrace();
//			Map<String, String>map = new HashMap<>();
//			map.put("msg2",  e.getMessage());
//			String jsonStr = mapper.writeValueAsString(map);
//			return jsonStr;
//		}
//	}
//
//}
//


