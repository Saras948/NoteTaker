package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Note;
import com.Helper.FactoryProvider;

public class NoteSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoteSaveServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("notetitle");
		String content = request.getParameter("notecontent");

		Note n = new Note(title, content, new Date());
//		System.out.println(n.getNid());
//		System.out.println(n.getTitle());
		
		Session ses = FactoryProvider.getFactory().openSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(n);
		
		tx.commit();
		ses.close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1 style='text-align:center;'>Note Added Succesfully</h1>");
		out.println("<h1 style='text-align:center;'><a href='ShowNote.jsp'>Show Note</a></h1>");


	}

}
