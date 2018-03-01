package nl.skelic.utils;

import net.md_5.bungee.api.ChatColor;
import nl.skelic.drugs.Main;

public enum MsgUtil {
	
	NOPERM(Main.prefix + ChatColor.RED + "Sorry you don't have permissions to preform that command!"),
	NOTPLR(Main.prefix + ChatColor.RED + "This command can't be used in the console!"),
	CMDNF(Main.prefix + ChatColor.RED + "Command not found!");
	
	private String message;
	
	MsgUtil(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
