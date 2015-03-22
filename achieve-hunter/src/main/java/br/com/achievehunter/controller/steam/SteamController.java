package br.com.achievehunter.controller.steam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.koraktor.steamcondenser.exceptions.SteamCondenserException;
import com.github.koraktor.steamcondenser.steam.community.SteamId;

@Controller
public class SteamController {
	
	@ResponseBody
	@RequestMapping(value = "/load-steam-profile/{steamId}", method = RequestMethod.GET)
	public String loadSteamProfile(@PathVariable("steamId") long steamId, Model model) throws SteamCondenserException {
		SteamId usuarioSteam = SteamId.create(steamId);
		return usuarioSteam.getRealName();
	}
	
}
