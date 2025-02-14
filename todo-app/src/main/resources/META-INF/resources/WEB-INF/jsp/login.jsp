<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login page - this is view from MVC</title>
	
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- ${name} pulls data from model, 
			which is populated in controller in this example  -->
		
		
		<div class="mx-auto mt-3 p-3 text-center" style="width: 400px; border: 3px dotted #CCC">
			<h1 class="text-center">Login Page</h1>
			<pre>${errorMessage}</pre>
			<form method="POST">
				<div class="mt-1 p-1">
					<label style="width: 25%;">Username</label>
					<input name="username" type="text" value="${name}" />
				</div>
				
				<div class="mt-1 p-1">
					<label style="width: 25%;">Password</label>
					<input name="password" type="password" />
				</div>
				<div class="mt-3 p-1 mb-3">
					<input  style="width: 80%;" type="submit" class="btn btn-primary" />
				</div>
			</form>
		</div>
	</div>
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>