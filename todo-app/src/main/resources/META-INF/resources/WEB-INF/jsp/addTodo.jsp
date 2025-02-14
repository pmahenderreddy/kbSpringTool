<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add/Edit Todo</title>
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mx-auto" style="width: 400px;">
		<h1>Enter Todo Details</h1>
		<div>
			<form:form method="POST" modelAttribute="todo">
				<fieldset class="mt-2 p-1">
					<form:label path="description">Description</form:label>
					<form:input class="mt-2 p-1" style="width:100%" path="description" type="text" 
						placeholder="Please enter description" required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>
				
				<fieldset class="mt-2 p-1">
					<form:label path="targetDate">Target Date</form:label>
					<form:input class="mt-2 p-1" style="width:100%" path="targetDate"  
						required="required" />
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>
				
				<fieldset class="mt-2 p-1">
					<form:input path="done" type="hidden" value="${todo.done}" />
					<form:input path="id" type="hidden" value="${todo.id}" />
					
					<input  style="width: 100%;" value="Save Todo" type="submit" class="btn btn-primary" />
				</fieldset>
			</form:form>
		</div>
	</div>
	
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>
	
</body>
</html>