package nl.skelic.menus;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import nl.skelic.drugs.Main;
import nl.skelic.utils.MsgUtil;
import nl.skelic.utils.SkullUtil;
import nl.skelic.utils.Util;

@SuppressWarnings("unused")
public class RebornMenu implements Listener {
	
	private static Main plugin;
	private static Util util;
	private static SkullUtil skullUtil;
	private static MsgUtil msgUtil;
	private static Map<Player, Inventory> invs = new HashMap<>();
	private static FileConfiguration playerDataConfig;
	private static File playerDataFile;
	
	RebornMenu(Main pluginInstance) {
		plugin = pluginInstance;
		util = plugin.getUtil();
		skullUtil = plugin.getSkullUtil();
	}
	@SuppressWarnings("deprecation")
	public static void Open(Player player) {
		playerDataFile = new File(plugin.getDataFolder() + File.separator + "PlayerData" + File.separator, "bb598933-f545-44cf-a965-c019807dfe2f" /*player.getUniqueId().toString()*/ + ".yml");
		playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
		
		ItemStack skullItem = new ItemStack(Material.SKULL_ITEM, 1,(short) SkullType.PLAYER.ordinal());
		SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
		skullMeta.setOwner(player.getName());
		skullMeta.setDisplayName("§6§l" + player.getName());
		ArrayList<String> skullLore = new ArrayList<String>();
		skullLore.add("Life: " + playerDataConfig.getConfigurationSection("wich_life").getInt("wich_life") /*+ playerDataConfig.get("wich_life")*/);
		if (playerDataConfig.getConfigurationSection("addicted") == playerDataConfig.getConfigurationSection("addicted").getKeys(false)) {
			skullLore.add("Isn't addicted.");
		} else {
			skullLore.add("Is addicted.");
		}
		skullMeta.setLore(skullLore);
		skullItem.setItemMeta(skullMeta);
		
		if (invs.containsKey(player)) {
			invs.get(player).setItem(4, skullItem);
		} else {
			Menu(player);
		}
		player.openInventory(invs.get(player));
	}
	@SuppressWarnings("deprecation")
	public static void Menu(Player player) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BOLD + "Reborn Menu");
		playerDataFile = new File(plugin.getDataFolder() + File.separator + "PlayerData" + File.separator, "bb598933-f545-44cf-a965-c019807dfe2f" /*player.getUniqueId().toString()*/ + ".yml");
		playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
		
		ItemStack newLifeItem = new ItemStack(Material.EMERALD_BLOCK, 1);
		ItemMeta newLifeMeta = newLifeItem.getItemMeta();
		newLifeMeta.setDisplayName("§a§lREBORN");
		newLifeItem.setItemMeta(newLifeMeta);
		
		ItemStack cancelItem = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta cancelMeta = cancelItem.getItemMeta();
		cancelMeta.setDisplayName("§c§lCANCEL");
		cancelItem.setItemMeta(cancelMeta);
		
		ItemStack skullItem = new ItemStack(Material.SKULL_ITEM, 1,(short) SkullType.PLAYER.ordinal());
		SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
		skullMeta.setOwner(player.getName());
		skullMeta.setDisplayName("§6§l" + player.getName());
		ArrayList<String> skullLore = new ArrayList<String>();
		skullLore.add("Life: " + playerDataConfig.getConfigurationSection("wich_life").getInt("wich_life") /*+ playerDataConfig.get("wich_life")*/);
		if (playerDataConfig.getConfigurationSection("addicted") == playerDataConfig.getConfigurationSection("addicted").getKeys(false)) {
			skullLore.add("Isn't addicted.");
		} else {
			skullLore.add("Is addicted.");
		}		skullMeta.setLore(skullLore);
		skullItem.setItemMeta(skullMeta);
		
		
		inv.setItem(4, skullItem);
		if (playerDataConfig.getConfigurationSection("addicted") == playerDataConfig.getConfigurationSection("addicted").getKeys(true)) {
			inv.setItem(24, cancelItem);
		} else if(inv.contains(cancelItem)){
			inv.removeItem(cancelItem);
			inv.setItem(22, cancelItem);
		}
		if (playerDataConfig.getConfigurationSection("addicted") == playerDataConfig.getConfigurationSection("addicted").getKeys(true)) {
			inv.setItem(20, newLifeItem);
		} else if(inv.contains(newLifeItem)){
			inv.removeItem(newLifeItem);
		}
		//player.openInventory(inv);
		invs.put(player, inv);
	}
}
