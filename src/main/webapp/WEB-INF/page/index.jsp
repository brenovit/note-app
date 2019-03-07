<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>NoteApp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>API NotaAqui</h1>
		<h2>Login</h2>
		<form:form method="POST" action="/notaaqui/login" modelAttribute="login">
			<div>
				<form:input type="text" id="username" path="username"
					placeholder="Email/Username" value="breno"/>
				<br />
			</div>
			<div>
				<form:input type="password" id="password" path="password"
					placeholder="Password" value="123" />
				<br />
			</div>
			<div>
				<input type="submit" id="submit" value="Login" />
			</div>
		</form:form>
	</div>
</body>
</html>