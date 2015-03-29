<!DOCTYPE html>
<html>
<head>
	<!-- 	{{>/WEB-INF/includes/essentials.jsp}} -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<h3>Mensagem: ${message}</h3>
	<h3 data-bind="text: helloKnockoutjs"></h3>
	
	<label>Digite o id do usuário</label>
	<input id="idProfileSteam" type="text" data-bind="value: steamId">
	<button id="btnSearhProfile" data-bind="click: loadSteamProfile">Pesquisar</button>
	
	<div id="steamUserData" data-bind="visible: dados.steamId">
		<label id="realName" data-bind="text: dados.realName"></label>
		<label id="nickName" data-bind="text: dados.nickName"></label>
		<img id="avatar" data-bind="attr: {src: dados.avatar}">
		<select name="gameList" data-bind="options: gamesCombo,
										   optionsText: 'name',
										   optionsValue: 'appId',
										   optionsCaption: 'Selecione...'
										   ">

		</select>
	</div>
	

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/knockout-3.3.0.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/home/home.js"></script>
</body>
</html>
