<div class="container-fluid">

	<!-- Page Heading -->
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">
	            Perfil
	        </h1>
	    </div>
	</div>
	<!-- /.row -->

	<div class="row">

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
					
					<div class="row">
						
						<div class="row-fluid">
							<img id="avatar" data-bind="attr: {src: usuario.avatarMedium}">
							<label id="nickName" data-bind="text: usuario.nickName"></label>
						</div>
						
						<div class="row-fluid">
							<label id="endereco" data-bind="text: usuario.endereco"></label>
						</div>

						<div class="col-lg-12">
							<label for="friends" class="col-lg-6">Lista de Amigos</label>
							<select name="friends" class="col-lg-6"
								data-bind="options: friendsCombo,
										   value: amigoSelecionado,
										   optionsText: 'nickName',
										   optionsValue: 'steamId',
										   optionsCaption: 'Selecione...'">
							</select>
						</div>

						<div class="col-lg-12">
							<label for="games" class="col-lg-6">Lista de Jogos</label>
							<select name="games" class="col-lg-6" data-bind="options: gamesCombo,
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

		</div>
		
		<br>

		<div id="gameAchievements" data-bind="visible: game.appId">
			<div class="panel panel-default">
				<div class="panel-heading">
					<img id="gameLogo" data-bind="attr: {src: game.logoUrl}">
					<strong id="gameName" data-bind="text: game.name"></strong>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
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

		<jsp:include page="../scripts.jsp" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/home/home.js"></script>
	</div>

</div>
<!-- /.container-fluid -->
