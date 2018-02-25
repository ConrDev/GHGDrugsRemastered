package nl.skelic.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Menus {
	
	@SuppressWarnings("deprecation")
	public static void openDshop(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BOLD + "Drugs Shop");
		
		ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
		ItemMeta cokeMeta = cokeIcon.getItemMeta();
		cokeMeta.setDisplayName("§l§oCocaïne §r§2§l€5.000§l§7/100g");
		cokeIcon.setItemMeta(cokeMeta);
		
		ItemStack weedIcon = new ItemStack(Material.LONG_GRASS);
	    MaterialData md = weedIcon.getData();
	    md.setData((byte)2);
	    weedIcon.setData(md);
		ItemMeta weedMeta = weedIcon.getItemMeta();
		weedMeta.setDisplayName("§a§l§oWeed §r§2§l€100§l§7/100g");
		weedIcon.setItemMeta(weedMeta);
		
		inv.setItem(0, cokeIcon);
		inv.setItem(1, weedIcon);
		
		player.openInventory(inv);
	}
}
