package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class PvP implements Listener {
	
	  @EventHandler
	  public void entityDamage(EntityDamageByEntityEvent e) {
		  try {
			  if (e.getDamager() instanceof Player && ConfigManager.getOption(Options.PVP) && VanishManager.getVanishManager().isVanished((Player) e.getDamager())) {
				  e.setCancelled(true);  
				  return;
			  }
		  } catch (Exception e1) {}

		  try {
			  if (e.getEntity() instanceof Player && VanishManager.getVanishManager().isVanished((Player) e.getEntity())) {
				  e.setCancelled(true);  
				  return;
			  }
		  } catch (Exception e1) {}
		  return;
	  }
}
