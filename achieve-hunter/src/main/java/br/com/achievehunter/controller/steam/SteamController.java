package br.com.achievehunter.controller.steam;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.achievehunter.core.steam.steamcompenser.SteamCompenserFacade;
import br.com.achievehunter.core.steam.webapi.SteamWebApiService;
import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;

@Controller
@RequestMapping(SteamController.BASE_URL)
public class SteamController {
	
	public static final String BASE_URL = "/steam";
	
	@Inject
	private SteamCompenserFacade steamFacade;
	
	@Inject
	private SteamWebApiService steamService;
	
	@ResponseBody
	@RequestMapping(value = "/load-profile/{steamId}", method = RequestMethod.GET)
	public Profile loadProfile(@PathVariable("steamId") Long steamId) throws SteamCondenserException {
		return steamFacade.findSteamProfileBySteamId64(steamId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/load-game/{steamId}/{appId}", method = RequestMethod.GET)
	public Game loadGameByUser(@PathVariable("steamId") Long steamId, @PathVariable("appId") Integer appId) throws SteamCondenserException {
		return steamFacade.findGameByUserIdAndGameId(steamId, appId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/load-friends/{steamId}", method = RequestMethod.GET)
	public List<Profile> loadFriendsByUser(@PathVariable("steamId") Long steamId) {
		return steamService.findFriendsBySteamId(steamId);
	}
	
}
