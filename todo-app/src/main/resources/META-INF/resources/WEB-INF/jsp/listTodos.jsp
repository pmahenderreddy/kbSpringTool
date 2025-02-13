<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>List Todos</title>
	
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<h1>Welcome "${name}"</h1>
		<h1>Your todos</h1>
		<div>
			<div>
				<span>Filtering by: ${filter == "" || filter == null ? "all" : filter}</span>
				<span> |..| </span>
				<span>Number of todos : ${todos.size()}</span>
			</div>
			<hr>
			
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Descripiton</th>
						<th>Target Date</th>
						<th>IsDone</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="item" items="${todos}">
					<tr>
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.description}</td>
						<td>${item.targetDate}</td>
						<td>${item.done}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div>
				<a href="add-todo" class="btn btn-success">Add Todo</a>
			</div>
		</div>
	</div>
	
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>