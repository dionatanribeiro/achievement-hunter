<!DOCTYPE html>
<html>
<head>
	<!-- 	{{>/WEB-INF/includes/essentials.jsp}} -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<h1>Mensagem: ${message}</h1>
	<h2 data-bind="text: helloKnockoutjs"></h2>
	
	<label>Digite o id do usuário</label>
	<input id="idProfileSteam" type="text" data-bind="value: steamId">
	<button id="btnSearhProfile" data-bind="click: loadSteamProfile">Pesquisar</button>
	
	<div id="steamUserData">
		<label data-bind="text: realName"></label>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/knockout-3.3.0.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/home/home.js"></script>
</body>
</html>
