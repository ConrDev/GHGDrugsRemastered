package nl.skelic.drugs;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class ConfigManager {
	
	private Main plugin = Main.getPlugin(Main.class);
	
	// Files & File Config
	public FileConfiguration playerscfg;
	public File playersfile;
	
	public void setup() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		playersfile = new File(plugin.getDataFolder(), "players.yml");
		
		/*if (playersfile.exists()) {
			return;
		}*/
		
		if (!playersfile.exists()) {
			try {
				playersfile.createNewFile();
			} catch (IOException e) {
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.RED + "Could not create the players.yml file!");
			} 
		}
		
		playerscfg = YamlConfiguration.loadConfiguration(playersfile);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GREEN + "The players.yml file has been created!");
	}
	
	public FileConfiguration getPlayers() {
		return playerscfg;
	}
	
	public void savePlayers() {
		try {
			playerscfg.save(playersfile);
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GREEN + "The players.yml file has been saved!");
			
		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.RED + "Could not save the players.yml file!");
		}
	}
	
	public void reloadPlayers() {
		playerscfg = YamlConfiguration.loadConfiguration(playersfile);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "The players.yml file has been reloaded!");
	}
	    
	/*@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		playersfile = new File(plugin.getDataFolder(), "players.yml");
		playerscfg = YamlConfiguration.loadConfiguration(playersfile);
		if(!event.getPlayer().hasPlayedBefore()) {
			playerscfg.set(player.getUniqueId() + ".verslaafd", false);
			playerscfg.set(player.getUniqueId() + ".verslaafd_aan", "");
			playerscfg.set(player.getUniqueId() + ".welk_leven", 1);
		} else {
			playerscfg.getString(player.getUniqueId() + ".verslaafd");
			playerscfg.getString(player.getUniqueId() + ".verslaafd_aan");
			playerscfg.getString(player.getUniqueId() + ".welk_leven");
		}
	}*/
	
}
