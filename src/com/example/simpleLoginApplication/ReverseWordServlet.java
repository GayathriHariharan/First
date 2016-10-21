package com.example.simpleLoginApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ReverseWordServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
PrintWriter out=response.getWriter();

HttpSession session=request.getSession(false);

String str=(String) session.getAttribute("user");
char[] strRev = str.toCharArray();

for (int i = str.length() - 1; i >= 0; i--)
	out.print(strRev[i]);


out.println("<form action='index.html'>");
out.println("<input type='submit' value='logout'>");
out.println("</form>");

	}

}
