<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>List Todos</title>
</head>
<body>
	<h1>Welcome "${name}"</h1>
	<h1>Your todos</h1>
	<div>
		<div>
			<span>Filtering by: ${filter == "" || filter == null ? "all" : filter}</span>
			<span> |..| </span>
			<span>Number of todos : ${todos.size()}</span>
		</div>
		<hr>
		<style>
			div.myrow > span{
				width: 100px;
				display: inline-block;
			}
		</style>
		<c:forEach var="item" items="${todos}">
			<div class="myrow">
		    <span>${item.id}</span>
		    <span>${item.username}</span>
		    <span>${item.description}</span>
		    <span>${item.targetDate}</span>
		    <span>${item.done}</span>
		    </div>
		</c:forEach>		
	</div>	
</body>
</html>