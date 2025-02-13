<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Welcome page</title>
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mx-auto" style="width: 600px;">
		<h1>Welcome ${name}!</h1>
		<div>
			<div>
				<a href="/list-todos">Manage my todo's</a>
			</div>
			<div>
				<a href="/list-todos-filter">Manage filter todo's (to demonstrate session user/last-filter-used)</a>
			</div>
		</div>
	</div>
</body>
</html>