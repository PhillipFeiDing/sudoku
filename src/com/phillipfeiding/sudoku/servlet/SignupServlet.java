package com.phillipfeiding.sudoku.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//定义规则
		String usernameRegex = "\\w{3,12}";
		String nicknameRegex = ".{3,20}";
		String passwordRegex = ".{6,18}";
		String confirmRegex = request.getParameter("password");
		String emailRegex = "|([a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+)";
		String mobileRegex = "|(1[3578]\\d{9})";
		
		//获取参数
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		System.out.println(username + "/" + nickname + "/" + password + "/" + confirm + "/" + email + "/" + mobile);
		
		//校验
		boolean flag0 = username.matches(usernameRegex);
		boolean flag1 = nickname.matches(nicknameRegex);
		boolean flag2 = password.matches(passwordRegex);
		boolean flag3 = confirm.matches(confirmRegex);
		boolean flag4 = email.matches(emailRegex);
		boolean flag5 = mobile.matches(mobileRegex);
		
		//输出
		System.out.println("username: " + flag0);
		System.out.println("nickname: " + flag1);
		System.out.println("password: " + flag2);
		System.out.println("confirm: " + flag3);
		System.out.println("email: " + flag4);
		System.out.println("mobile: " + flag5);
		
		if (flag0 && flag1 && flag2 && flag3 && flag4 && flag5) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("<p>注册成功</p>");
		} else {
			response.sendRedirect("/sudoku/signup.html");
		}
	}

}
