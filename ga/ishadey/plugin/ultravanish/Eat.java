package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Eat implements Listener {

	@EventHandler
	public void eat(PlayerItemConsumeEvent e) {
		if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.EAT))
			e.setCancelled(true);
	}
}
