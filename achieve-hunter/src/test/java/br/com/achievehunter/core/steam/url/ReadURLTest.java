package br.com.achievehunter.core.steam.url;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import br.com.achievehunter.core.url.ReadURL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

public class ReadURLTest {
	
	@Test
	public void quandoRecebeUrlValida() {
		//Arrange
		String url = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?steamid=76561198003170021&appid=236430&format=json&key=4869861D43428379308A740BCD9B276D";
		
		//Act
		String jsonResult = ReadURL.readJSONFeed(url);
		
		//Assert
		assertThat("Resultado não deve ser vazio", Strings.isNullOrEmpty(jsonResult), is(false));
	}

	@Test
	public void quandoRecebeUrlInvalida() {
		//Arrange
		String url = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?steamid=76561198003170021&appid=12210&format=json&key=4869861D43428379308A740BCD9B276D";
		
		//Act
		String jsonResult = ReadURL.readJSONFeed(url);
		
		//Assert
		assertThat("Resultado não deve ser vazio", Strings.isNullOrEmpty(jsonResult), is(false));
	}
	
	@Ignore
	@Test
	public void teste() throws Exception {
//	    String url = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?steamid=76561198003170021&appid=12210&format=json&key=4869861D43428379308A740BCD9B276D";
	    String url = "http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?steamid=76561198003170021&appid=236430&format=json&key=4869861D43428379308A740BCD9B276D";
//		JSONObject json = readJsonFromUrl("http://api.steampowered.com/ISteamUserStats/GetUserStatsForGame/v0002/?steamid=76561198003170021&appid=12210&format=json&key=4869861D43428379308A740BCD9B276D");
//	    System.out.println(json.toString());
//	    System.out.println(read(url));
//	    URL jdhst = new URL(url);
	    ObjectMapper mapper = new ObjectMapper();
	    try {
	    	Map<String,Object> readValue = mapper.readValue(url, Map.class);
	    	String teste = String.valueOf(readValue.entrySet().iterator().next().getValue());
	    	System.out.println(teste);
//	    	for (String s : readValue.keySet()) {
//	    		System.out.println(readValue.get(s));
//	    	}
	    } catch (JsonParseException ex) {
	    	System.out.println(ex.toString());
	    	ex.getStackTrace();
	    }
	}
	
}
