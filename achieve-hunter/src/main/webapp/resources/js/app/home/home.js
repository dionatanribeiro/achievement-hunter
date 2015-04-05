function ViewModel() {
	var self = this;
	
	self.dados = {
		steamId : ko.observable(),
		realName : ko.observable(),
		nickName : ko.observable(),
		resumo : ko.observable(),
		endereco : ko.observable(),
		avatar : ko.observable(),
		avatarFull : ko.observable(),
		avatarMedium : ko.observable(),
		games : ko.observableArray([])
	}

	self.game = {
		appId : ko.observable(),
		name : ko.observable(),
		shortName : ko.observable(),
		logoUrl : ko.observable(),
		logoThumbnailUrl : ko.observable(),
		iconUrl : ko.observable(),
		achievements : ko.observableArray([])
	}

	self.steamIdInformado = ko.observable();
	
	self.gamesCombo = ko.observableArray([]);

	self.gameSelecionado = ko.observable();

	self.loadSteamProfile = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/load-steam-profile/' + self.steamIdInformado(), function(data) {
			console.log("profile: ", data);
			self.dados.steamId(data.steamId);
			self.dados.realName(data.realName);
			self.dados.nickName(data.nickName);
			self.dados.resumo(data.resumo);
			self.dados.nickName(data.endereco);
			self.dados.avatar(data.avatar);
			self.dados.avatarFull(data.avatarFull);
			self.dados.avatarMedium(data.avatarMedium);
			self.dados.games(data.games);
			self.gamesCombo(data.games);
		}).done(function() {
			$("#ajaxLoader").hide();
		});
	}

	self.loadGame = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/load-steam-game/' + self.dados.steamId() + '/' + self.gameSelecionado(), function(data) {
			console.log("game: ", data);
			self.game.appId(data.appId);
			self.game.name(data.name);
			self.game.shortName(data.shortName);
			self.game.logoUrl(data.logoUrl);
			self.game.logoThumbnailUrl(data.logoThumbnailUrl);
			self.game.iconUrl(data.iconUrl);
			self.game.achievements(data.achievements);
		}).done(function() {
			$("#ajaxLoader").hide();
		});
	}

};

ko.bindingHandlers.dateTime = {
	/*init: function (element, valueAccessor) {

	},*/
	update: function (element, valueAccessor) {
		var dateTime = valueAccessor();
		dateTime = ko.utils.unwrapObservable(dateTime);

		console.log('element: ', element);
		console.log('valueAccessor(): ', valueAccessor());
		console.log('val: ', dateTime);
		if (dateTime) {
			var dateFormat = new Date(dateTime.year, dateTime.monthValue, dateTime.dayOfMonth, dateTime.hour, dateTime.minute, dateTime.second);
			$(element).text(dateFormat);
		}
	}
};

ko.applyBindings(new ViewModel());