function ViewModel() {
	var self = this;
	
	self.helloKnockoutjs = ko.observable("Hello Knockoutjs!");
	
	self.realName = ko.observable();
	
	self.steamId = ko.observable();
	
	self.loadSteamProfile = function() {
		$.get('/achieve-hunter/load-steam-profile/' + self.steamId(), function(data) {
			self.realName(data);
		});
	}
	
};

ko.applyBindings(new ViewModel());