package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.Statement;
import com.places1.ClassNotFoundationException;

/**
 * Servlet implementation class ExplorePlaces
 */
@WebServlet("/ExplorePlaces")
public class ExplorePlaces extends HttpServlet {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExplorePlaces() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","root");
			String sql ;
			sql = "select * from users";
			Statement stmt = (Statement) conn.createStatement();
			rs = ((java.sql.Statement) stmt).executeQuery(sql);
			out.println("<table cellspace='0' width='350' border='1'>");
			out.println("<tr>");
			out.println("<td> id </td>");
			out.println("<td> name </td>");
			out.println("<td> specialist </td>");
			out.println("<td> ratings </td>");
			out.println("<td> hours_to_reach </td>");
			out.println("<td> created_at </td>");
			out.println("<td> updated_at </td>");
			out.println("<td> Edit </td>");
			out.println("<td> Delete </td>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>" +rs.getString("id")+"</td>");
				out.println("<td>" +rs.getString("name")+"</td>");
				out.println("<td>" +rs.getString("speciality")+"</td>");
				out.println("<td>" +rs.getString("hours_tp_reach")+"</td>");
				out.println("<td>" +rs.getString("created_at")+"</td>");
				out.println("<td>" +rs.getString("updated_at")+"</td>");
				out.println("<td>" +"<a href='Editreturn?id=" +rs.getString("id")+"'>Edit</a>"+"</td>");
				out.println("<td>" +"<a href='Delete?id=" +rs.getString("id")+"'>Delete</a>"+"</td>");
				out.println("</tr>");
				
			}
			out.println("<table/>");;
		}catch (SQLException ex) {
			out.println("<font color='red'> Places Added Failed </font>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
