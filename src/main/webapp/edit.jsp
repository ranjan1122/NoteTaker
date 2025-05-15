<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%@page import="com.java.helper.FactoryProvider"%>
<%@page import="com.java.entities.Note"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<h3>
			This is the Edit Page!!
			<h3>
				<%
				Session ssn = FactoryProvider.returnSsnFactory().openSession();
				int noteId = Integer.parseInt(request.getParameter("note_id").trim());
				Note note = ssn.get(Note.class, noteId);
				%>



				
				<!-- <h5>Please Edit the form details!!<h5> -->
				<form action="EditNoteServlet" method="post">
                <input value="<%=note.getId()%>" name="noteIdmark" type="hidden"/>
					<div class="form-group">
						<label for="title">Note Title</label> <input type="text" required
							class="form-control" id="title" aria-describedby="TitleHelp"
							name="title" value="<%=note.getTitle()%>"
							placeholder="Enter Title" />
						<!-- <small class="form-text text-muted">We'll never share your email with anyone else.</small> -->
					</div>
					<div class="form-group">
						<label for="content">Note Content</label>
						<textarea id="content" name="content"
							placeholder="Enter content here" class="form-control"
							style="height: 300px;"><%=note.getContent()%></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Save Your	Note</button>
					</div>
					</form>
	</div>

</body>
</html>