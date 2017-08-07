package ga.ishadey.plugin.ultravanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.block.Furnace;
import org.bukkit.block.Hopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import ga.ishadey.plugin.ultravanish.ConfigManager.Messages;
import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class Interact implements Listener {

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (VanishManager.getVanishManager().isVanished(player) && ConfigManager.getOption(Options.INTERACT)) {
			e.setCancelled(true);
			boolean b = false;
			Inventory inv = null;
			if (e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) {
				inv = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.RED + "Viewing container...");
				inv.setContents(e.getPlayer().getEnderChest().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().name().contains("CHEST")) {
				Chest chest = (Chest) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, chest.getInventory().getSize(), ChatColor.RED + "Viewing container...");
				inv.setContents(chest.getInventory().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().equals(Material.HOPPER)) {
				Hopper hopper = (Hopper) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.RED + "Viewing container...");
				inv.setContents(hopper.getInventory().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().equals(Material.DROPPER)) {
				Dropper dropper = (Dropper) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, InventoryType.DISPENSER, ChatColor.RED + "Viewing container...");
				inv.setContents(dropper.getInventory().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().equals(Material.DISPENSER)) {
				Dispenser dispenser = (Dispenser) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, InventoryType.DISPENSER, ChatColor.RED + "Viewing container...");
				inv.setContents(dispenser.getInventory().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().equals(Material.FURNACE)) {
				Furnace dispenser = (Furnace) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, InventoryType.FURNACE, ChatColor.RED + "Viewing container...");
				inv.setContents(dispenser.getInventory().getContents());
				b = true;
			} else if (e.getClickedBlock().getType().equals(Material.BREWING_STAND)) {
				BrewingStand dispenser = (BrewingStand) e.getClickedBlock().getState();
				inv = Bukkit.createInventory(null, InventoryType.BREWING, ChatColor.RED + "Viewing container...");
				inv.setContents(dispenser.getInventory().getContents());
				b = true;
			}
			if (b && inv != null) {
				e.getPlayer().openInventory(inv);
				e.getPlayer().sendMessage(ConfigManager.getMessage(Messages.CHEST));
			}
		}
	}
}
