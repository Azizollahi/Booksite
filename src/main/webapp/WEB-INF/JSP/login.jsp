<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="login page">
		<meta name="author" content="Hossein Azizollahi">
		<link rel="icon" href="/img/favicon.ico">
		<title>Signin Template for Bootstrap</title>
		<link href="/lib/Bootstrap/bootstrap.min.css" rel="stylesheet">
		<link href="/css/login.css" rel="stylesheet">
	</head>

	<body>
	<div class="container">
		<div class="card card-login mx-auto text-center bg-dark">
			<div class="card-header mx-auto bg-dark">
				<span> <img src="/img/bootstrap-solid.svg" class="w-75" alt="Logo"> </span><br>
				<span class="logo_title mt-5"> Login Dashboard </span>
				<!--            <h1>--><!--?php //echo $message?--><!--</h1>-->

			</div>
			<div class="card-body">
				<form action="" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" name="email" class="form-control" placeholder="Username">
					</div>

					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>

					<div class="form-group">
						<input type="submit" name="btn" value="Login" class="btn btn-outline-danger float-right login_btn">
					</div>

				</form>
			</div>
		</div>
	</div>
	</body>
</html>