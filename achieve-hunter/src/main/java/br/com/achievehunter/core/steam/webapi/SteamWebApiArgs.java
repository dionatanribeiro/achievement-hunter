package br.com.achievehunter.core.steam.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SteamWebApiArgs {
	
	private static Map<String, String> args;
	
	private SteamWebApiArgs() { }
	
	public static SteamWebApiArgs createParam() {
		args = new HashMap<String, String>();
		return new SteamWebApiArgs();
	}
	
	public SteamWebApiArgs addApiKey() {
		args.put("key", SteamWebApi.API_KEY.getMessage());
		return this;
	}
	
	public SteamWebApiArgs addSteamId(Long steamId) {
		args.put("steamid", steamId.toString());
		return this;
	}
	
	public SteamWebApiArgs addSteamIds(List<Long> steamIds) {
		String ids = "";
		boolean first = true;
		for (Long id : steamIds) {
			if (first) {
				first = false;
			} else {
				ids += ",";
			}
			ids += id;
		}
		args.put("steamids", ids);
		return this;
	}
	
	public SteamWebApiArgs addAppId(Integer appId) {
		args.put("appid", appId.toString());
		return this;
	}
	
	public SteamWebApiArgs addFormatJson() {
		args.put("format", "json");
		return this;
	}

	public String getArgs() {
		String urlArgs = "?";
        boolean first = true;
        for(Map.Entry<String, String> arg : args.entrySet()) {
        	if(first) {
                first = false;
            } else {
                urlArgs += '&';
            }
            urlArgs += String.format("%s=%s", arg.getKey(), arg.getValue());
        }
		return urlArgs;
	}
	
}
