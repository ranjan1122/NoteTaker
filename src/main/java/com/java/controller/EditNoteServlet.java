package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.entities.Note;
import com.java.helper.FactoryProvider;

/**
 * Servlet implementation class EditNoteServlet
 */
//@WebServlet("/EditNoteServlet")
public class EditNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteIdx=Integer.parseInt(request.getParameter("noteIdmark").trim());
			Session ssn=FactoryProvider.returnSsnFactory().openSession();
			Transaction tx=ssn.beginTransaction();
			Note mynote=ssn.get(Note.class,noteIdx);
			mynote.setTitle(title);
			mynote.setContent(content);
			System.out.println("The current value of Note is...."+mynote);
			//mynote.setAddedDate(new Date());
			ssn.save(mynote);
			tx.commit();			
			ssn.close();
			/*
			 * response.setContentType("text/html"); PrintWriter out=response.getWriter();
			 * out.println("<h1>The Record is updated successfully!!!</h1>");
			 */
			response.sendRedirect("ViewAllNotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

}
