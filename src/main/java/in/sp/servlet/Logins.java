package in.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginForm")
public class Logins extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String myemail = request.getParameter("email1");
		String mypassword = request.getParameter("password1");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("session_name",rs.getString("name") );
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			}
			
			else
			{
			
				out.println("<h3 style='color:red'>Email id and Password did't matached</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/Logins.jsp");
				rd.include(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			out.println("<h3 style='color:red'>Exception Occured"+e.getMessage()+"</h3>");
			RequestDispatcher rd = request.getRequestDispatcher("/Logins.jsp");
			rd.include(request, response);
		}
	}

}
