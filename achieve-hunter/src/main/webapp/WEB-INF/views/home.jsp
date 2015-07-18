<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Achievement Hunter</title>

	<!-- 	{{>/WEB-INF/includes/essentials.jsp}} -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ajax-loader.css" />
	
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
		
		<div id="steamUserData" data-bind="visible: usuario.steamId">
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<label id="realName" data-bind="text: usuario.realName"></label>
					</h3>
				</div>
				<div class="panel-body">
					
					<div class="row-fluid">
						<img id="avatar" data-bind="attr: {src: usuario.avatarMedium}">
						<label id="nickName" data-bind="text: usuario.nickName"></label>
					</div>
					
					<div class="row-fluid">
						<label id="endereco" data-bind="text: usuario.endereco"></label>
					</div>

					<div class="row-fluid">
						<label for="friends">Lista de Amigos</label>
						<select name="friends" data-bind="options: friendsCombo,
														  value: amigoSelecionado,
														  optionsText: 'nickName',
														  optionsValue: 'steamId',
														  optionsCaption: 'Selecione...'">
						</select>
					</div>

					<div class="row-fluid input-small">
						<label for="games">Lista de Jogos</label>
						<select name="games" class="selectPicker" data-bind="options: gamesCombo,
														value: gameSelecionado,
														optionsText: 'name',
														optionsValue: 'appId',
														optionsCaption: 'Selecione...'">
						</select>
					</div>

					<div class="row-fluid">
						<button id="btnSearhGame" class="btn-default" data-bind="click: loadGame">
							<i class="fa fa-steam-square"></i>
							Pesquisar
						</button>
					</div>

				</div>
			</div>
			</div>

		</div>
		
		<br>

		<div id="gameAchievements" data-bind="visible: game.appId">
			<div class="panel panel-default">
				<div class="panel-heading">
					<img id="gameLogo" data-bind="attr: {src: game.logoUrl}">
					<strong id="gameName" data-bind="text: game.name"></strong>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Nome</th>
							<th>Descrição</th>
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
		</div>

		<div id="comparacaoAchievements" data-bind="visible: comparacaoAchievementComAmigo">
			<table>
				<thead>
					<tr>
						<th data-bind="text: usuario.nickName"></th>
						<th>Nome</th>
						<th>DescriÃ§Ã£o</th>
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
	</div>
</body>
</html>
