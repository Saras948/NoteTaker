package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entities.Note;
import com.Helper.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int Uid = Integer.parseInt(request.getParameter("U_Id").trim());
			String U_title = request.getParameter("notetitle");
			String U_content = request.getParameter("notecontent");
			
			Session ses = FactoryProvider.getFactory().openSession();
			Transaction tx = ses.beginTransaction();
			
			Note UN = (Note)ses.get(Note.class, Uid);
			
			UN.setTitle(U_title);
			UN.setContent(U_content);
			UN.setAadeddate(new Date());
			
			tx.commit();
			ses.close();
			response.sendRedirect("ShowNote.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
