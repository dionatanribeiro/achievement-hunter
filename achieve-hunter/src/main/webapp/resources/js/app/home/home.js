function ViewModel() {
	var self = this;
	
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

	self.game = {
		appId : ko.observable(),
		name : ko.observable(),
		shortName : ko.observable(),
		logoUrl : ko.observable(),
		logoThumbnailUrl : ko.observable(),
		iconUrl : ko.observable(),
		totalAchievements : ko.observable(),
		achievements : ko.observableArray([])
	}

	self.steamIdInformado = ko.observable();
	
	self.friendsCombo = ko.observableArray([]);
	self.gamesCombo = ko.observableArray([]);

	self.gameSelecionado = ko.observable();
	
	self.amigoSelecionado = ko.observable();

	self.isCompareAchievement = ko.observable(false);

	self.amigoComparacao = {
		nickName: ko.observable(),
		avatar: ko.observable(),
		totalAchievements: ko.observable(),
		achievements: ko.observableArray([])	
	}

	self.esconderMenuPerfil = ko.observable(false);

	self.loadSteamProfile = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/steam/load-profile/' + self.steamIdInformado(), function(data) {
			console.log("profile: ", data);
			self.usuario.steamId(data.steamId);
			self.usuario.realName(data.realName);
			self.usuario.nickName(data.nickName);
			var resumoFormatado = data.resumo.replace("<br>", "");
			self.usuario.resumo(resumoFormatado);
			self.usuario.endereco(data.endereco);
			self.usuario.avatar(data.avatar);
			self.usuario.avatarFull(data.avatarFull);
			self.usuario.avatarMedium(data.avatarMedium);
			self.usuario.games(data.games);
			self.gamesCombo(data.games);
			self.loadFriends();
			self.esconderMenuPerfil(true);
		}).done(function() {
			$("#ajaxLoader").hide();
		});
	}

	self.loadFriends = function() {
		$.getJSON('/achieve-hunter/steam/load-friends/' + self.usuario.steamId(), function(data) {
			console.log("friends: ", data);
			self.friendsCombo(data);
		});
	}

	self.loadGame = function() {
		$("#ajaxLoader").show();
		$.getJSON('/achieve-hunter/steam/load-game/' + self.usuario.steamId() + '/' + self.gameSelecionado(), function(data) {
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

	self.getCompareAchievementsModel = function() {
		self.model = {
			idUser : ko.observable(self.usuario.steamId()),
			idFriend : ko.observable(self.amigoSelecionado()),
			idGame : ko.observable(self.gameSelecionado())
		};
		return ko.toJSON(self.model);
	}

	self.loadAchievementsCompareGrid = function() {
		$("#ajaxLoader").show();
		$.ajax({ 
		    url: "/achieve-hunter/steam/compare-friend-achievements", 
		    type: 'POST', 
		    dataType: 'json', 
		    data: self.getCompareAchievementsModel(), 
		    contentType: 'application/json',
		    mimeType: 'application/json',
		    success: function(data) { 
				console.log("data: ", data);

				self.game.logoUrl(data.gameLogoUrl);
				self.game.name(data.gameName);
				self.game.totalAchievements(data.totalGameAchievement);
				self.usuario.totalAchievements(data.totalAchievementUnlockedUser);
				self.amigoComparacao.totalAchievements(data.totalAchievementUnlockedFriend);
				self.amigoComparacao.nickName(data.nickNameFriend);
				self.amigoComparacao.avatar(data.avatarFriend);
				self.amigoComparacao.achievements(data.achievementCompareDto);
				self.isCompareAchievement(true);
				$("#ajaxLoader").hide();
		    },
		    error:function(data,status,er) { 
		        console.log("data: ", data);
				$("#ajaxLoader").hide();
		    }
		});
	}

	self.getDateCompare = function(achievementDateFirstUser, achievementDateSecondUser) {
		return achievementDateFirstUser + " || " + achievementDateSecondUser;
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