package com.controller;

import com.dao.DBApplication;
import com.model.UserDetails;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDetails u=new UserDetails();
		u.setUname(request.getParameter("name"));
		
		DBApplication db=new DBApplication();
		int i=db.savedata(u.getUname());
		
		System.out.println("i data"+i);
		if(i>0)
		{
			
			
			request.setAttribute("Name", u.getUname());
			request.getRequestDispatcher("Success.jsp").forward(request, response);
			
			
		}
		else
			response.sendRedirect("Fail.jsp");
		
		
		
		
		
		
	}

}
