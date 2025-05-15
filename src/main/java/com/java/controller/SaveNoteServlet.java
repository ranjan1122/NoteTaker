package com.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.entities.Note;
import com.java.helper.FactoryProvider;


//@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SaveNoteServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Note note=new Note(title,content,new Date());
		Session ssn=FactoryProvider.returnSsnFactory().openSession();
		Transaction tx=ssn.beginTransaction();
		ssn.save(note);
		tx.commit();
		if(ssn.isOpen()) {
			ssn.close();
		}
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<h1 style='text-align:center'>Note is Added Successfully</h1>");
		out.print("<h1 style='text-align:center'><a href='ViewAllNotes.jsp'>View All Notes</a></h1>");
		
		System.out.println("The id ,title and date info  are :"+note.getId() +" "+ note.getTitle() +" "+ note.getContent() + note.getAddedDate());
	}

}
