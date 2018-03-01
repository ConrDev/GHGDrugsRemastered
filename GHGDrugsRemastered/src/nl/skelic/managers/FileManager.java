package nl.skelic.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.drugs.Main;

public class FileManager {
	
	protected Main main;
	private File file;
	protected FileConfiguration config;
	
	public FileManager(Main main, String fileName) {
		this.main = main;
		this.file = new File(main.getDataFolder(), fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}
	
	public void PlayerDataManager(Main main, String fileName) {
		this.main = main;
		this.file = new File(main.getDataFolder() + File.separator + "PlayerData" + File.separator, fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}
	
	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
