package br.com.achievehunter.core.steam.webapi;

import java.io.IOException;
import java.util.ArrayList;
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
		return readProfileJson(SteamWebApiUrlUtils.getProfile(steamId)).stream().findFirst().get();
	}

	@Override
	public List<Profile> findFriendsBySteamId(Long steamId) {
		List<Profile> friends = new ArrayList<>();
		List<Long> listaSteamIds = new ArrayList<>();
		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(SteamWebApiUrlUtils.getFriendList(steamId)));
			JsonNode friendsJson = rootNode.findValue("friends");
			Iterator<JsonNode> elements = friendsJson.elements();
			while (elements.hasNext()) {
				JsonNode steamIdEncontrado = elements.next().get("steamid");
				listaSteamIds.add(steamIdEncontrado.asLong());
			}
			friends.addAll(readProfileJson(SteamWebApiUrlUtils.getProfileList(listaSteamIds)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return friends;
	}

	private List<Profile> readProfileJson(String url) {
		List<Profile> profileList = new ArrayList<>();
		try {
			JsonNode rootNode = mapper.readTree(ReadURL.read(url));
			JsonNode players = rootNode.findValue("players");
			Iterator<JsonNode> elements = players.elements();
			while (elements.hasNext()) {
				JsonNode json = elements.next();
				boolean isPublic = json.get("personastate").asInt() == 1;
				boolean isRealNameInformed = json.get("realname") != null;
				// Verificar se deve adicionar usuarios com perfil nao publico dentro da lista.
				profileList.add(SteamProfileBuilder.builder().withSteamId(json.get("steamid").asLong())
					.withNickName(json.get("personaname").textValue())
					.withAvatarUrl(json.get("avatar").textValue())
					.withAvatarMediumUrl(json.get("avatarmedium").textValue())
					.withAvatarFullUrl(json.get("avatarfull").textValue())
					.withRealName(isPublic && isRealNameInformed ? json.get("realname").textValue() : "")
					.build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return profileList;
	}
	
}
