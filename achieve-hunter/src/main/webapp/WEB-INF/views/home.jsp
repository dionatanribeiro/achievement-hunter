<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Achievement Hunter</title>

	<!-- 	{{>/WEB-INF/includes/essentials.jsp}} -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ajaxLoad.css" />
</head>
<body>
	
	<div id="ajaxLoader" class="loader" data-bind="visible: false">
	   <center class="loading-image">
	       <i class="fa fa-cog fa-spin"></i>
	   </center>
	</div>

	<label>Digite o id do usu�rio</label>
	<input id="idProfileSteam" type="text" data-bind="value: steamIdInformado">
	<button id="btnSearhProfile" class="btn-default" data-bind="click: loadSteamProfile">
		<i class="fa fa-steam-square"></i>
		Pesquisar
	</button>

	<div id="steamUserData" data-bind="visible: dados.steamId">
		<label id="realName" data-bind="text: dados.realName"></label>
		<label id="nickName" data-bind="text: dados.nickName"></label>
		<img id="avatar" data-bind="attr: {src: dados.avatarMedium}">
		<label for="friends">Lista de Amigos</label>
		<select name="friends" data-bind="options: friendsCombo,
										  value: amigoSelecionado,
										  optionsText: 'nickName',
										  optionsValue: 'steamId',
										  optionsCaption: 'Selecione...'">
		</select>
		<label for="games">Lista de Jogos</label>
		<select name="games" data-bind="options: gamesCombo,
										value: gameSelecionado,
										optionsText: 'name',
										optionsValue: 'appId',
										optionsCaption: 'Selecione...'">
		</select>
		<button id="btnSearhGame" class="btn-default" data-bind="click: loadGame">
			<i class="fa fa-steam-square"></i>
			Pesquisar
		</button>
	</div>
	
	<br>

	<div>
		<img id="gameLogo" data-bind="attr: {src: game.logoUrl}">
		<strong><label id="gameName" data-bind="text: game.name"></label></strong>
	</div>

	<div id="gameAchievements" data-bind="visible: game.appId">
		<table>
			<thead>
				<tr>
					<th></th>
					<th>Nome</th>
					<th>Descri��o</th>
					<th>Data desbloqueio</th>
				</tr>
			</thead>
			<tbody data-bind="foreach: game.achievements">
				<tr>
					<td><img data-bind="attr: { src: icon }"></td>
					<td data-bind="text: name"></td>
					<td data-bind="text: description"></td>
					<td data-bind="text: date"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/knockout-3.3.0.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/home/home.js"></script>
</body>
</html>
