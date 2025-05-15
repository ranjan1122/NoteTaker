package com.java.controller;

import java.io.IOException;
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
 * Servlet implementation class DeleteNoteServlet
 */
/* @WebServlet("/DeleteNoteServlet") */
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		try {
			Session ssn=FactoryProvider.returnSsnFactory().openSession();
			int note_id=Integer.parseInt(request.getParameter("note_id"));
			Note noteObj=ssn.get(Note.class,note_id);
			ssn.delete(noteObj);
			Transaction txn=ssn.beginTransaction();
			txn.commit();
			ssn.close();
			System.out.println("It is deleting now the data.....");
			response.sendRedirect("ViewAllNotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */
}
