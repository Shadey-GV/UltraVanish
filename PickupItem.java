package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class PickupItem implements Listener {

	@EventHandler
	public void pickup(PlayerPickupItemEvent e) {
		if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.PICKUP_ITEM))
			e.setCancelled(true);
	}
}
