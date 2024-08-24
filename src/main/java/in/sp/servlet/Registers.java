package in.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Registers extends HttpServlet {
	@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
{
	PrintWriter out = response.getWriter();
	
	String myname = request.getParameter("name1");
	String myemail = request.getParameter("email1");
	String mypassword = request.getParameter("password1");
	String mygender = request.getParameter("gender1");
	String mycity = request.getParameter("city1");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, myname);
		ps.setString(2, myemail);
		ps.setString(3,mypassword);
		ps.setString(4, mygender);
		ps.setString(5, mycity);
		
		int count= ps.executeUpdate();
		
		if(count > 0)
		{
			response.setContentType("text/html");
			out.println("<h3 style='color:green'> User Register Successfully </h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
		else
		{
			response.setContentType("text/html");
			out.println("<h3 style='color:red'> User  not Register due to some error </h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		response.setContentType("text/html");
		out.println("<h3 style='color:red'> Exception Occured "+e.getMessage()+" </h3>");
		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
		rd.include(request, response);
	}
}
}
