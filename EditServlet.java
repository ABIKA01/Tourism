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

import com.places1.ClassNotFoundationException;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServelt")	
public class EditServlet extends HttpServlet {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","root");
			String Id = request.getParameter("id");
			String name = request.getParameter("name");
			String specialist = request.getParameter("specialist");
			String ratings = request.getParameter("ratings");
			String hours_to_reach = request.getParameter("hours_to_reach");
			String created_at  = request.getParameter("created_at ");
			String updated_at = request.getParameter("updated_at");
			pst = conn.prepareStatement("update places1 set name=?,specialist=?,ratings=?,hours_to_reach=?,created_at=?.updated_at=? where id=?");
			pst.setString(1, name);
			pst.setString(2,specialist);
			pst.setString(3, ratings);
			pst.setString(4, hours_to_reach);
			pst.setString(5, created_at);
		    pst.setString(6, updated_at);
		    pst.setString(7, id);
		    row = pst.executeUpdate();
		    out.println("<font color='green'>Record Addedd</font>");
		}catch (SQLException ex) {
			out.println("<font color='red'> Places Added Failed </font>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

