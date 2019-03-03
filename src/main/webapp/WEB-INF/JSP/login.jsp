
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="loginRequest" scope="request" type="application.models.LoginModel"/>
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
			</div>
			<div class="card-body">
				<form:form action="" method="post" modelAttribute="loginRequest">

					<form:errors path="email" cssClass="text-danger small"/>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<form:input path="email" type="text" cssClass="form-control" placeholder="Username"/>

					</div>

					<form:errors path="password" cssClass="text-danger small"/>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<form:input path="password" type="password" cssClass="form-control" placeholder="Password"/>
					</div>

					<div class="form-group">
						<input type="submit" name="btn" value="Login" class="btn btn-outline-danger float-right login_btn">
					</div>
					<c:if test="${loginRequest.errorMessage != null || loginRequest.errorMessage.equals(\"\")}">
						<div class="form-control">
							<blockquote class="text-danger small">${loginRequest.errorMessage}</blockquote>
						</div>
					</c:if>
				</form:form>
			</div>
		</div>
	</div>
	</body>
</html>