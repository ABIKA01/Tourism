package com.edit;

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
 * Servlet implementation class Editreturn
 */
@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editreturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","root");
			pst = conn.prepareStatement("select * from places1 where id=?");
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				out.print("<form action='EditServlet' method='POST'");
				out.print("<table>'");
				out.print("<tr> <td>id </td>  <td><input type='text' name ='id' id='id' value='"+rs.getString("id")+"'/></tr>");
				out.print("<tr> <td>name </td>  <td><input type='text' name ='name' id='name' value='"+rs.getString("name")+"'/></tr>");
				out.print("<tr> <td>specialist </td>  <td><input type='text' name ='specialist' id='specialist' value='"+rs.getString("specialist")+"'/></tr>");
				out.print("<tr> <td>ratings </td>  <td><input type='text' name ='ratings' id='ratings' value='"+rs.getString("ratings")+"'/></tr>");
				out.print("<tr> <td>hours_to_reach </td>  <td><input type='text' name ='hours_to_reach' id='hours_to_reach' value='"+rs.getString("hours_to_reach")+"'/></tr>");
				out.print("<tr> <td>created_at </td>  <td><input type='text' name ='created_at' id='created_at' value='"+rs.getString("created_at ")+"'/></tr>");
				out.print("<tr> <td>updated_at </td>  <td><input type='text' name ='updated_at' id='updated_at' value='"+rs.getString("updated_at")+"'/></tr>");
				out.print("<tr> <td colspan='2'> </td>  <td><input type='submit'  value='Edit'/></tr>");
				out.print("</form>");
			}
			
			
			
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