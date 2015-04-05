package br.com.achievehunter.core.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public abstract class ReadURL {
	
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
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String current;
			while ((current = in.readLine()) != null) {
				urlContent += current;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlContent;
	}
	
}
