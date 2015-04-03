var steamApiKey = '4869861D43428379308A740BCD9B276D';
var steamUserId = '76561198003170021';

var mainUrl = 'http://api.steampowered.com/';

// Busca dados principais do perfil do usuario
function getPlayerSummaries(steamApiKey, steamUserId) {
	var url = mainUrl + 'ISteamUser/GetPlayerSummaries/v0002/?key=' + steamApiKey + '&steamid=' + steamUserId;
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};

// Retorna lista de amigos do usuario
function getFriendList(steamApiKey, steamUserId) {
	var url = mainUrl + 'ISteamUser/GetFriendList/v0001/?key=' + steamApiKey + '&steamid=' + steamUserId + '&relationship=friend';
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};

//Retorna lista de dados dos achievements por jogo
function getSchemaForGame(steamApiKey, gameId) {
	var url = mainUrl + 'ISteamUserStats/GetSchemaForGame/v2/?key=' + steamApiKey + '&appid=' + gameId;
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
}

// Retorna status dos achievements pelo usuário a partir do id do jogo
function getPlayerAchievementsByGame(steamApiKey, steamUserId, gameId) {
	var url = mainUrl + 'ISteamUserStats/GetPlayerAchievements/v0001/?appid=' + gameId + '&key=' + steamApiKey + '&steamid=' + steamUserId;
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};

// Retorna lista de jogos do usuario
function getOwnedGames(steamApiKey, steamUserId) {
	var url = mainUrl + 'IPlayerService/GetOwnedGames/v0001/?key=' + steamApiKey + '&steamid=' + steamUserId + '&format=json';
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};

// Retorna lista que informa status de desbloqueio de achievements por jogo
function getUserStatsForGame(steamApiKey, steamUserId, gameId) {
	var url = mainUrl + 'ISteamUserStats/GetUserStatsForGame/v0002/?appid=' + gameId + '&key=' + steamApiKey + '&steamid=' + steamUserId;
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};

// Porcentagem global de desbloqueio de conquistas por jogo
function GetGlobalAchievementPercentagesForApp(gameId) {
	var url = mainUrl + 'ISteamUserStats/GetGlobalAchievementPercentagesForApp/v0002/?gameid=' + gameId '&format=json';
	$.getJSON(url, function(data){
    	console.log("data: ", data);
	}).done(function() {
    	console.log("success");
  	});
};
