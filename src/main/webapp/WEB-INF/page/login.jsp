<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Sing In | NotaAqui</title>
<!-- Favicon-->
<link rel="icon" href="${contextPath}/resources/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" sizes="180x180" href="${contextPath}/resources/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="${contextPath}/resources/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="${contextPath}/resources/favicon-16x16.png">
<link rel="manifest" href="${contextPath}/resources/site.webmanifest">

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

<body class="login-page">
	<div class="login-box">
		<div class="logo">
			<a href="javascript:void(0);">
				<img src="${contextPath}/resources/logo-via-logohub.png" alt="Nota Aqui" width="100%"/>
			</a>
		</div>
		<div class="card">
			<div class="body">
				<form method="POST" action="${contextPath}/login"
					class="form-signin" id="sign_in">
					<div class="msg">Sign in to start your session</div>
					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span>${message}</span> <span>${error}</span>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">person</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required autofocus>
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">lock</i>
						</span>
						<div class="form-line">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-8 p-t-5">
							<input type="checkbox" name="rememberme" id="rememberme"
								class="filled-in chk-col-pink"> <label for="rememberme">Remember
								Me</label>
						</div>
						<div class="col-xs-4">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button class="btn btn-block bg-pink waves-effect" type="submit">SIGN
								IN</button>
						</div>
					</div>
					<div class="row m-t-15 m-b--20">
						<div class="col-xs-6">
							<a href="${contextPath}/registration">Register Now!</a>
						</div>
						<div class="col-xs-6 align-right">
							<a href="${contextPath}/forgot-password">Forgot Password?</a>
						</div>
					</div>
				</form>
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
	<script src="${contextPath}/resources/js/pages/sign-in.js"></script>
</body>

</html>
