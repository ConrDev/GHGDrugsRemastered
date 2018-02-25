package nl.skelic.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventClass implements Listener {
	
	private ConfigManager cfgm;
	
	public String prefix = (ChatColor.AQUA + "[GHG] ");
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(!event.getPlayer().hasPlayedBefore()) {
				Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "Creating player info for " + player.getUniqueId());
				cfgm.playerscfg.set("players." + player.getUniqueId() + ".verslaafd", false);
				cfgm.playerscfg.set(player.getUniqueId() + ".verslaafd_aan", "");
				cfgm.playerscfg.set(player.getUniqueId() + ".welk_leven", 1);
				cfgm.savePlayers();
		} else {
			Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "Gathering player info for " + player.getUniqueId());
			cfgm.playerscfg.getString("players." + player.getUniqueId() + ".verslaafd");
			cfgm.playerscfg.getString("players." + player.getUniqueId() + ".verslaafd_aan");
			cfgm.playerscfg.getString("players." + player.getUniqueId() + ".welk_leven");
		}
	}
}
