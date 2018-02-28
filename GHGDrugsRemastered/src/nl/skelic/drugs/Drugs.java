package nl.skelic.drugs;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Drugs {
	
	private static Drugs drugs = new Drugs();
	
	private Drugs() { }
	
	public static Drugs getDrugs() {
		return drugs;
	}
	
	public void Coke(Player player) {
		ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
		ItemMeta cokeMeta = cokeIcon.getItemMeta();
		cokeMeta.setDisplayName("§l§oCocaïne");
		ArrayList<String> cokeLore = new ArrayList<String>();
		cokeLore.add("§c§lLet op!");
		cokeLore.add("&r&7Je zult gaan trippen.");
		cokeMeta.setLore(cokeLore);
		cokeIcon.setItemMeta(cokeMeta);
		
		player.getInventory().addItem(cokeIcon);
	}
	
	public void Weed(Player player) {
		ItemStack weedIcon = new ItemStack(Material.LONG_GRASS, 1,(byte) 2);
    	ItemMeta weedMeta = weedIcon.getItemMeta();
    	weedMeta.setDisplayName("§a§l§oWeed");
    	ArrayList<String> weedLore = new ArrayList<String>();
    	weedLore.add("§c§lLet op!");
    	weedLore.add("&r&7Het effect zal 24 uur duren.");
		weedMeta.setLore(weedLore);
		weedIcon.setItemMeta(weedMeta);
		
		player.getInventory().addItem(weedIcon);
	}
}
