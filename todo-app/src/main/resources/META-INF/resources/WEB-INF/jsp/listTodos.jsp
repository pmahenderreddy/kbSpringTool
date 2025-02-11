<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>List Todos</title>
</head>
<body>
	<h1>List Todos</h1>
	<div>
		<h4>Filtering by: ${filter == "" ? "all" : filter}</h4>
		<h4>Number of todos : ${todos.size()}</h4>
		List of todos : <br>${todos}
	</div>
</body>
</html>