package com.example.simpleLoginApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SimpleLoginApplicationServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/plain");
PrintWriter out=response.getWriter();
		
		
		
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		if(pass.equals(name)){
			
			
			out.println("welcome "+name+"..<br>");
			out.println("You are successfully logged in.<br>");
			
			HttpSession session=request.getSession();
			session.setAttribute("user", name);
			String id=session.getId();
			out.println("Session id = "+ id);
			
			RequestDispatcher rd=request.getRequestDispatcher("option.html");
			rd.forward(request, response);
		
								
		}else{
			out.println("Incorrect password");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request,response);
		}
	}
}
