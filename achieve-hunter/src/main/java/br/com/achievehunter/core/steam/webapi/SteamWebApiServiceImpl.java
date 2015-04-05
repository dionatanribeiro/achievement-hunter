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
		return readProfileJson(url).stream().findFirst().get();
	}

	@Override
	public List<Profile> findFriendsBySteamId(Long steamId) {
		List<Profile> friends = new ArrayList<>();
		List<Long> listaSteamIds = new ArrayList<>();

		StringBuilder urlFriends = new StringBuilder();
		urlFriends.append(SteamWebApi.BASE_URL.getMessage());
		urlFriends.append(SteamWebApi.FRIEND_LIST.getMessage());
		urlFriends.append(SteamWebApiArgs.createParam().addApiKey().addSteamId(steamId).addFormatJson().getArgs());

		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(urlFriends.toString()));
			JsonNode friendsJson = rootNode.findValue("friends");
			Iterator<JsonNode> elements = friendsJson.elements();
			while (elements.hasNext()) {
				JsonNode steamIdEncontrado = elements.next().get("steamid");
				listaSteamIds.add(steamIdEncontrado.asLong());
			}
			StringBuilder urlProfiles = new StringBuilder();
			urlProfiles.append(SteamWebApi.BASE_URL.getMessage());
			urlProfiles.append(SteamWebApi.PROFILE.getMessage());
			urlProfiles.append(SteamWebApiArgs.createParam().addApiKey().addSteamIds(listaSteamIds).getArgs());
			friends.addAll(readProfileJson(urlProfiles));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return friends;
	}
	
	private List<Profile> readProfileJson(StringBuilder url) {
		List<Profile> profileList = new ArrayList<>();
		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(url.toString()));
			JsonNode players = rootNode.findValue("players");
			Iterator<JsonNode> elements = players.elements();
			while (elements.hasNext()) {
				JsonNode json = elements.next();
				boolean isPublic = json.get("personastate").asInt() == 1;
				if (isPublic) {
					profileList.add(SteamProfileBuilder.builder().withSteamId(json.get("steamid").asLong())
						.withNickName(json.get("personaname").textValue())
						.withAvatarUrl(json.get("avatar").textValue())
						.withAvatarMediumUrl(json.get("avatarmedium").textValue())
						.withAvatarFullUrl(json.get("avatarfull").textValue())
						.withRealName(json.get("realname").textValue())
						.build());
				} else {
					profileList.add(SteamProfileBuilder.builder().withSteamId(json.get("steamid").asLong())
						.withNickName(json.get("personaname").textValue())
						.withAvatarUrl(json.get("avatar").textValue())
						.withAvatarMediumUrl(json.get("avatarmedium").textValue())
						.withAvatarFullUrl(json.get("avatarfull").textValue())
						.build());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return profileList;
	}
	
}
