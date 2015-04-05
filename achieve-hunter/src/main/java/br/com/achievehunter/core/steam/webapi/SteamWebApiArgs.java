package br.com.achievehunter.core.steam.webapi;

import java.util.HashMap;
import java.util.Map;

public class SteamWebApiArgs {
	
	private static Map<String, String> args;
	
	private SteamWebApiArgs() { }
	
	public static SteamWebApiArgs createParam() {
		args = new HashMap<String, String>();
		return new SteamWebApiArgs();
	}
	
	public SteamWebApiArgs addApiKey() {
		addParam();
		args.put("key=", SteamWebApi.API_KEY.getMessage());
		return this;
	}
	
	public SteamWebApiArgs addSteamId(Long steamId) {
		addParam();
		args.put("steamid=", steamId.toString());
		return this;
	}
	
	public SteamWebApiArgs addAppId(Integer appId) {
		addParam();
		args.put("appid=", appId.toString());
		return this;
	}
	
	public SteamWebApiArgs addFormatJson() {
		addParam();
		args.put("format=", "json");
		return this;
	}

	public String getArgs() {
		String urlArgs = "";
		for (String key : args.keySet()) {
			urlArgs += key + args.get(key);
		}
		return urlArgs;
	}
	
	private void addParam() {
		if (args.isEmpty()) {
			args.put("?", "");
		} else {
			args.put("&", "");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(SteamWebApiArgs.createParam().addSteamId(76561198003170021L).addApiKey().addAppId(12345).addFormatJson().getArgs());
	}
	
}
