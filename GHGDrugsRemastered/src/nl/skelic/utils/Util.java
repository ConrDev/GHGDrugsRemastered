package nl.skelic.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.skelic.drugs.Main;

@SuppressWarnings("unused")
public class Util {
	
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
