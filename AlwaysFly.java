package ga.ishadey.plugin.ultravanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.scheduler.BukkitRunnable;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class AlwaysFly implements Listener {

	@EventHandler
	public void flyChange(PlayerToggleFlightEvent e) {
		Player player = e.getPlayer();
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.ALWAYS_FLY)) {
			e.setCancelled(true);
			player.setVelocity(player.getVelocity().setX(0.0).setY(0.1).setZ(0.0));
			player.setAllowFlight(true);
			player.setFlying(true);
		}
	}

	public static void a() {
		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (VanishManager.getVanishManager().isVanished(player)
							&& ConfigManager.getOption(Options.ALWAYS_FLY)) {
						player.setAllowFlight(true);
						player.setFlying(true);
					}
				}
			}
		}.runTaskTimer(Bukkit.getPluginManager().getPlugin("UltraVanish"), 0L, 1L);
	}
}
