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

<!-- Bootstrap Select Css -->
<link href="${contextPath}/resources/plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

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
	</c:if>
	
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
				<a class="navbar-brand" href="${contextPath}/">
					<img src="${contextPath}/resources/logo-via-logohub.png"
						alt="Nota Aqui" width="25%" />
				</a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<div class="m-t-5 align-right">
							<a href="${contextPath}/settings">
								<img
								src="https://api.adorable.io/avatars/285/${pageContext.request.userPrincipal.name}.png"
								style="width:20%; border-radius: 20%;" alt="User">
							</a>
						</div>
					</li>
					<li>
						<a onclick="document.forms['logoutForm'].submit()">
								<i class="material-icons">input</i></a>
					</li>
				</ul>					
			</div>
		</div>
	</nav>
	
	<section class="content">
		
		<c:if test="${ not empty message }">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
		       	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		       		<span aria-hidden="true">&times;</span>
		       	</button>
				${ message }
			</div>
		</c:if>
		
		<div class="container-fluid">
			<div class="row clearfix">		
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="card">
						<div class="header">
							<h2>Create Note</h2>
						</div>
						<div class="body">
							<div class="row clearfix">
								<form:form method="POST" modelAttribute="noteForm" id="create-note" action="${contextPath}/note">
									<spring:bind path="title">
										<div class="col-sm-12">                                    
											<div class="form-group form-float">
												<div class="form-line">
													<form:input path="title" required="true" name="title" type="text" 
													class="form-control" id="note-tittle" value="${ note.title }" />
													<label class="form-label">Tittle</label>													
												</div>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="body">
										<div class="col-sm-12">
											<div class="form-group form-float">
												<div class="form-line">
													<form:input path="body" name="title" type="hidden" id="note-body-content" />
													<textarea name="body" rows="1" maxlength="255"
														class="form-control no-resize auto-growth" id="note-body-textarea">${ note.body }</textarea>
													<label class="form-label">Body</label>
												</div>
												<label id="note-body-label"></label>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="color">
										<div class="col-sm-12">
											<div class="form-group">
												<label for="note-color">Color</label>
												<form:select class="form-control show-tick" path="color" id="note-color">													
													<c:forEach items="${ colors }" var="cl">
														<c:choose>
		            										<c:when test="${cl.value eq note.color}">
		            											<form:option value="${ cl.value }" label="${ cl.name }" class="bg-${ cl.value }" selected="true"/>
		            										</c:when>
		            										<c:otherwise>
		            											<form:option value="${ cl.value }" label="${ cl.name }" class="bg-${ cl.value }" />		            											
	    	        										</c:otherwise>
	            										</c:choose>
													</c:forEach>
												</form:select>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="type">
	                                	<div class="col-sm-12">
											<div class="form-group">
												<label for="note-type">Type</label>
												<form:select class="form-control show-tick" path="type" id="note-type" disabled="${note.type != null ? true : false}">												 	
													<c:forEach items="${ noteTypes }" var="nt">
														<c:choose>
		            										<c:when test="${nt.value eq note.type}">
		            											<form:option value="${ nt.value }" label="${ nt.name }" selected="true"/>
		            										</c:when>
		            										<c:otherwise>
		            											<form:option value="${ nt.value }" label="${ nt.name }" />		            											
	    	        										</c:otherwise>
	            										</c:choose>
													</c:forEach>
												</form:select>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="personName">
										<div id="noteType_1" class="noteType hide">
											<div class="col-sm-12">                                    
												<div class="form-group form-float">
													<div class="form-line ${status.error ? 'error' : ''}">
														<form:input path="personName" type="text" 
														class="form-control" id="note-person-name" value="${ note.personName }" />
														<label class="form-label">Person Name</label>													
													</div>
													<form:errors path="personName"></form:errors>
												</div>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="recipeName">
										<div id="noteType_2" class="noteType hide">
											<div class="col-sm-12">                                    
												<div class="form-group form-float">
													<div class="form-line">
														<form:input path="recipeName" type="text" 
														class="form-control" id="note-recipe-name" value="${ note.recipeName }" />
														<label class="form-label">Recipe Name</label>													
													</div>
												</div>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="time">
										<div id="noteType_3" class="noteType hide">
											<div class="col-sm-12">
												<div class="form-group">
													<div class="form-line">
														<form:input path="time" type="text" 
														class="datetimepicker form-control" id="note-alert-time" value="${ note.alertTime }" 
														placeholder="Please choose a date..." />
													</div>
												</div>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="taskName">
										<div id="noteType_4" class="noteType hide">
											<div class="col-sm-12">                                    
												<div class="form-group form-float">
													<div class="form-line">
														<form:input path="taskName" type="text" 
														class="form-control" id="note-task-name" value="${ note.taskName }" />
														<label class="form-label">Tasks Name</label>													
													</div>
												</div>
											</div>
										</div>
									</spring:bind>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">									
										<div class="form-group">
											<button type="submit" class="btn btn-primary m-t-15 waves-effect">SUBMIT</button>
										</div>
									</div>
								</form:form>
							</div>
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
	
	<!-- Autosize Plugin Js -->
    <script src="${contextPath}/resources/plugins/autosize/autosize.js"></script>
	
	<!-- Custom Js -->
	<script src="${contextPath}/resources/js/admin.js"></script>
   	<script src="${contextPath}/resources/js/pages/note.js"></script>

	<!-- Demo Js -->
	<script src="${contextPath}/resources/js/demo.js"></script>
</body>
</html>
