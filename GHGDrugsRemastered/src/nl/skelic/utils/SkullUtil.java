package nl.skelic.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import nl.skelic.drugs.Main;

@SuppressWarnings("unused")
public class SkullUtil {
	
	private Main plugin;
	
	public SkullUtil(Main pluginInstance) {
		plugin = pluginInstance;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getPSkull(String playerName, String displayName, String lore) {
		ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1,(short) SkullType.PLAYER.ordinal());
		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		skullMeta.setOwner(playerName);
		skullMeta.setDisplayName("§6§l" + displayName);
		ArrayList<String> skullLore = new ArrayList<String>();
		skullLore.add(lore);
		skullMeta.setLore(skullLore);
		skull.setItemMeta(skullMeta);
		return skull;
	}
}
