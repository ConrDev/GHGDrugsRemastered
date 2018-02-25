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

public class Main extends JavaPlugin implements Listener {
	
	private static Economy econ = null;
	
	@Override
	public void onEnable() {
		if(!setupEconomy()) {
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
		loadConfiguration();
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new ListenerClass(), this);
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "--------{De GHGDrugs Plugin}-------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|       Created by: SkelicStylz   |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|           Version: v1.0         |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|      Plugin Status:  Enabled    |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-----------------------------------");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-------{De GHGDrugs Plugin}--------");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|       Created by: SkelicStylz   |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|           Version: v1.0         |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|      Plugin Status: Disabled    |");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-----------------------------------");
	}

    public void loadConfiguration() {
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("cocaïne.verslaafd", "true");
        getConfig().addDefault("cocaïne.gebruik", "1");
        getConfig().addDefault("weed.verslaafd", "true");
        getConfig().addDefault("weed.gebruik", "5");
        saveConfig();
        getLogger().info(ChatColor.GOLD + "Configuratie Herladen");
        Bukkit.broadcastMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "De GHGDrugs Remastered Plugin is geladen");
    }
    
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	   Player player = (Player) sender;
    	   if (command.getName().equalsIgnoreCase("dshop")) {
    		   if (econ.bankBalance("DrugsShop") == null) {
    			   player.sendMessage("§cEr bestaat nog geen DrugsShop! Misschien moet u er één beginnen ;)");
    		   }
			   Menus.openDshop(player);
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