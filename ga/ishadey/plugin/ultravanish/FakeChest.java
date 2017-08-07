package ga.ishadey.plugin.ultravanish;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class FakeChest implements Listener {

	@EventHandler
	public void click(InventoryClickEvent e) {
		if (e.getClickedInventory() != null
				&& e.getClickedInventory().getTitle().equals(ChatColor.RED + "Viewing container..."))
			e.setCancelled(true);
		if (e.getWhoClicked().getOpenInventory() != null
				&& e.getWhoClicked().getOpenInventory().getTopInventory() != null && e.getWhoClicked()
						.getOpenInventory().getTopInventory().getTitle().equals(ChatColor.RED + "Viewing container..."))
			e.setCancelled(true);
	}

}
