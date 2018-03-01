package nl.skelic.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.drugs.Main;

public class Util {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Util(Main pluginInstance) {
		plugin = pluginInstance;
	}
	
	public void saveYML(File file, YamlConfiguration config) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(FileConfiguration config, File file) {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
