package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class BedEnter implements Listener {
	  
	  @EventHandler
	  public void bedEnter(PlayerBedEnterEvent e) {
		  if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.BED_USE))
			  e.setCancelled(true);
	  }
}
