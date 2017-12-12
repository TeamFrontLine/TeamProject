package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/todayMenu")
public class Lunch extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>SELECT & POST</title></head>");
		out.println("<body>");
		out.println("<center><h3>오늘점심은</h3></center>");
		String values[] = request.getParameterValues("lunch");
		for (int i = 0; i < values.length; i++) {
			out.print("<br>");
			out.print(values[i]);
		}
		out.println(" 이나 먹어야 겠다");
		out.println("</body></html>");
	}
}