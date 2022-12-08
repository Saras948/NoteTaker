<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Helper.FactoryProvider"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="com.Entities.Note"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navBar.jsp"%>
		<br>
		<h1>All Notes</h1>

		<div class="row">
			<div class="col-12">
				<%
				Session ses = FactoryProvider.getFactory().openSession();
				Query q = ses.createQuery("from Note");
				List<Note> list = q.list();
				for (Note i : list) {
				%>

				<div class="card mt-3">
					<img src="image/notes.png" class="card-img-top mx-auto px-3 pt-2"
						style="max-width: 100px" alt="...">
					<div class="card-body px-5">
						<h5 class="card-title text-center"><%=i.getTitle()%></h5>
						<p class="card-text"><%=i.getContent()%></p>
						<div class="container text-center mt-2">
							<a href="DeleteServlet?note_id=<%=i.getNid()%>"
								class="btn btn-danger">Delete</a> <a
								href="Update.jsp?note_id=<%=i.getNid()%>"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>

				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>