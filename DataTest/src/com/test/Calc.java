package com.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calcServlet")
// 클래스 선언 HttpServlet을 상속 받는다.
public class Calc extends HttpServlet {
	// GET 요청을 처리하기 위한 메서드
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost()로 포워딩 하고 있다.
		doPost(request, response);
	}

	// Post 요청을 처리하기 위한 메서드
	// do get()에서도 호출하고 있기 때문에 모든 요청은 doPost()에서 처리되는 구조이다.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수선언
		int num1, num2;
		int result;
		String op;
		// 클라이언트 응답시 전달될 컨텐츠에 대한 mime type 과 캐릭터셋 지정
		response.setContentType("text/html; charset=UTF-8");
		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		// HTML form 을 통해 전달된 num1, num2 패러미터 값을 변수에 할당.
		// 이때 getParameter() 메서드는 문자열을 리턴하므로 숫자형 데이터의 경우
		// Integer.parseInt() 를 통해 int 로 변환함.
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		// calc() 메서드 호출로 결과 받아옴.
		result = calc(num1, num2, op);

		// 출력 스트림을 통해 화면구성
		out.println("<html>");
		out.println("<head><title>계산기</title></head>");
		out.println("<body><center>");
		out.println("<h2>계산결과</h2>");
		out.println("<hr>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</body></html>");
	}

	// 실제 계산 기능을 수행하는 메서드
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