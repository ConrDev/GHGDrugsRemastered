package nl.skelic.files;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.drugs.Main;
import nl.skelic.utils.Util;

public class PlayerData implements Listener {
	
	private Main plugin;
	private Util util;
	public FileConfiguration playerDataConfig;
	public YamlConfiguration playerConfig;
	public File playerDataFile;
	
	public PlayerData(Main pluginInstance) {
		plugin = pluginInstance;
		util = plugin.getUtil();
	}
	
	public boolean load(UUID playerUUID) {
		playerDataFile = new File(plugin.getDataFolder() + File.separator + "PlayerData" + File.separator, playerUUID + ".yml");
		try {
			if (!playerDataFile.exists()) {
			
				playerDataFile.createNewFile();
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Creating PlayerData for " + playerUUID);
				
			}
			try {
				playerConfig.load(playerDataFile);
			} catch (InvalidConfigurationException e) {
				e.printStackTrace();
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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
		if (!playerDataConfig.contains("addicted_to")) {
			playerDataConfig.set("addicted_to", "");
			Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Adding addicted_to variable for " + player.getUniqueId());
		}
		if (!playerDataConfig.contains("life")) {
			playerDataConfig.set("life", 1);
			Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Adding which_life variable for " + player.getUniqueId());
		}
		util.saveFile(playerDataConfig, playerDataFile);
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "Saving PlayerData for " + player.getUniqueId());
	}
}
