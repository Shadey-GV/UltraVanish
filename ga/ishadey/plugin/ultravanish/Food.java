package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Food implements Listener {

	@EventHandler
	public void FoodChange(FoodLevelChangeEvent e) {
		if (e.getEntity() instanceof Player)
			if (VanishManager.getVanishManager().isVanished((Player) e.getEntity()) && ConfigManager.getOption(Options.HUNGER_LOSS))
				e.setCancelled(true);
	}
}
