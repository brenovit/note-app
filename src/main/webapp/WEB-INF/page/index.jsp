<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>NotaAqui</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	<header>
		
	</header>
	<div class="container">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h3>
				Welcome ${pageContext.request.userPrincipal.name} | 
				<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h3>
			<div>
				<img id="demo-image"
					src="https://api.adorable.io/avatars/285/${pageContext.request.userPrincipal.name}.png"
					style="width: 285px; height: 285px; border-radius: 50%;"
					alt="demo-image">
			</div>
			
			
	</div>
	</c:if> 
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
