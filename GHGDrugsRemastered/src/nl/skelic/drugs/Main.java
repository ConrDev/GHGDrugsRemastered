package nl.skelic.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import nl.skelic.events.ListenerClass;
import nl.skelic.managers.ConfigManager;

public class Main extends JavaPlugin implements Listener {
	
	private static Economy econ = null;
	private ConfigManager cfgm;
	private static Main instance;
	
	public static final String PREFIX = ChatColor.AQUA + "[GHG] " + ChatColor.WHITE;
	
	public String prefix = (ChatColor.AQUA + "[GHG] ");
	
	@Override
	public void onEnable() {
		if(!setupEconomy()) {
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
		instance = this;
		cfgm = new ConfigManager();
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new ListenerClass(), this);
		
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "--------{De GHGDrugs Plugin}-------");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "       Created by: SkelicStylz   " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "           Version: v" + getDescription().getVersion() + "         " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "      Plugin Status:  Enabled    " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "-----------------------------------");
		loadConfigManager();
		loadConfiguration();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "--------{De GHGDrugs Plugin}-------");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "       Created by: SkelicStylz   " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "           Version: v" + getDescription().getVersion() + "         " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "|" + ChatColor.YELLOW + "      Plugin Status: Disabled    " + ChatColor.GOLD + "|");
		Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "-----------------------------------");
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	void reload() {
		cfgm.reloadPlayers();
	}
	
	public void loadConfigManager() {
		cfgm.setup();
		cfgm.savePlayers();
		cfgm.reloadPlayers();
	}

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("cocaïne.verslavend", true);
        getConfig().addDefault("cocaïne.gebruik", 1);
        getConfig().addDefault("weed.verslavend", true);
        getConfig().addDefault("weed.gebruik", 5);
        saveConfig();
        getLogger().info(ChatColor.GOLD + "Configuratie Herladen");
        Bukkit.broadcastMessage(Main.PREFIX + ChatColor.GOLD + "De GHGDrugs Remastered Plugin is geladen");
    }
    
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	   Player player = (Player) sender;
    	   if (command.getName().equalsIgnoreCase("dshop")) {
			   Menus.drugsShop(player);
    	   }
        return true;
    }
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public static Economy getEconomy() {
        return econ;
	}
	
}