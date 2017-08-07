package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class InteractEntity implements Listener {

	@EventHandler
	public void interacttwo(PlayerInteractEntityEvent e) {
		if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.INTERACT))
			e.setCancelled(true);
	}
}
