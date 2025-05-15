<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Note</title>

</head>
<body>

	<div class="container">
		<%@ include file="navbar.jsp"%>
		<br>
		<!--  form -->
		<h5>
			Please fill the form details!!
			<h5>
				<form action="SaveNoteServlet" method="post">

					<div class="form-group">
						<label for="title">Note Title</label> <input type="text" required
							class="form-control" id="title" aria-describedby="TitleHelp"
							name="title"
							placeholder="Enter Title"> <small class="form-text text-muted">We'll never share your email
							with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="content">Note Content</label>
						<textarea id="content" name="content" placeholder="Enter content here" class="form-control"
							style="height: 300px;"></textarea>
					</div>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Add</button>
					</div>

				
	</div>



</body>
</html>

</form>
                <!-- You can use the below code for form -->
				<!-- <form>
					<div class="mb-3">
						<label for="title" class="form-label">Note Title</label> <input
							type="text" required class="form-control" id="title"
							aria-describedby="title">
						<div id="emailHelp" class="form-text">We'll never share your
							email with anyone else.</div>
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Password</label>
						<input type="password" class="form-control"
							id="exampleInputPassword1">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form> -->