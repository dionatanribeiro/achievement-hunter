package br.com.achievehunter.controller.steam;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.achievehunter.core.steam.steamcompenser.SteamCompenserFacade;
import br.com.achievehunter.model.steam.Game;
import br.com.achievehunter.model.steam.Profile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;

@Controller
public class SteamController {
	
	@Inject
	private SteamCompenserFacade steamFacade;
	
	@ResponseBody
	@RequestMapping(value = "/load-steam-profile/{steamId}", method = RequestMethod.GET)
	public Profile loadProfile(@PathVariable("steamId") Long steamId) throws SteamCondenserException {
		return steamFacade.findSteamProfileBySteamId64(steamId);
	}
	
	@ResponseBody
	@RequestMapping(value = "/load-steam-game/{steamId}/{appId}", method = RequestMethod.GET)
	public Game loadGameByUser(@PathVariable("steamId") Long steamId, @PathVariable("appId") Integer appId) throws SteamCondenserException {
		return steamFacade.findGameByUserIdAndGameId(steamId, appId);
	}
	
}
