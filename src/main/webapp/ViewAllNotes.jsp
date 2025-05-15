<%@page import="java.util.List"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.java.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.java.entities.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container text-align:center ">
		<%@ include file="navbar.jsp"%>
		<div class="text-align:center">
			<h1 class="text-uppercase text-align:center">All Notes:</h1>
		</div>
		<div class="row">
			<div class="col-12">
				<%
				Session ssn = FactoryProvider.returnSsnFactory().openSession();
				Transaction tx = ssn.beginTransaction();
				Query q = ssn.createQuery("From Note");
				List<Note> notes = q.list();
				for (Note n : notes) {
				%>


				<div class="card mt-3">
					<!-- <img src="..." class="card-img-top" alt="..."> -->
					<!-- how to use padding...marging is better than padding -->
					<!--  <img src="images/notes.png "  style="max-width: 100px" class="card-img-top pl-4 pt-4" alt="Card image cap"> -->
					<!-- how to use margin...marging is better than padding -->
					<!-- how to place an image in the center soln:just add this class "mx-auto"-->
					<img src="images/notes.png " style="max-width: 100px"
						class="card-img-top ml-4 mt-4 mx-auto" alt="Card image cap">
					<div class="card-body">

						<h5 class="card-title"><%=n.getTitle()%></h5>
						<p class="card-text"><%=n.getContent()%></p>
						<div class="container text-center mt-2">
						<a href="DeleteNoteServlet?note_id=<%= n.getId()%>" class="btn btn-primary">Delete</a> 
						<%-- <a href="EditNoteServlet?note_id=<%= n.getId()%>"class="btn btn-warning">Edit</a> --%>
						<a href="edit.jsp?note_id=<%= n.getId()%>"class="btn btn-warning">Edit</a>
						</div>
					</div>
				</div>

				<!-- out.println(n.getId() + " : " + n.getTitle() + " : " + n.getContent() + "<br>"); -->
				<%
				}
				%>
			</div>
		</div>


	</div>

</body>
</html>