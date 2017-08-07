package ga.ishadey.plugin.ultravanish;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ga.ishadey.plugin.ultravanish.ConfigManager.Messages;

public class Cmd implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				try {
					Main.config().load(Main.file());
					player.sendMessage(ChatColor.GREEN + "Config successfully reloaded!");
				} catch (Exception e) {
					player.sendMessage(ChatColor.RED
							+ "An error occured. Check your config file for errors! Check console for full detail, and error location.");
				}
				return true;
			}
			if (player.hasPermission("vanish.other")) {
				List<Player> players = new ArrayList<Player>();
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (p.getName().toLowerCase().contains(args[0].toLowerCase()))
						players.add(p);
				}
				if (players.get(0) == null || players.size() == 0) {
					player.sendMessage(ConfigManager.getMessage(Messages.NOT_FOUND));
					return true;
				}
				Player pla = null;
				for (Player p : players) {
					if (p.getName().equalsIgnoreCase(args[0])) {
						pla = p;
						break;
					}
				}
				if (players.size() > 1 && pla == null) {
					StringBuilder sb = new StringBuilder();

					for (int i = 0; i < players.size(); i++) {
						sb.append(players.get(i).getName());
						sb.append(" ");
					}
					sb.setLength(sb.length() - 1);

					player.sendMessage(ConfigManager.getMessage(Messages.MULTIPLE_PLAYERS)
							.replace("$n", String.valueOf(players.size())).replace("$p", sb.toString()));
					return true;
				}
				try {
					Player p = pla == null ? players.get(0) : pla;
					VanishManager.getVanishManager().toggleVanish(p);
					player.sendMessage(ConfigManager.getMessage(Messages.VANISH).replace("$p", p.getName())
							.replace("$v", String.valueOf(VanishManager.getVanishManager().isVanished(p))
									.replace("true", "enabled").replace("false", "disabled")));
				} catch (Exception e1) {
					player.sendMessage(ChatColor.RED + "An internal error occured. Contact iShadey on SpigotMC.");
					e1.printStackTrace();
				}
			} else {
				if (player.hasPermission("vanish.use")) {
					VanishManager.getVanishManager().toggleVanish(player);
					return true;
				} else {
					player.sendMessage(ConfigManager.getMessage(ConfigManager.Messages.NOPERMISSION));
				}
			}
			return true;
		}
		if (player.hasPermission("vanish.use")) {
			VanishManager.getVanishManager().toggleVanish(player);
			return true;
		} else
			player.sendMessage(ConfigManager.getMessage(ConfigManager.Messages.NOPERMISSION));
		return true;
	}
}
