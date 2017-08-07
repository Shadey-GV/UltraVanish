package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Eat implements Listener {

	@EventHandler
	public void eat(PlayerItemConsumeEvent e) {
		Player player = e.getPlayer();
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.EAT))
			e.setCancelled(true);
	}
}
