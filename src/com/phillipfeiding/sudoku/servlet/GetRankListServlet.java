package com.phillipfeiding.sudoku.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class GetRankListServlet
 */
@WebServlet("/GetRankListServlet")
public class GetRankListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRankListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final class UserTime {
			public String user;
			public Integer time;
			
			public UserTime(String user, Integer time) {
				this.user = user;
				this.time = time;
			}
		}
		
		List<UserTime> userTime = new ArrayList<>();
		userTime.add(new UserTime("Tim", 23323));
		userTime.add(new UserTime("Alok", 30786));
		userTime.add(new UserTime("Ashley", 45667));
		
		String user = request.getParameter("user");
		Integer time = null;
		try {
			time = Integer.parseInt(request.getParameter("time"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (user != null && time != null) {
			userTime.add(new UserTime(user, time));
			Collections.sort(userTime, (item1, item2) -> item1.time - item2.time);
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(JSON.toJSONString(userTime));
		System.out.println(JSON.toJSONString(userTime));
	}

}
