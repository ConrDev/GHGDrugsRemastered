package nl.skelic.menus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menus {
	
	public static void drugsShop(Player player) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BOLD + "Drugs Shop");
		
		ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
		ItemMeta cokeMeta = cokeIcon.getItemMeta();
		cokeMeta.setDisplayName("§c§lHarddrugs");
		//ArrayList<String> cokeLore = new ArrayList<String>();
		//cokeLore.add("§2€5.000§l§7/100g");
		//cokeMeta.setLore(cokeLore);
		cokeIcon.setItemMeta(cokeMeta);
		
		ItemStack weedIcon = new ItemStack(Material.LONG_GRASS, 1,(byte) 2);
		ItemMeta weedMeta = weedIcon.getItemMeta();
		weedMeta.setDisplayName("§a§lSoftdrugs");
		//ArrayList<String> weedLore = new ArrayList<String>();
		//weedLore.add("§2€100§l§7/100g");
		//weedMeta.setLore(weedLore);
		weedIcon.setItemMeta(weedMeta);
		
		ItemStack closeIcon = new ItemStack(Material.BARRIER, 1);
		ItemMeta closeMeta = closeIcon.getItemMeta();
		closeMeta.setDisplayName("§c§lCLOSE");
		closeIcon.setItemMeta(closeMeta);
		
		ItemStack borderIcon = new ItemStack(Material.STAINED_GLASS_PANE, 1,(byte) 15);
		ItemMeta borderMeta = borderIcon.getItemMeta();
		borderMeta.setDisplayName(" ");
		borderIcon.setItemMeta(borderMeta);
		
		inv.setItem(11, cokeIcon);
		inv.setItem(10, weedIcon);
		inv.setItem(22, closeIcon);
		inv.setItem(0, borderIcon);
		inv.setItem(1, borderIcon);
		inv.setItem(2, borderIcon);
		inv.setItem(3, borderIcon);
		inv.setItem(4, borderIcon);
		inv.setItem(5, borderIcon);
		inv.setItem(6, borderIcon);
		inv.setItem(7, borderIcon);
		inv.setItem(8, borderIcon);
		inv.setItem(9, borderIcon);
		inv.setItem(17, borderIcon);
		inv.setItem(18, borderIcon);
		inv.setItem(19, borderIcon);
		inv.setItem(20, borderIcon);
		inv.setItem(21, borderIcon);
		inv.setItem(23, borderIcon);
		inv.setItem(24, borderIcon);
		inv.setItem(25, borderIcon);
		inv.setItem(26, borderIcon);
		
		
		player.openInventory(inv);
	}
	
	public static void softDrugs(Player player) {
		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BOLD + "Drugs Shop | §a§lSoftdrugs");
		
		ItemStack backIcon = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = backIcon.getItemMeta();
		backMeta.setDisplayName("§c§lBACK");
		backIcon.setItemMeta(backMeta);
		
		ItemStack borderIcon = new ItemStack(Material.STAINED_GLASS_PANE, 1,(byte) 13);
		ItemMeta borderMeta = borderIcon.getItemMeta();
		borderMeta.setDisplayName(" ");
		borderIcon.setItemMeta(borderMeta);
		
		//inv.setItem(10, cokeIcon);
		//inv.setItem(19, weedIcon);
		inv.setItem(31, backIcon);
		inv.setItem(0, borderIcon);
		inv.setItem(1, borderIcon);
		inv.setItem(2, borderIcon);
		inv.setItem(3, borderIcon);
		inv.setItem(4, borderIcon);
		inv.setItem(5, borderIcon);
		inv.setItem(6, borderIcon);
		inv.setItem(7, borderIcon);
		inv.setItem(8, borderIcon);
		inv.setItem(9, borderIcon);
		inv.setItem(18, borderIcon);
		inv.setItem(27, borderIcon);
		inv.setItem(28, borderIcon);
		inv.setItem(29, borderIcon);
		inv.setItem(30, borderIcon);
		inv.setItem(32, borderIcon);
		inv.setItem(33, borderIcon);
		inv.setItem(34, borderIcon);
		inv.setItem(35, borderIcon);
		inv.setItem(26, borderIcon);
		inv.setItem(17, borderIcon);
		
		
		player.openInventory(inv);
	}
	
	public static void hardDrugs(Player player) {
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.BOLD + "Drugs Shop | §c§lHarddrugs");
		
		ItemStack backIcon = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = backIcon.getItemMeta();
		backMeta.setDisplayName("§c§lBACK");
		backIcon.setItemMeta(backMeta);
		
		ItemStack borderIcon = new ItemStack(Material.STAINED_GLASS_PANE, 1,(byte) 14);
		ItemMeta borderMeta = borderIcon.getItemMeta();
		borderMeta.setDisplayName(" ");
		borderIcon.setItemMeta(borderMeta);
		
		//inv.setItem(10, cokeIcon);
		//inv.setItem(19, weedIcon);
		inv.setItem(31, backIcon);
		inv.setItem(0, borderIcon);
		inv.setItem(1, borderIcon);
		inv.setItem(2, borderIcon);
		inv.setItem(3, borderIcon);
		inv.setItem(4, borderIcon);
		inv.setItem(5, borderIcon);
		inv.setItem(6, borderIcon);
		inv.setItem(7, borderIcon);
		inv.setItem(8, borderIcon);
		inv.setItem(9, borderIcon);
		inv.setItem(18, borderIcon);
		inv.setItem(27, borderIcon);
		inv.setItem(28, borderIcon);
		inv.setItem(29, borderIcon);
		inv.setItem(30, borderIcon);
		inv.setItem(32, borderIcon);
		inv.setItem(33, borderIcon);
		inv.setItem(34, borderIcon);
		inv.setItem(35, borderIcon);
		inv.setItem(26, borderIcon);
		inv.setItem(17, borderIcon);
		
		
		player.openInventory(inv);
	}
}
