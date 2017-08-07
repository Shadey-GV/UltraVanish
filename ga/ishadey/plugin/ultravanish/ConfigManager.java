package ga.ishadey.plugin.ultravanish;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

	private static FileConfiguration config = Main.config();

	public static boolean getOption(Options option) {
		runChecks(option);
		return config.getBoolean("options." + option.section);
	}

	public static String getMessage(Messages message) {
		runChecks(message);
		return ChatColor.translateAlternateColorCodes('&', config.getString("messages." + message.section));
	}

	public static void setOption(Options option, boolean value) {
		config.set("options." + option.section, value);
		Bukkit.getPluginManager().getPlugin("UltraVanish").saveConfig();
		try {
			Main.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setMessage(Messages message, String value) {
		config.set("messages." + message.section, value);
		try {
			Main.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void runChecks(Options arg0) {
		if (!config.isSet("options." + arg0.section)) {
			config.set("options." + arg0.section, arg0.defaultSetting);
			try {
				Main.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void runChecks(Messages arg0) {
		if (!config.isSet("messages." + arg0.section)) {
			config.set("messages." + arg0.section, arg0.defaultSetting);
			try {
				Main.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public enum Options {
		ALWAYS_FLY("alwaysFly", false), NIGHT_VISION("applyNightVision", false), BLOCK_DAMAGE("blockAllDamage",
				true), BED_USE("blockBedUse", true), BLOCK_PLACE("blockBlockPlace",
						true), BLOCK_BREAK("blockBlockBreak", true), EAT("blockEat", true), FISH("blockFishing",
								true), HUNGER_LOSS("blockHungerLoss", true), PVP("blockPVP",
										true), INTERACT("blockInteraction", true), DROP_ITEM("blockItemDrop",
												true), PICKUP_ITEM("blockItemPickup", true), BLOCK_VANISH_GLITCH(
														"blockVanishGlitch", true);
		String section;
		boolean defaultSetting;

		private Options(String arg0, boolean arg1) {
			this.section = arg0;
			this.defaultSetting = arg1;
		}
	}

	public enum Messages {
		VANISH("vanish", "&aVanish enabled! You are hidden from normal players."), UNVANISH("unvanish",
				"&cVanish disabled."), NOPERMISSION("noPermission", "&cInsufficient permission."), NOT_FOUND("notFound",
						"&cPlayer not found."), MULTIPLE_PLAYERS("multiplePlayersFound",
								"&aPlease be more specific, &e$n&a players matched your text: &e($p)"), VANISH_OTHER(
										"toggleVanishOther",
										"&aSet vanish for $p to: $v"), HIDDEN("playerHiddenFromCommand",
												"&cError: &4Player not found."), CHEST("containerOpen",
														"&aOpening container silently. Editing disabled.");
		String section, defaultSetting;

		private Messages(String arg0, String arg1) {
			this.section = arg0;
			this.defaultSetting = arg1;
		}
	}

}
