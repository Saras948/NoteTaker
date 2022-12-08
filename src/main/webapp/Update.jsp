<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Helper.FactoryProvider"%>
<%@ page import="org.hibernate.*"%>
<%@ page import="com.Entities.Note"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navBar.jsp"%>
		<br>
		<h1>Please Update your Note Detail</h1>

		<%
		int NoteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session ses = FactoryProvider.getFactory().openSession();
		Note un = (Note) ses.get(Note.class, NoteId);
		%>

		<!-- This is add Form -->
		<form action="UpdateServlet" method="post">

			<input type="hidden" value="<%=un.getNid()%> " name ="U_Id">
			<div class="mb-3">
				<label for="title" class="form-label">Note Title</label> <input
					type="text" class="form-control" placeholder="Enter Note Title"
					id="title" name="notetitle" value="<%=un.getTitle()%>" required>
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Note Content</label>
				<textarea id="content" placeholder="Enter your Note Content"
					class="form-control" style="height: 300px" name="notecontent"
					required><%=un.getContent()%></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Update</button>
			</div>
		</form>
	</div>
</body>
</html>