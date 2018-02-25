package nl.skelic.drugs;

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
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.milkbowl.vault.economy.Economy;

public class ListenerClass implements Listener {
	
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
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void invClickEvent(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		String name = inv.getName();
		
		ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
		ItemMeta cokeMeta = cokeIcon.getItemMeta();
		cokeMeta.setDisplayName("§l§oCocaïne");
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
		weedMeta.setDisplayName("§a§l§oWeed");
		weedIcon.setItemMeta(weedMeta);
		ArrayList<String> weedLore = new ArrayList<String>();
		weedLore.add("§c§lLet op!");
		weedLore.add("Het effect zal 24 uur duren.");
		weedMeta.setLore(weedLore);
		
		if (name.equals(ChatColor.BOLD + "Drugs Shop")) {
			e.setCancelled(true);
			int slot = e.getSlot();
			if (slot < 0) {
				return;
			}
			if (slot == 0) {
				if (econ.has(player, 5000)) {
					econ.withdrawPlayer(player, 5000);
					player.getInventory().addItem(new ItemStack(cokeIcon));
					return;
				}
				else {
					player.sendMessage("§cJe hebt niet genoeg geld!");
				}
			}
			if (slot == 1) {
				if (econ.has(player, 100)) {
					econ.withdrawPlayer(player, 100);
					player.getInventory().addItem(new ItemStack(weedIcon));
				}
				else {
					player.sendMessage("§cJe hebt niet genoeg geld!");
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			ItemStack item = e.getItem();
			
			ItemStack cokeIcon = new ItemStack(Material.SUGAR, 1);
			ItemMeta cokeMeta = cokeIcon.getItemMeta();
			cokeMeta.setDisplayName("§l§oCocaïne");
			cokeIcon.setItemMeta(cokeMeta);
			
			ItemStack weedIcon = new ItemStack(Material.LONG_GRASS);
		    MaterialData md = weedIcon.getData();
		    md.setData((byte)2);
		    weedIcon.setData(md);
			ItemMeta weedMeta = weedIcon.getItemMeta();
			weedMeta.setDisplayName("§a§l§oWeed");
			weedIcon.setItemMeta(weedMeta);
			
			if (item.getType().equals(Material.SUGAR) && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName() == ("§l§oCocaïne")) {
					Player player = e.getPlayer();
					//player.performCommand("effect " + player.getName() + " minecraft:slowness 1 255 true");
					//player.performCommand("effect " + player.getName() + " minecraft:nausea 1 4 true");
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1, 2, true));
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1, 4, true));
					player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 2);
					//player.performCommand("effect " + player.getName() + " minecraft:speed 30 4 true");
					//player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30, 4, true));
					//player.getInventory().removeItem(cokeIcon);
					//player.updateInventory();
				}
			}
			
			if (item.getType().equals(Material.LONG_GRASS) && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
				if (item.getItemMeta().getDisplayName() == ("§a§l§oWeed")) {
					Player player = e.getPlayer();
					//player.performCommand("effect " + player.getName() + " minecraft:slowness 1 255 true");
					player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 2);
					//player.performCommand("effect " + player.getName() + " minecraft:nausea 1638 0 true");
					//player.performCommand("effect " + player.getName() + " minecraft:slowness 1638 2 true");
					player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1638, 2, true));
					//player.performCommand("effect " + player.getName() + " minecraft:resistance 1638 4 true");
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1638, 4, true));
					//player.getInventory().removeItem(weedIcon);
					//player.updateInventory();
				}
			}
		}
	}
}
