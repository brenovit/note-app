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
<title>Settings - Nota Aqui</title>
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
<link href="${contextPath}/resources/css/themes/theme-light-blue.min.css"
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
		<div class="container-fluid">			
			<div class="row clearfix">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="body">
                            <div>
                                <ul class="nav nav-tabs" role="tablist">	                                    
                                    <li role="presentation" class="active"><a href="#profile_settings" aria-controls="settings" role="tab" data-toggle="tab">Profile Settings</a></li>
                                    <li role="presentation"><a href="#change_password_settings" aria-controls="settings" role="tab" data-toggle="tab">Change Password</a></li>
                                </ul>

                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane fade in active" id="profile_settings">
                                    	<form:form method="POST" modelAttribute="userForm" class="form-horizontal" id="settings">
                                            <div class="form-group">
                                                <label for="NameSurname" class="col-sm-2 control-label">Name</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="NameSurname" name="NameSurname" placeholder="Name Surname" value="${ user.name }" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="NameSurname" class="col-sm-2 control-label">Username</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" id="Username" name="Username" placeholder="Username" value="${ user.username }" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="Email" class="col-sm-2 control-label">Email</label>
                                                <div class="col-sm-10">
                                                    <div class="form-line">
                                                        <input type="email" class="form-control" id="Email" name="Email" placeholder="Email" value="${ user.email }" required>
                                                    </div>
                                                </div>
                                            </div>
                                                                                        
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-danger">SUBMIT</button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div role="tabpanel" class="tab-pane fade in" id="change_password_settings">
                                        <form:form method="POST" modelAttribute="passForm" class="form-horizontal" id="updatePass" action="updatePassword">
                                        	<spring:bind path="oldPassword">
	                                            <div class="form-group">
	                                                <label for="OldPassword" class="col-sm-2 control-label">Old Password</label>
	                                                <div class="col-sm-10">
	                                                    <div class="form-line">
	                                                        <form:input type="password" class="form-control" path="oldPassword" id="OldPassword" name="OldPassword" placeholder="Old Password" required="true" />
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </spring:bind>
                                          	<spring:bind path="newPassword">
	                                            <div class="form-group">
	                                                <label for="NewPassword" class="col-sm-2 control-label">New Password</label>
	                                                <div class="col-sm-10">
	                                                    <div class="form-line">
	                                                        <form:input type="password" class="form-control" path="newPassword" id="NewPassword" name="NewPassword" placeholder="New Password" required="true" />
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </spring:bind>
                                            <spring:bind path="confirmPassword">
	                                            <div class="form-group">
	                                                <label for="NewPasswordConfirm" class="col-sm-2 control-label">New Password (Confirm)</label>
	                                                <div class="col-sm-10">
	                                                    <div class="form-line">
	                                                        <form:input type="password" class="form-control" path="confirmPassword" id="NewPasswordConfirm" name="NewPasswordConfirm" placeholder="New Password (Confirm)" required="true" />
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </spring:bind>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-danger">SUBMIT</button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
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
    <script src="${contextPath}/resources/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="${contextPath}/resources/plugins/bootstrap-select/js/bootstrap-select.js"></script>

    <!-- Slimscroll Plugin Js -->
    <script src="${contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="${contextPath}/resources/plugins/node-waves/waves.js"></script>

    <!-- Custom Js -->
    <script src="${contextPath}/resources/js/admin.js"></script>
    <script src="${contextPath}/resources/js/pages/profile.js"></script>

    <!-- Demo Js -->
    <script src="${contextPath}/resources/js/demo.js"></script>
</body>
</html>
