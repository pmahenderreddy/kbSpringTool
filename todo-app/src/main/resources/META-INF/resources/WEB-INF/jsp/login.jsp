<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login page - this is view from MVC</title>
</head>
<body>
	<!-- ${name} pulls data from model, 
		which is populated in controller in this example  -->
	<h1>Welcome to the login page</h1>
	
	<div>
		<pre>${errorMessage}</pre>
		<form method="POST">
			<div>
				<label>Username</label>
				<input name="username" type="text" value="${name}" />
			</div>
			<div>
				<label>Password</label>
				<input name="password" type="password" />
			</div>
			<div>
				<input type="submit" />
			</div>
		</form>
	</div>
</body>
</html>