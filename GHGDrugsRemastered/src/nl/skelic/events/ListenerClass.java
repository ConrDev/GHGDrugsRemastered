package nl.skelic.events;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.potion.PotionEffect;
//import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.Plugin;

import net.milkbowl.vault.economy.Economy;
import nl.skelic.drugs.Drugs;
import nl.skelic.drugs.Main;
import nl.skelic.menus.Menus;

public class ListenerClass implements Listener {
	
	private Plugin plugin = Main.getInstance();
	
	@SuppressWarnings("unused")
	private Drugs drugs = Drugs.getDrugs();
	
	@SuppressWarnings("unused")
	private Economy econ;
	
	public ListenerClass() {
		econ = Main.getEconomy();
	}
	
	@EventHandler
	public void invDragEvent(InventoryDragEvent e) {
		Inventory inv = e.getInventory();
		String name = inv.getName();
		if (name.equals(ChatColor.BOLD + "Drugs Shop")) {
			e.setCancelled(true);
			return;
		}
		if (name.equals(ChatColor.BOLD + "Drugs Shop | §a§lSoftdrugs")) {
			e.setCancelled(true);
			return;
		}
		if (name.equals(ChatColor.BOLD + "Drugs Shop | §c§lSoftdrugs")) {
			e.setCancelled(true);
			return;
		}
	}
	
	@EventHandler
	public void invClickEvent(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		String name = inv.getName();
		
		if (name.equals(ChatColor.BOLD + "Drugs Shop")) {
			e.setCancelled(true);
			int slot = e.getSlot();
			if (slot < 0) {
				return;
			}
			if (slot == 10) {
				Menus.softDrugs(player);
				//if (econ.has(player, 5000)) {
					//econ.withdrawPlayer(player, 5000);
					//drugs.Coke(player);
					//return;
				//}
				//else {
					//player.sendMessage("§cJe hebt niet genoeg geld!");
				//}
			}
			if (slot == 11) {
				Menus.hardDrugs(player);
				//if (econ.has(player, 100)) {
					//econ.withdrawPlayer(player, 100);
					//drugs.Weed(player);
				//}
				//else {
					//player.sendMessage("§cJe hebt niet genoeg geld!");
				//}
			}
			if (slot == 22) {
				player.closeInventory();
			}
		}
		
		if (name.equals(ChatColor.BOLD + "Drugs Shop | §a§lSoftdrugs")) {
			e.setCancelled(true);
			int slot = e.getSlot();
			if (slot < 0) {
				return;
			}
			if (slot == 31) {
				Menus.drugsShop(player);
			}
			
		}
		
		if (name.equals(ChatColor.BOLD + "Drugs Shop | §c§lHarddrugs")) {
			e.setCancelled(true);
			int slot = e.getSlot();
			if (slot < 0) {
				return;
			}
			if (slot == 31) {
				Menus.drugsShop(player);
			}
			
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			ItemStack item = e.getItem();
			
			ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
			ItemMeta cokeMeta = cokeIcon.getItemMeta();
			cokeMeta.setDisplayName("§l§oCocaïne");
			ArrayList<String> cokeLore = new ArrayList<String>();
			cokeLore.add("§c§lLet op!");
			cokeLore.add("&r&7Je zult gaan trippen.");
			cokeMeta.setLore(cokeLore);
			cokeIcon.setItemMeta(cokeMeta);
			
			ItemStack weedIcon = new ItemStack(Material.LONG_GRASS, 1,(byte) 2);
	    	ItemMeta weedMeta = weedIcon.getItemMeta();
	    	weedMeta.setDisplayName("§a§l§oWeed");
	    	ArrayList<String> weedLore = new ArrayList<String>();
	    	weedLore.add("§c§lLet op!");
	    	weedLore.add("&r&7Het effect zal 24 uur duren.");
			weedMeta.setLore(weedLore);
			weedIcon.setItemMeta(weedMeta);
			
			if (item.getType().equals(Material.SUGAR) && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName() == ("§l§oCocaïne")) {
					Player player = e.getPlayer();
					plugin.getConfig().set("Verslaafde." + player.getUniqueId() + ".Aan", "Cocaïne");
					player.performCommand("effect " + player.getName() + " minecraft:slowness 1 255 true");
					player.performCommand("effect " + player.getName() + " minecraft:nausea 1 4 true");
					//player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 2, true));
					//player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1, 4, true));
					player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 2);
					player.performCommand("effect " + player.getName() + " minecraft:speed 30 4 true");
					//player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, 4, true));
					//player.getInventory().removeItem(cokeIcon);
					//player.updateInventory();
				}
			}
			
			if (item.getType().equals(Material.LONG_GRASS) && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName() == ("§a§l§oWeed")) {
					Player player = e.getPlayer();
					player.performCommand("effect " + player.getName() + " minecraft:slowness 1 255 true");
					player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 2);
					//player.performCommand("effect " + player.getName() + " minecraft:nausea 1638 0 true");
					player.performCommand("effect " + player.getName() + " minecraft:slowness 1638 2 true");
					//player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1638, 2, true));
					//player.performCommand("effect " + player.getName() + " minecraft:resistance 1638 4 true");
					//player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1638, 4, true));
					//player.getInventory().removeItem(weedIcon);
					//player.updateInventory();
				}
			}
		}
	}
}
