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

public class EditBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		ObjectMapper mapper = new ObjectMapper();
		int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		//int postSeq = 24;
		int category = Integer.parseInt(request.getParameter("category"));
		String userId = request.getParameter("userId");
	//	int category = 3;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String imgPath = request.getParameter("imgPath");
		
		BoardService service = new BoardService();
		try {
			service.editBoard(new BoardVO(postSeq, userId, category, title, content, imgPath, null, 0, 0));
			
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


//package com.bbodeum.program.control;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.bbodeum.control.Controller;
//import com.bbodeum.exception.ModifyException;
//import com.bbodeum.program.service.ProgramService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class UpdateController implements Controller{
//   private Date progEndDate;
//   private Date progStartDate;
//   private Date progDue;
//   
//   @Override
//   public String execute(HttpServletRequest request, HttpServletResponse response)
//         throws IOException, ServletException { 
//
//      ProgramService service = new ProgramService();
//      SimpleDateFormat format = new SimpleDateFormat("YY/MM/DD");
//
//      response.setContentType("application/json;charset=utf-8");
//      response.addHeader("Access-Control-Allow-Origin", "*");
//      
//      int progId = Integer.parseInt(request.getParameter("progId"));
//      String progTitle = request.getParameter("progTitle");
//      String progLocation = request.getParameter("progLocation");
//      int progPrice = Integer.parseInt(request.getParameter("progPrice"));
//      int progRecruitNum = Integer.parseInt(request.getParameter("progRecruitNum"));
//      String progContent = request.getParameter("progContent");
//      try { 
//         progDue = format.parse(request.getParameter("progDue"));
//         progEndDate = format.parse(request.getParameter("progEndDate"));
//         progStartDate = format.parse(request.getParameter("progStartDate"));
//      } catch (ParseException e1) {
//         e1.printStackTrace();
//      }            
//      try {
//         ObjectMapper mapper = new ObjectMapper();
//         service.modify(progId, progTitle, progLocation, progPrice, progRecruitNum, progContent, progDue, progStartDate, progEndDate);
//         return null;
//      } catch (ModifyException e) {
//         e.printStackTrace();
//         Map<String, String> map = new HashMap<>();
//         map.put("msg",e.getMessage());
//         ObjectMapper mapper = new ObjectMapper();
//         String jsonStr = mapper.writeValueAsString(map);
//         return jsonStr;
//      }
//   }
//}