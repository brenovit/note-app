<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Nota Aqui</title>
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

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link
	href="${contextPath}/resources/css/themes/theme-light-blue.min.css"
	rel="stylesheet" />
</head>
<body class="theme-light-blue ls-closed">
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<!-- Page Loader -->
		<div class="page-loader-wrapper">
			<div class="loader">
				<div class="preloader">
					<div class="spinner-layer pl-red">
						<div class="circle-clipper left">
							<div class="circle"></div>
						</div>
						<div class="circle-clipper right">
							<div class="circle"></div>
						</div>
					</div>
				</div>
				<p>Please wait...</p>
			</div>
		</div>
		<!-- #END# Page Loader -->
		<!-- Overlay For Sidebars -->
		<div class="overlay"></div>
		<!-- #END# Overlay For Sidebars -->
		<!-- Top Bar -->
		<nav class="navbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="index"> <img
						src="${contextPath}/resources/logo-via-logohub.png"
						alt="Nota Aqui" width="25%" />
					</a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="javascript:void(0);"
							class="dropdown-toggle" data-toggle="dropdown" role="button">
								<img
								src="https://api.adorable.io/avatars/285/${pageContext.request.userPrincipal.name}.png"
								width="48" height="48" alt="User">
						</a>
							<ul class="dropdown-menu pull-down">
								<li><a href="${contextPath}/settings"><i
										class="material-icons">person</i>Profile</a></li>
								<li role="separator" class="divider"></li>
								<li><a onclick="document.forms['logoutForm'].submit()">
										<i class="material-icons">input</i>Sign Out
								</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>

		<section class="content">
			<div class="container-fluid">
				<!-- Basic Example -->
				<div class="row clearfix">
					<c:forEach items="${ notes }" var="note">
						<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
							<div class="card">
								<div class="header bg-${ note.color }">
									<h2>
										${ note.id } - ${ note.title } <small>${ note.alertTime }</small>
									</h2>
									<ul class="header-dropdown m-r--5">
										<li class="dropdown">
											<a href="javascript:void(0);"
												class="dropdown-toggle" data-toggle="dropdown" role="button"
												aria-haspopup="true" aria-expanded="false">
												<i class="material-icons">more_vert</i>
											</a>
											<ul class="dropdown-menu pull-right">
												<li><a href="javascript:void(0);">Edit</a></li>
												<li><a href="javascript:void(0);">Delete</a></li>												
											</ul>
										</li>
									</ul>
								</div>
								<div class="body">${ note.body }</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>

		<!-- Jquery Core Js -->
		<script src="${contextPath}/resources/plugins/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core Js -->
		<script
			src="${contextPath}/resources/plugins/bootstrap/js/bootstrap.js"></script>

		<!-- Select Plugin Js -->
		<script
			src="${contextPath}/resources/plugins/bootstrap-select/js/bootstrap-select.js"></script>

		<!-- Slimscroll Plugin Js -->
		<script
			src="${contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

		<!-- Waves Effect Plugin Js -->
		<script src="${contextPath}/resources/plugins/node-waves/waves.js"></script>

		<!-- Custom Js -->
		<script src="${contextPath}/resources/js/admin.js"></script>

		<!-- Demo Js -->
		<script src="${contextPath}/resources/js/demo.js"></script>
	</c:if>
</body>
</html>
