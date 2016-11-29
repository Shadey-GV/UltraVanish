package me.ishadey.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * 
 *  Connects to iShadey.ga custom metrics. This metrics doesn't
 *  collect information about your server.
 *  
 */

public class CustomMetrics {
	
	private URL addUrl;
	private URL delUrl;
		
	public CustomMetrics(String plugin, JavaPlugin p) {
		try {
			this.addUrl = new URL("http://ishadey.ga/plugins/pluginmanager.php?plugin=" + plugin + "&action=add");
			this.delUrl = new URL("http://ishadey.ga/plugins/pluginmanager.php?plugin=" + plugin + "&action=take");
		} catch (Exception e) {
	        Logger.getLogger("Minecraft").info("Could not connect to iShadey.ga for Metrics.");
		}
	}
			
	
	public void add() throws Exception {
		URLConnection urlConnection = addUrl.openConnection();
		urlConnection.setRequestProperty("User-Agent",  "CraftBukkitPlugin");
		urlConnection.setRequestProperty("Referrer", "CraftBukkitPlugin");
		urlConnection.setDoOutput(true);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String result = bufferedReader.readLine();
		Logger.getLogger("Minecraft").info(result.replace("<br />", ""));
		
	}
	
	public void remove() throws Exception {
		URLConnection urlConnection = delUrl.openConnection();
		urlConnection.setRequestProperty("User-Agent",  "CraftBukkitPlugin");
		urlConnection.setRequestProperty("Referrer", "CraftBukkitPlugin");
		urlConnection.setDoOutput(true);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String result = bufferedReader.readLine();
		Logger.getLogger("Minecraft").info(result.replace("<br />", ""));
	}
}
