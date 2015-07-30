<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Achievement Hunter</title>

	<!-- STYLE -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sb-admin.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/achievement-hunter-style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ajax-loader.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/avatar-circle.css" />

</head>
<body>

	<!-- AJAX LOADER -->
	<div id="ajaxLoader" class="loader" data-bind="visible: false">
	   <center class="loading-image">
	       <i class="fa fa-cog fa-spin"></i>
	   </center>
	</div>

	<!-- TEMPLATE CONTENT -->
	<jsp:include page="template.jsp" />

</body>
</html>