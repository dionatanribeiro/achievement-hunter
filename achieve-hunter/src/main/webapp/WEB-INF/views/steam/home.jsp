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
		
		<div class="row-fluid" data-bind="visible: !esconderMenuPerfil()">
			<div class="form-group">
				<label>Digite o id do usuario</label>
				<input id="idProfileSteam" type="text" class="form-control" data-bind="value: steamIdInformado">
			</div>
			<button id="btnSearhProfile" class="btn btn-primary" data-bind="click: loadSteamProfile">
				<i class="fa fa-steam-square"></i>
				Pesquisar
			</button>
		</div>
		
		<div class="box-spacing-m"></div>

		<div id="steamUserData" data-bind="visible: usuario.steamId">
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<label id="realName" data-bind="text: usuario.realName"></label>
					</h3>
				</div>
				<div class="panel-body">
					
					<div class="row-fluid span6">
						<div class="form-group" style="margin-left: 15px; width: 491px">
							<label for="endereco" >Endereço</label>
							<span id="endereco" class="form-control col-lg-6" data-bind="text: usuario.endereco">
							</span>
						</div>
					</div>

					<div class="box-spacing-m"></div>

					<div class="row-fluid">
						<div class="form-group">
							
							<div class="col-lg-6">
								<label for="games">Games</label>
								<select name="games" class="form-control col-lg-12" data-bind="options: gamesCombo,
																value: gameSelecionado,
																optionsText: 'name',
																optionsValue: 'appId',
																optionsCaption: 'Selecione...'">
								</select>
							</div>

							<div class="col-lg-6">
								<label for="friends">Amigos</label>
								<select name="friends" class="form-control col-lg-12"
									data-bind="options: friendsCombo,
											   value: amigoSelecionado,
											   optionsText: 'nickName',
											   optionsValue: 'steamId',
											   optionsCaption: 'Selecione...'">
								</select>
							</div>

						</div>
					</div>

					<div class="box-spacing-g"></div>

					<div class="row-fluid">
						<div class="col-sm-12 controls">
							
						<button id="btnSearhGame" class="btn btn-primary" data-bind="click: loadGame">
							<i class="fa fa-search"></i>
							Pesquisar
						</button>
					
						<button id="btnCompareAchievements" class="btn btn-primary" data-bind="click: loadAchievementsCompareGrid">
							<i class="fa fa-steam-square"></i>
							Comparar Achievements
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
				<div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                            	<i class="fa fa-long-arrow-right fa-fw"></i> 
                            	Total Achievements desbloqueados
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>
                        </div>
                    </div>
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

		<div id="comparacaoAchievements" data-bind="visible: isCompareAchievement">
			<div class="panel panel-default">
				<div class="panel-heading">
					<img id="gameLogo" data-bind="attr: {src: game.logoUrl}">
					<strong id="gameName" data-bind="text: game.name"></strong>
					<br>
					<label>Total de Achievements do Jogo:</label>
					<p data-bind="text: game.totalAchievements"></p>
					<br>
					<label>Total de Achievements de </label><p data-bind="text: usuario.nickName"></p>
					<p data-bind="text: usuario.totalAchievements"></p>
					<br>
					<label>Total de Achievements de </label><p data-bind="text: amigoComparacao.nickName"></p>
					<p data-bind="text: amigoComparacao.totalAchievements"></p>
					<br>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th data-bind="text: usuario.nickName"></th>
							<th>Nome</th>
							<th>Descricao</th>
							<th>Data Comparacao</th>
							<th data-bind="text: amigoComparacao.nickName"></th>
						</tr>
					</thead>
					<tbody data-bind="foreach: amigoComparacao.achievements">
						<tr>
							<td><img data-bind="attr: { src: achievementIconFirstUser }"></td>
							<td data-bind="text: achievementName"></td>
							<td data-bind="text: achievementDescription"></td>
							<td data-bind="text: $parent.getDateCompare(achievementDateFirstUser, achievementDateSecondUser)"></td>
							<td><img data-bind="attr: { src: achievementIconSecondUser }"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<jsp:include page="../scripts.jsp" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/home/home.js"></script>
	</div>

</div>
<!-- /.container-fluid -->
