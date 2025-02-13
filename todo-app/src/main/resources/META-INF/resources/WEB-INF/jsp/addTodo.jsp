<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Todo</title>
	<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mx-auto" style="width: 400px;">
		<h1>Add Todo</h1>
		<div>
			<form method="POST">
				<div class="mt-2 p-1">
					<label>Description</label>
					<input class="mt-2 p-1" style="width:100%" name="description" type="text" value="" placeholder="Please enter description" required="required" />
				</div>
				<div class="mt-2 p-1">
					<input  style="width: 100%;" value="Add Todo" type="submit" class="btn btn-primary" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>