package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Fish implements Listener {

	@EventHandler
	public void fish(PlayerFishEvent e) {
		Player player = e.getPlayer();
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.FISH))
			e.setCancelled(true);
	}
}
