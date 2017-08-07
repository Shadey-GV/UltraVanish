package ga.ishadey.plugin.ultravanish;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import ga.ishadey.plugin.ultravanish.ConfigManager.Options;

public class BlockPlace implements Listener {

	@EventHandler
	public void place(BlockPlaceEvent e) {
		if (VanishManager.getVanishManager().isVanished(e.getPlayer()) && ConfigManager.getOption(Options.BLOCK_PLACE))
			e.setCancelled(true);
	}
}
