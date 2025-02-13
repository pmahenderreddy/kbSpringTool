<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add/Edit Todo</title>
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mx-auto" style="width: 400px;">
		<h1>Add/Edit Todo</h1>
		<div>
			<form:form method="POST" modelAttribute="todo">
				<div class="mt-2 p-1">
					<label>Description</label>
					<form:input class="mt-2 p-1" style="width:100%" path="description" type="text" 
						placeholder="Please enter description" required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</div>
				<div class="mt-2 p-1">
					<form:input path="targetDate" type="hidden" value="${todo.targetDate}" />
					<form:input path="done" type="hidden" value="${todo.done}" />
					<form:input path="id" type="hidden" value="${todo.id}" />
					
					<input  style="width: 100%;" value="Add Todo" type="submit" class="btn btn-primary" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>