package br.com.achievehunter.core.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ReadURL {
	
	private static final String JSON_ERROR = "{ \"failed\" : 1 }"; 
	private static final String EMPTY_JSON = "{ }"; 
	
	public static String read(String urlReceived) {
		String urlContent = "";
		try {
			URL url = new URL(urlReceived);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = null;
			if (urlConnection instanceof HttpURLConnection) {
				connection = (HttpURLConnection) urlConnection;
			} else {
				System.out.println("Please enter an HTTP URL.");
			}
			//TODO
			//Better Performance
			if (connection.getInputStream() != null) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String current;
				while ((current = in.readLine()) != null) {
					urlContent += current;
				}
			} else {
				return JSON_ERROR;
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			return JSON_ERROR;
		}
		return urlContent;
	}

	public static String readJSONFeed(String URL) {
	    StringBuilder stringBuilder = new StringBuilder();
	    HttpClient httpClient = new DefaultHttpClient();
	    HttpGet httpGet = new HttpGet(URL);

	    try {

	        HttpResponse response = httpClient.execute(httpGet);
	        StatusLine statusLine = response.getStatusLine();
	        int statusCode = statusLine.getStatusCode();

	        if (statusCode == 200) {

	            HttpEntity entity = response.getEntity();
	            InputStream inputStream = entity.getContent();
	            BufferedReader reader = new BufferedReader(
	                    new InputStreamReader(inputStream));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                stringBuilder.append(line);
	            }

	            inputStream.close();

	        } else {
	        	return JSON_ERROR;
	        }
	    } catch (Exception e) {
	    	System.out.println(e.toString());
	    	return JSON_ERROR;
	    }
	    return stringBuilder.toString();
	}
	
}
