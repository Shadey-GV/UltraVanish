package ga.ishadey.plugin.ultravanish;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class VanishManager {

	private List<UUID> vanished = new ArrayList<>();

	public static VanishManager getVanishManager() {
		return Main.vm;
	}

	public boolean isVanished(Player player) {
		return vanished.contains(player.getUniqueId());
	}

	public void setVanished(Player player, boolean vanish) {
		if (vanish) {
			vanish(player);
			return;
		}
		unVanish(player);
	}

	public void toggleVanish(Player player) {
		if (isVanished(player)) {
			unVanish(player);
			return;
		}
		vanish(player);
	}

	public void unVanish(Player player) {
		if (ConfigManager.getOption(ConfigManager.Options.NIGHT_VISION)) {
			if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION))
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		player.sendMessage(ConfigManager.getMessage(ConfigManager.Messages.UNVANISH));
		if (vanished.contains(player.getUniqueId()))
			vanished.remove(player.getUniqueId());
		for (Player p : Bukkit.getOnlinePlayers())
			p.showPlayer(player);
		if (!player.getGameMode().name().equals("CREATIVE") && !player.getGameMode().name().equals("SPECTATOR")) {
			player.setAllowFlight(false);
			player.setFlying(false);
		}
	}

	public void vanish(Player player) {
		if (!vanished.contains(player.getUniqueId()))
			vanished.add(player.getUniqueId());
		player.sendMessage(ConfigManager.getMessage(ConfigManager.Messages.VANISH));
		if (ConfigManager.getOption(ConfigManager.Options.NIGHT_VISION)) {
			if (!player.hasPotionEffect(PotionEffectType.NIGHT_VISION))
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0, true));
		}
		player.setAllowFlight(true);
		if (ConfigManager.getOption(Options.ALWAYS_FLY)) {
			player.setVelocity(player.getVelocity().setX(0.0).setY(0.1).setZ(0.0));
			player.setFlying(true);
		}
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (!p.hasPermission("vanish.seehidden"))
				p.hidePlayer(player);
		}
	}

}
