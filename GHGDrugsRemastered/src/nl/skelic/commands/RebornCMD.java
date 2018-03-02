package nl.skelic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.skelic.menus.RebornMenu;
import nl.skelic.utils.MsgUtil;

public class RebornCMD implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(MsgUtil.NOTPLR.getMessage());
			return false;
		}
		Player player = (Player) sender;
		if (!player.hasPermission("ghgdrugs.reborn")) {
			sender.sendMessage(MsgUtil.NOPERM.getMessage());
			return true;
		}
    	if (command.getName().equalsIgnoreCase("reborn")) {
    		RebornMenu.Open(player);
    		return true;
    	} else {
    		sender.sendMessage(MsgUtil.CMDNF.getMessage());
    	}
    	return true;
    } 
}
