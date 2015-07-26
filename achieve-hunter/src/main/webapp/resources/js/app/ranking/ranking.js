function ViewModel() {
	var self = this;
	
	self.steamIdInformado = ko.observable();

	self.usuario = {
		steamId : ko.observable(),
		realName : ko.observable(),
		nickName : ko.observable(),
		resumo : ko.observable(),
		endereco : ko.observable(),
		avatar : ko.observable(),
		avatarFull : ko.observable(),
		avatarMedium : ko.observable(),
		totalAchievements : ko.observable(),
		games : ko.observableArray([])
	}
		
	self.loadSteamProfile = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/steam/load-profile/' + self.steamIdInformado(), function(data) {
			self.usuario.steamId(data.steamId);
			self.usuario.realName(data.realName);
			self.usuario.nickName(data.nickName);
			self.usuario.resumo(data.resumo);
			self.usuario.endereco(data.endereco);
			self.usuario.avatar(data.avatar);
			self.usuario.avatarFull(data.avatarFull);
			self.usuario.avatarMedium(data.avatarMedium);
			self.usuario.games(data.games);
		}).done(function() {
			$("#ajaxLoader").hide();
			self.loadRankingTotalAchievement();
		});
	}

	self.loadRankingTotalAchievement = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/steam/ranking/' + self.steamIdInformado(), function(data) {
			console.log("ranking: ", data);
		}).done(function() {
			$("#ajaxLoader").hide();
		});
	}
	
};

ko.applyBindings(new ViewModel());