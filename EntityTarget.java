package ga.ishadey.plugin.ultravanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class EntityTarget implements Listener {

	@EventHandler
	public void foodChange(EntityTargetLivingEntityEvent e) {
		if (e.getEntity() instanceof Player && VanishManager.getVanishManager().isVanished((Player) e.getEntity()))
			e.setCancelled(true);
	}
	
	@EventHandler
	public void vehicleCrash(VehicleEntityCollisionEvent e) {
		if (e.getEntity() instanceof Player && VanishManager.getVanishManager().isVanished((Player) e.getEntity()))
			e.setCancelled(true);
	}
}
