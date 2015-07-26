<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Achievement Hunter</title>

	<!-- 	{{>/WEB-INF/includes/essentials.jsp}} -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ajax-loader.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/knockout-3.3.0.js"></script>
</head>
<body>
<div>

	<div id="ajaxLoader" class="loader" data-bind="visible: false">
	   <center class="loading-image">
	       <i class="fa fa-cog fa-spin"></i>
	   </center>
	</div>

	<label>Digite o id do usuario</label>
	<input id="idProfileSteam" type="text" data-bind="value: steamIdInformado">
	<button id="btnSearhProfile" class="btn-default" data-bind="click: loadSteamProfile">
		<i class="fa fa-steam-square"></i>
		Pesquisar
	</button>

	<div id="steam-ranking" data-bind="visible: usuario.steamId">
		
		<div class="panel-heading">
			<h3 class="panel-title">
				<label id="ranking-title" data-bind="text: 'Ranking'"></label>
			</h3>
		</div>
			
		<div id="ranking-content">
			
		</div>
			
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/ranking/ranking.js"></script>
</div>
</body>
</html>