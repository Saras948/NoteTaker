<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navBar.jsp"%>
		<br>
		<h1>Please add your Note Detail</h1>

		<!-- This is add Form -->
		<form action="NoteSaveServlet" method="post">
			<div class="mb-3">
				<label for="title" class="form-label">Note Title</label> <input
					type="text" class="form-control" placeholder="Enter Note Title"
					id="title" name = "notetitle" required>
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">Note Content</label>
				<textarea id="content" placeholder="Enter your Note Content"
					class="form-control" style="height: 300px " name="notecontent" required></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>
		</form>
	</div>
</body>
</html>