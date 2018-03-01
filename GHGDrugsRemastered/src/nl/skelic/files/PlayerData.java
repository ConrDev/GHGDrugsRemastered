package nl.skelic.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.drugs.Main;
import nl.skelic.drugs.Util;
//import nl.skelic.drugs.Util;

public class PlayerData implements Listener {
	
	private Main plugin;
	private Util util;
	public FileConfiguration playerDataConfig;
	public File playerDataFile;
	
	public PlayerData(Main pluginInstance) {
		plugin = pluginInstance;
		util = plugin.getUtil();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		playerDataFile = new File(plugin.getDataFolder() + File.separator + "PlayerData" + File.separator, player.getUniqueId().toString() + ".yml");
		if (!playerDataFile.exists()) {
			try {
				playerDataFile.createNewFile();
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Creating PlayerData for " + player.getUniqueId());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Loading PlayerData for " + player.getUniqueId());
		if (!playerDataConfig.contains("addicted")) {
			playerDataConfig.set("addicted", false);
			Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Adding addicted variable for " + player.getUniqueId());
		}
		if (!playerDataConfig.contains("which_life")) {
			playerDataConfig.set("which_life", 1);
			Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Adding which_life variable for " + player.getUniqueId());
		}
		util.saveFile(playerDataConfig, playerDataFile);
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Saving PlayerData for " + player.getUniqueId());
	}
}
