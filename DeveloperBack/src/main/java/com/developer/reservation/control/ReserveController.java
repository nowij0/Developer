package com.developer.reservation.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.developer.reservation.service.ReservationService;


public class ReserveController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		
	
		ReservationService service = new ReservationService();
		
		String userId = request.getParameter("userId");
		int roomSeq =Integer.parseInt(request.getParameter("roomSeq"));
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date usingDate;
		try {
			usingDate = format.parse(request.getParameter("usingDate"));
			service.insertRv(userId,roomSeq, startTime, endTime, usingDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
