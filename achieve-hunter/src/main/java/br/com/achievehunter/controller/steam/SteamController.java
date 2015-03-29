package br.com.achievehunter.controller.steam;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.achievehunter.core.steam.SteamCompenserFacade;
import br.com.achievehunter.model.steam.Profile;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;

@Controller
public class SteamController {
	
	@Inject
	private SteamCompenserFacade steamFacade;
	
	@ResponseBody
	@RequestMapping(value = "/load-steam-profile/{steamId}", method = RequestMethod.GET)
	public Profile loadSteamProfile(@PathVariable("steamId") long steamId, Model model) throws SteamCondenserException {
		return steamFacade.findSteamProfileBySteamId64(steamId);
	}
	
}
