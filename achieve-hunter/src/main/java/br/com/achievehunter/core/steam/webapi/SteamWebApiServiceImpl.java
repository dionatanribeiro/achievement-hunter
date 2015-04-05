package br.com.achievehunter.core.steam.webapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.achievehunter.core.steam.builder.SteamProfileBuilder;
import br.com.achievehunter.core.url.ReadURL;
import br.com.achievehunter.model.steam.Profile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SteamWebApiServiceImpl implements SteamWebApiService {

	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Profile findProfileBySteamId(Long steamId) {
		
		StringBuilder url = new StringBuilder();
		url.append(SteamWebApi.BASE_URL.getMessage());
		url.append(SteamWebApi.PROFILE.getMessage());
		url.append(SteamWebApiArgs.createParam().addApiKey().addSteamIds(Arrays.asList(steamId)).getArgs());
		
		//Pesquisar com +1 steamId
		//http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=4869861D43428379308A740BCD9B276D&steamids=76561198003170021,76561198012078770
		
		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(url.toString()));
			JsonNode players = rootNode.findValue("players");
			Iterator<JsonNode> elements = players.elements();
			while (elements.hasNext()) {
				JsonNode json = elements.next();
				boolean isPublic = json.get("personastate").asInt() == 1;
				if (isPublic) {
					return SteamProfileBuilder.builder().withSteamId(json.get("steamid").asLong())
						 .withNickName(json.get("personaname").textValue())
						 .withAvatarUrl(json.get("avatar").textValue())
						 .withAvatarMediumUrl(json.get("avatarmedium").textValue())
						 .withAvatarFullUrl(json.get("avatarfull").textValue())
						 .withRealName(json.get("realname").textValue())
						 .build();
				} else {
					return SteamProfileBuilder.builder().withSteamId(json.get("steamid").asLong())
						.withNickName(json.get("personaname").textValue())
						.withAvatarUrl(json.get("avatar").textValue())
						.withAvatarMediumUrl(json.get("avatarmedium").textValue())
						.withAvatarFullUrl(json.get("avatarfull").textValue())
						.build();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Long> findFriendsBySteamId(Long steamId) {
		List<Long> listaSteamIds = new ArrayList<>();

		StringBuilder url = new StringBuilder();
		url.append(SteamWebApi.BASE_URL.getMessage());
		url.append(SteamWebApi.FRIEND_LIST.getMessage());
		url.append(SteamWebApiArgs.createParam().addApiKey().addSteamId(steamId).addFormatJson().getArgs());

		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(url.toString()));
			JsonNode friends = rootNode.findValue("friends");
			Iterator<JsonNode> elements = friends.elements();
			while (elements.hasNext()) {
				JsonNode steamIdEncontrado = elements.next().get("steamid");
				listaSteamIds.add(steamIdEncontrado.asLong());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaSteamIds;
	}

}
