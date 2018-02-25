package nl.skelic.drugs;

import java.util.ArrayList;

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
		cokeMeta.setDisplayName("§l§oCocaïne §r§l§71g");
		cokeIcon.setItemMeta(cokeMeta);
		ArrayList<String> cokeLore = new ArrayList<String>();
		cokeLore.add("§c§lLet op!");
		cokeLore.add("Je zult gaan trippen.");
		cokeMeta.setLore(cokeLore);
		
		ItemStack weedIcon = new ItemStack(Material.LONG_GRASS);
	    MaterialData md = weedIcon.getData();
	    md.setData((byte)2);
	    weedIcon.setData(md);
		ItemMeta weedMeta = weedIcon.getItemMeta();
		weedMeta.setDisplayName("§a§l§oWeed §r§l§71g");
		weedIcon.setItemMeta(weedMeta);
		ArrayList<String> weedLore = new ArrayList<String>();
		weedLore.add("§c§lLet op!");
		weedLore.add("Het effect zal 24 uur duren.");
		weedMeta.setLore(weedLore);
		
		inv.setItem(0, cokeIcon);
		inv.setItem(1, weedIcon);
		
		player.openInventory(inv);
	}
}
