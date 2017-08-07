package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Damage implements Listener {

	@EventHandler
	public void entityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		Player player = (Player) e.getEntity();
		
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.BLOCK_DAMAGE))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void entityDamage(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		Player player = (Player) e.getEntity();
		
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.BLOCK_DAMAGE))
			e.setCancelled(true);
	}
}
