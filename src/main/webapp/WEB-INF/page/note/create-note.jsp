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
<title>Note - Nota Aqui</title>
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

<!-- Bootstrap Material Datetime Picker Css -->
<link href="${contextPath}/resources/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />

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
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header"></div>
						<div class="body">
							<div class="row clearfix">
								<form:form method="POST" modelAttribute="noteForm"
									id="create-note">
									<div class="form-group form-float">
										<div class="form-line">
											<input type="text" class="form-control" id="note-tittle"
												name="Tittle" value="${ note.title }" required />
											<label class="form-label">Tittle</label>
										</div>
									</div>
									<div class="form-group form-float">
										<div class="form-line">
											<input type="text" class="form-control" id="note-body"
												name="Body" value="${ note.body }"
												required />
											<label class="form-label">Body</label>
										</div>
									</div>
									<div class="form-group form-float">
										<div class="form-line">
											<input class="form-control" id="note-color"
												name="Color" value="${ note.color }" required />
											<label class="form-label">Color</label>
										</div>
									</div>
									<div class="form-group">
										<div class="row clearfix">
											<select class="form-control show-tick" id="type">
												<option value="">-- Please select --</option>
												<option value="10">10</option>
												<option value="20">20</option>
												<option value="30">30</option>
												<option value="40">40</option>
												<option value="50">50</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="row clearfix">
											<div class="col-sm-4">
												<div class="form-group">
													<div class="form-line">
														<input type="text" class="datepicker form-control"
															placeholder="Please choose a date...">
													</div>
												</div>
											</div>
											<div class="col-sm-4">
												<div class="form-group">
													<div class="form-line">
														<input type="text" class="timepicker form-control"
															placeholder="Please choose a time...">
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary m-t-15 waves-effect">SUBMIT</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
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
		
		<!-- Moment Plugin Js -->
    	<script src="${contextPath}/resources/plugins/momentjs/moment.js"></script>

    	<!-- Bootstrap Material Datetime Picker Plugin Js -->
    	<script src="${contextPath}/resources/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
		
		<!-- Custom Js -->
		<script src="${contextPath}/resources/js/admin.js"></script>
    	<script src="${contextPath}/resources/js/pages/basic-form-elements.js"></script>

		<!-- Demo Js -->
		<script src="${contextPath}/resources/js/demo.js"></script>
	</c:if>
</body>
</html>
