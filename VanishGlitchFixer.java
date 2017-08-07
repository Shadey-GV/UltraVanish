package ga.ishadey.plugin.ultravanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class VanishGlitchFixer implements Listener {

	@EventHandler
	public void move(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		if (!ConfigManager.getOption(Options.BLOCK_VANISH_GLITCH))
			return;
		if (VanishManager.getVanishManager().isVanished(player)) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.hasPermission("vanish.seehidden")) {
					p.showPlayer(player);
				} else {
					p.hidePlayer(player);
				}
			}
		}
	}
}
