package br.com.achievehunter.core.steam.webapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SteamWebApiArgsBuilder {
	
	private static Map<String, String> args;
	
	private SteamWebApiArgsBuilder() { }
	
	public static SteamWebApiArgsBuilder createParam() {
		args = new HashMap<String, String>();
		return new SteamWebApiArgsBuilder();
	}
	
	public SteamWebApiArgsBuilder addApiKey() {
		args.put("key", SteamWebApiArgs.API_KEY.getMessage());
		return this;
	}
	
	public SteamWebApiArgsBuilder addSteamId(Long steamId) {
		args.put("steamid", steamId.toString());
		return this;
	}
	
	public SteamWebApiArgsBuilder addSteamIds(List<Long> steamIds) {
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
	
	public SteamWebApiArgsBuilder addAppId(Integer appId) {
		args.put("appid", appId.toString());
		return this;
	}
	
	public SteamWebApiArgsBuilder addFormatJson() {
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
