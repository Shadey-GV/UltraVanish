package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

	  @EventHandler
	  public void quit(PlayerQuitEvent e) {
		  if (VanishManager.getVanishManager().isVanished(e.getPlayer()))
			  VanishManager.getVanishManager().unVanish(e.getPlayer());
	  }
}
