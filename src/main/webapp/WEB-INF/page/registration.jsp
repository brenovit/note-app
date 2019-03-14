<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login | NotaAqui</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Sing In | NotaAqui</title>
<!-- Favicon-->
<link rel="icon" href="${contextPath}/resources/favicon.ico"
	type="image/x-icon">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link
	href="${contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Waves Effect Css -->
<link href="${contextPath}/resources/plugins/node-waves/waves.css"
	rel="stylesheet" />

<!-- Animation Css -->
<link href="${contextPath}/resources/plugins/animate-css/animate.css"
	rel="stylesheet" />

<!-- Custom Css -->
<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<body class="signup-page">
	<div class="signup-box">
		<div class="logo">
			<a href="javascript:void(0);">Admin<b>BSB</b></a> <small>Admin
				BootStrap Based - Material Design</small>
		</div>
		<div class="card">
			<div class="body">
				<form:form method="POST" modelAttribute="userForm"
					class="form-signin" id="sign_up">
					<div class="msg">Register a new membership</div>

					<spring:bind path="username">
						<div class="input-group ${status.error ? 'has-error' : ''}">
							<span class="input-group-addon"> <i class="material-icons">person</i>
							</span>
							<div class="form-line">
								<form:input type="text" path="username" class="form-control"
									placeholder="Username" autofocus="true" required="true"></form:input>
								<form:errors path="username"></form:errors>
							</div>
						</div>
					</spring:bind>
					
					<spring:bind path="email">
						<div class="input-group">
							<span class="input-group-addon"> <i class="material-icons">email</i>
							</span>
							<div class="form-line">
								<form:input type="email" path="email" class="form-control"
									name="email" placeholder="Email Address" required="true"></form:input>
							</div>
							<form:errors path="email"></form:errors>
						</div>
					</spring:bind>

					<spring:bind path="password">
						<div class="input-group ${status.error ? 'has-error' : ''}">
							<span class="input-group-addon"> <i class="material-icons">lock</i>
							</span>
							<div class="form-line">
								<form:input type="password" path="password" class="form-control"
									name="password" minlength="6" placeholder="Password" required="true"></form:input>
							</div>
							<form:errors path="password"></form:errors>
						</div>
					</spring:bind>

					<spring:bind path="passwordConfirm">
						<div class="input-group ${status.error ? 'has-error' : ''}">
							<span class="input-group-addon"> <i class="material-icons">lock</i>
							</span>
							<div class="form-line">
								<form:input type="password" path="passwordConfirm"
									class="form-control" placeholder="Confirm your password"
									required="true"></form:input>
							</div>
							<form:errors path="passwordConfirm"></form:errors>
						</div>
					</spring:bind>

					<div class="form-group">
						<input type="checkbox" name="terms" id="terms"
							class="filled-in chk-col-pink" required> <label
							for="terms">I read and agree to the <a
							href="javascript:void(0);">terms of usage</a>.
						</label>
					</div>

					<button class="btn btn-block btn-lg bg-pink waves-effect"
						type="submit">SIGN UP</button>

					<div class="m-t-25 m-b--5 align-center">
						<a href="${contextPath}/login">You already have a membership?</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="${contextPath}/resources/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script
		src="${contextPath}/resources/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="${contextPath}/resources/plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script
		src="${contextPath}/resources/plugins/jquery-validation/jquery.validate.js"></script>

	<!-- Custom Js -->
	<script src="${contextPath}/resources/js/admin.js"></script>
	<script src="${contextPath}/resources/js/pages/sign-up.js"></script>
</body>

</html>