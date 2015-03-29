function ViewModel() {
	var self = this;
	
	self.dados = {
		steamId : ko.observable(),
		realName : ko.observable(),
		nickName : ko.observable(),
		avatar : ko.observable(),
		avatarFull : ko.observable(),
		avatarMedium : ko.observable(),
		games : ko.observableArray([])
	}

	self.steamId = ko.observable();
	
	self.gamesCombo = ko.observableArray([]);

	self.helloKnockoutjs = ko.observable("Hello Knockoutjs!");
	
	
	self.loadSteamProfile = function() {
		$.getJSON('/achieve-hunter/load-steam-profile/' + self.steamId(), function(data) {
			console.log("data: ", data);
			self.dados.steamId(data.steamId);
			self.dados.realName(data.realName);
			self.dados.nickName(data.nickName);
			self.dados.avatar(data.avatar);
			self.dados.avatarFull(data.avatarFull);
			self.dados.avatarMedium(data.avatarMedium);
			self.dados.games(data.games);
			self.gamesCombo(data.games);
		});
	}

};

ko.applyBindings(new ViewModel());