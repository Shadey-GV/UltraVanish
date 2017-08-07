package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class DropItem implements Listener {

	@EventHandler
	public void drop(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.DROP_ITEM))
			e.setCancelled(true);
	}
}
