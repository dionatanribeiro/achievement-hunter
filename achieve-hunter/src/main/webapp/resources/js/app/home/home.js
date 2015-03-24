function ViewModel() {
	var self = this;
	
	self.helloKnockoutjs = ko.observable("Hello Knockoutjs!");
	
	self.realName = ko.observable();
	
	self.steamId = ko.observable();
	
	self.loadSteamProfile = function() {
		$.getJSON('/achieve-hunter/load-steam-profile/' + self.steamId(), function(data) {
//			self.realName(data);
			console.log("data: ", data);
		});
	}
	
};

ko.applyBindings(new ViewModel());