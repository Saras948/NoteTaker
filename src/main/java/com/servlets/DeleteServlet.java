package com.servlets;

import java.io.IOException;
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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int Id = Integer.parseInt(request.getParameter("note_id".trim()));

			Session ses = FactoryProvider.getFactory().openSession();
			Transaction tx = ses.beginTransaction();

			Note dn = (Note) ses.get(Note.class, Id);
			ses.delete(dn);
			tx.commit();
			ses.close();
			response.sendRedirect("ShowNote.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
