package ga.ishadey.plugin.ultravanish;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
		
	private static File configf;
	private static FileConfiguration config;
	
	public static VanishManager vm;
	
	@Override
	public void onEnable() {
		vm = new VanishManager();
		getLogger().info("+--------------+");
		getLogger().info("UltraVanish");
		getLogger().info("by iShadey (TrollStar12345)");
		getLogger().info("plugin " + ChatColor.GREEN + "ENABLED");
		getLogger().info("+--------------+");
		getCommand("vanish").setExecutor(new Cmd());
		AlwaysFly.a();
		Bukkit.getPluginManager().registerEvents(new VanishGlitchFixer(), this);
		Bukkit.getPluginManager().registerEvents(new FakeChest(), this);
		Bukkit.getPluginManager().registerEvents(new AlwaysFly(), this);
		Bukkit.getPluginManager().registerEvents(new PickupItem(), this);
		Bukkit.getPluginManager().registerEvents(new PvP(), this);
		Bukkit.getPluginManager().registerEvents(new Food(), this);
		Bukkit.getPluginManager().registerEvents(new Eat(), this);
		Bukkit.getPluginManager().registerEvents(new DropItem(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
		Bukkit.getPluginManager().registerEvents(new Interact(), this);
		Bukkit.getPluginManager().registerEvents(new InteractEntity(), this);
		Bukkit.getPluginManager().registerEvents(new EntityTarget(), this);
		Bukkit.getPluginManager().registerEvents(new BedEnter(), this);
		Bukkit.getPluginManager().registerEvents(new Fish(), this);
		configf = new File(getDataFolder(), "config.yml");
		config = new YamlConfiguration();
		if (!configf.exists()) {
			configf.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}
		try {
			config.load(configf);
		} catch (Exception e) {
			getLogger().log(Level.WARNING, "[UltraVanish] Could not load config.yml, exception: " + e.getClass().getName());
			getLogger().log(Level.WARNING, "[UltraVanish] Report this to iShadey:");
			e.printStackTrace();
		}
	}
	
	public static void save() throws IOException {
		config.save(configf);
	}
	
	public static FileConfiguration config() {
		return config;
	}
	
	public static File file() {
		return configf;
	}
	
	@Override
	public void onDisable() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (VanishManager.getVanishManager().isVanished(p))
				VanishManager.getVanishManager().unVanish(p);
		}
		getLogger().info("+--------------+");
		getLogger().info("UltraVanish");
		getLogger().info("by iShadey (TrollStar12345)");
		getLogger().info("plugin " + ChatColor.RED + "DISABLED");
		getLogger().info("+--------------+");
	}
}