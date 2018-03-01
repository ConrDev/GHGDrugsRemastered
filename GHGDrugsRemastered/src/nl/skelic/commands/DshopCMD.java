package nl.skelic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.drugs.Main;
import nl.skelic.drugs.Menus;

public class DshopCMD implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
    	if (command.getName().equalsIgnoreCase("dshop")) {
    		Menus.drugsShop(player);
    	} 
    return true;
    } 
	
}
