package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calcServlet")
// Ŭ���� ���� HttpServlet�� ��� �޴´�.
public class Calc extends HttpServlet {
	// GET ��û�� ó���ϱ� ���� �޼���
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost()�� ������ �ϰ� �ִ�.
		doPost(request, response);
	}

	// Post ��û�� ó���ϱ� ���� �޼���
	// do get()������ ȣ���ϰ� �ֱ� ������ ��� ��û�� doPost()���� ó���Ǵ� �����̴�.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��������
		int num1, num2;
		int result;
		String op;
		// Ŭ���̾�Ʈ ����� ���޵� �������� ���� mime type �� ĳ���ͼ� ����
		response.setContentType("text/html; charset=UTF-8");
		// Ŭ���̾�Ʈ ������ ���� ��� ��Ʈ�� Ȯ��
		PrintWriter out = response.getWriter();
		// HTML form �� ���� ���޵� num1, num2 �з����� ���� ������ �Ҵ�.
		// �̶� getParameter() �޼���� ���ڿ��� �����ϹǷ� ������ �������� ���
		// Integer.parseInt() �� ���� int �� ��ȯ��.
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		// calc() �޼��� ȣ��� ��� �޾ƿ�.
		result = calc(num1, num2, op);

		// ��� ��Ʈ���� ���� ȭ�鱸��
		out.println("<html>");
		out.println("<head><title>����</title></head>");
		out.println("<body><center>");
		out.println("<h2>�����</h2>");
		out.println("<hr>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</body></html>");
	}

	// ���� ��� ����� �����ϴ� �޼���
	public int calc(int num1, int num2, String op) {
		int result = 0;
		if (op.equals("+"))

		{
			result = num1 + num2;
		} else if (op.equals("-")) {
			result = num1 - num2;
		} else if (op.equals("*")) {
			result = num1 * num2;
		} else if (op.equals("/")) {
			result = num1 / num2;
		}
		return result;
	}
}