package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class BlockBreak implements Listener {

	@EventHandler
	public void blockBreak(BlockBreakEvent e) {
		if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.BLOCK_BREAK))
			e.setCancelled(true);
	}
}
