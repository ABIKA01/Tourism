package com.places1;

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
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Servlet implementation class places
 */
@WebServlet("/places1")
public class places1 extends HttpServlet {
	Connection conn;
	PreparedStatement pst;
	int row;
	private static final long serialVersionUID = 1L;
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public places1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3001/tourism","root","root");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String specialist = request.getParameter("specialist");
			String ratings = request.getParameter("ratings");
			String hours_to_reach = request.getParameter("hours_to_reach");
			String created_at = request.getParameter("created_at");
			String updated_at = request.getParameter("updated_at");
			pst = conn.prepareStatement("insert into places1(id,name,specialist,ratings,hours_to_reach,created_at,uodated_at) values(?,?,?,?,?,?,?");
			pst.setString(1, id);
			pst.setString(2, name);
			pst.setString(3, specialist);
			pst.setString(4, ratings);
			pst.setString(5, hours_to_reach);
			pst.setString(6, created_at);
			pst.setString(7, updated_at);
			
			row = pst.executeUpdate();
			out.println("<font color='Blue'> Places Added </font>");
		}catch (SQLException ex) {
			out.println("<font color='red'> Places Added Failed </font>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

	private Class<?> getid() {
		// TODO Auto-generated method stub
		return null;
	}

}
